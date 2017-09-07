package com.impvhc.xat.di.activity;

import com.impvhc.xat.activity.MainActivity;
import com.impvhc.xat.activity.SignInActivity;
import com.impvhc.xat.activity.SplashActivity;
import com.impvhc.xat.presenter.MainPresenter;
import com.impvhc.xat.presenter.SignInPresenter;
import com.impvhc.xat.presenter.SplashPresenter;

import dagger.Subcomponent;

/**
 * Created by victor on 8/4/17.
 */
@ActivityScope
@Subcomponent(modules = { ActivityModule.class })
public interface ActivityComponent {

    void inject(SplashActivity splashActivity);

    void inject(SplashPresenter splashPresenter);

    void inject(SignInActivity signInActivity);

    void inject(SignInPresenter signInPresenter);

    void inject(MainActivity mainActivity);

    void inject(MainPresenter mainPresenter);
}
