package com.impvhc.xat.di.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.impvhc.xat.adapter.MainAdapter;
import com.impvhc.xat.presenter.MainPresenter;
import com.impvhc.xat.presenter.SignInPresenter;
import com.impvhc.xat.presenter.SplashPresenter;
import com.impvhc.xat.view.MainView;
import com.impvhc.xat.view.SignInView;
import com.impvhc.xat.view.SplashView;
import com.tbruyelle.rxpermissions2.RxPermissions;

import dagger.Module;
import dagger.Provides;

/**
 * Created by victor on 8/4/17.
 */

@Module
public class ActivityModule {
    private final Activity mActivity;

    public ActivityModule(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    @ActivityScope
    RxPermissions providesRxPermissions() {
        return new RxPermissions(mActivity);
    }

    @Provides
    @ActivityScope
    MainAdapter providesMainAdapter() {
        return new MainAdapter(((AppCompatActivity)mActivity).getSupportFragmentManager());
    }

    @Provides
    @ActivityScope
    public SplashView providesSplashView(){
        return new SplashView(mActivity);
    }

    @Provides
    @ActivityScope
    public SplashPresenter providesSplashPresenter(SplashView view){
        return new SplashPresenter(view);
    }

    @Provides
    @ActivityScope
    public SignInView providesSignInView(){
        return new SignInView(mActivity);
    }

    @Provides
    @ActivityScope
    public SignInPresenter providesSignInPresenter(SignInView view){
        return new SignInPresenter(view);
    }

    @Provides
    @ActivityScope
    public MainView providesMainView(){
        return new MainView(mActivity);
    }

    @Provides
    @ActivityScope
    public MainPresenter providesMainPresenter(MainView view){
        return new MainPresenter(view);
    }
}
