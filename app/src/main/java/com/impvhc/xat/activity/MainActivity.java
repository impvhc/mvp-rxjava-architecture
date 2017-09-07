package com.impvhc.xat.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.impvhc.xat.presenter.MainPresenter;
import com.impvhc.xat.view.MainView;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    MainView view;

    @Inject
    MainPresenter presenter;

    public static void start(Context context){
        Intent intent = new Intent(context,MainActivity.class);
        context.startActivity(intent);
        BaseActivity.transitionLeft((Activity) context);
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
