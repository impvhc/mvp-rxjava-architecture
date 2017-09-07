package com.impvhc.xat.presenter;

import android.app.Activity;

import com.impvhc.xat.AppSharedPreferences;
import com.impvhc.xat.activity.BaseActivity;
import com.impvhc.xat.activity.MainActivity;
import com.impvhc.xat.activity.SignInActivity;
import com.impvhc.xat.api.service.AuthService;
import com.impvhc.xat.util.SignInUtil;
import com.impvhc.xat.view.SplashView;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by victor on 9/5/17.
 */

public class SplashPresenter extends BasePresenter<Void, SplashView> {

    @Inject
    AuthService authService;

    @Inject
    AppSharedPreferences appSharedPreferences;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public SplashPresenter(SplashView view) {
        super(view);
    }

    @Override
    public void onCreate() {
        getActivityComponent(view).inject(this);
        compositeDisposable.add(getSubscriptionCheckSignIn());
    }

    private Disposable getSubscriptionCheckSignIn() {
        return SignInUtil.getInstance().checkPendingResult()
                .subscribe(account -> {
                    compositeDisposable.add(getSubscriptionCheckSession());
                }, throwable -> {
                    SignInActivity.start(view.getContext());
                });
    }

    private Disposable getSubscriptionCheckSession(){
        return authService.me(appSharedPreferences.getParseSessionToken())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(authResponse -> {
                    MainActivity.start(view.getContext());
                    BaseActivity.finish((Activity) view.getContext());
                }, throwable -> {
                    SignInActivity.start(view.getContext());
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}
