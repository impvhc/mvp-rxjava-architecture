package com.impvhc.xat.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.impvhc.xat.presenter.SignInPresenter;
import com.impvhc.xat.view.SignInView;

import javax.inject.Inject;

public class SignInActivity extends BaseActivity {

    @Inject
    SignInView view;

    @Inject
    SignInPresenter presenter;

    public static void start(Context context){
        Intent intent = new Intent(context,SignInActivity.class);
        context.startActivity(intent);
        BaseActivity.transitionLeft((Activity) context);
        BaseActivity.finish((Activity) context);
    }

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
