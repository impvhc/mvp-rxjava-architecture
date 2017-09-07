package com.impvhc.xat.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.impvhc.xat.R;
import com.impvhc.xat.XatApplication;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import timber.log.Timber;

/**
 * Created by victor on 9/6/17.
 */

public class SignInUtil implements GoogleApiClient.OnConnectionFailedListener {

    private static final int RC_SIGN_IN = 9001;

    private static SignInUtil sSingleton;

    private PublishSubject<GoogleSignInAccount> mPublishSubject;

    public static SignInUtil getInstance(){
        if(sSingleton == null){
            sSingleton = new SignInUtil();
        }
        return sSingleton;
    }

    private GoogleApiClient mGoogleApiClient;

    private SignInUtil() {
        Context context = XatApplication.get();
        // [START configure_signin]
        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(context.getResources().getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        // [END configure_signin]
        // [START build_client]
        // Build a GoogleApiClient with access to the GoogleData Sign-In API and the
        // options specified by gso.
        mGoogleApiClient = new GoogleApiClient.Builder(context.getApplicationContext())
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .addOnConnectionFailedListener(this)
                .build();
        mGoogleApiClient.connect();
        // [END build_client]
    }

    public PublishSubject<GoogleSignInAccount> signIn(Activity activity){
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        activity.startActivityForResult(signInIntent, RC_SIGN_IN);
        mPublishSubject = PublishSubject.create();
        return mPublishSubject;
    }

    public Observable<GoogleSignInAccount> checkPendingResult(){
        return Observable.create(subscriber -> {
            OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(mGoogleApiClient);
            if (opr.isDone()) {
                // If the user's cached credentials are valid, the OptionalPendingResult will be "done"
                // and the GoogleSignInResult will be available instantly.
                GoogleSignInResult googleSignInResult = opr.get();
                if(googleSignInResult.isSuccess()){
                    subscriber.onNext(googleSignInResult.getSignInAccount());
                }else{
                    subscriber.onError(new Throwable(googleSignInResult.getStatus().getStatusMessage()));
                }
                subscriber.onComplete();
            } else {
                // If the user has not previously signed in on this device or the sign-in has expired,
                // this asynchronous branch will attempt to sign in the user silently.  Cross-device
                // single sign-on will occur in this branch.
                opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                    @Override
                    public void onResult(GoogleSignInResult googleSignInResult) {
                        if(googleSignInResult.isSuccess()){
                            subscriber.onNext(googleSignInResult.getSignInAccount());
                        }else{
                            subscriber.onError(new Throwable(googleSignInResult.getStatus().getStatusMessage()));
                        }
                        subscriber.onComplete();
                    }
                });
            }
        });
    }

    public boolean handleSignInResult(int requestCode, int resultCode, Intent data){
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                // Signed in successfully, show authenticated UI.
                GoogleSignInAccount acct = result.getSignInAccount();
                mPublishSubject.onNext(acct);
            }
            mPublishSubject.onComplete();
            return true;
        }else{
            return false;
        }
    }

    public void clearInstance(){

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Timber.d(connectionResult.getErrorMessage());
        mPublishSubject.onError(new Throwable(connectionResult.getErrorMessage()));
    }

}
