package com.impvhc.xat.activity;

import android.os.Bundle;

import com.impvhc.xat.presenter.SplashPresenter;
import com.impvhc.xat.view.SplashView;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity {

    @Inject
    SplashView view;

    @Inject
    SplashPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent(this).inject(this);
        setContentView(view);
        presenter.onCreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
