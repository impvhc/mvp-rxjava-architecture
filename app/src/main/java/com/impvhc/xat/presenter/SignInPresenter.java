package com.impvhc.xat.presenter;

import android.app.Activity;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.impvhc.xat.AppSharedPreferences;
import com.impvhc.xat.activity.BaseActivity;
import com.impvhc.xat.activity.MainActivity;
import com.impvhc.xat.api.entity.AuthData;
import com.impvhc.xat.api.entity.AuthRequest;
import com.impvhc.xat.api.entity.GoogleData;
import com.impvhc.xat.api.service.AuthService;
import com.impvhc.xat.util.SignInUtil;
import com.impvhc.xat.view.SignInView;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by victor on 9/6/17.
 */

public class SignInPresenter extends BasePresenter<Void,SignInView> {

    @Inject
    AuthService authService;

    @Inject
    AppSharedPreferences appSharedPreferences;

    public SignInPresenter(SignInView view) {
        super(view);
    }

    @Override
    public void onCreate() {
        getActivityComponent(view).inject(this);
        compositeDisposable.add(getSubscriptionSignInBtn());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }

    private Disposable getSubscriptionSignInBtn(){
        return view.getObservableSignInBtn().subscribe(__ -> {
            compositeDisposable.add(signIn());
        });
    }
    private Disposable signIn(){
        return SignInUtil.getInstance().signIn((Activity) view.getContext()).subscribe(this::getSubscriptionSignUp, throwable -> {
            view.showLoading(false);
            view.showMessage(throwable.getMessage());
        });
    }

    private void getSubscriptionSignUp(GoogleSignInAccount account) {
        view.showLoading(true);
        GoogleData googleData = new GoogleData();
        googleData.setId(account.getId());
        googleData.setAccessToken(account.getIdToken());

        AuthData authData = new AuthData();
        authData.setGoogle(googleData);

        AuthRequest authRequest = new AuthRequest();
        authRequest.setAuthData(authData);
        authRequest.setEmail(account.getEmail());

        authService.signUp(authRequest)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(authResponse -> {
                    view.showLoading(false);
                    appSharedPreferences.putEmail(account.getEmail());
                    appSharedPreferences.putParseSessionToken(authResponse.getSessionToken());
                    MainActivity.start(view.getContext());
                    BaseActivity.finish((Activity) view.getContext());
                }, throwable -> {
                    view.showLoading(false);
                    view.showMessage(throwable.getMessage());
                });
    }

}
