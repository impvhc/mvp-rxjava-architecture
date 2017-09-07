package com.impvhc.xat.presenter;

import android.app.Activity;
import android.view.View;

import com.impvhc.xat.XatApplication;
import com.impvhc.xat.di.activity.ActivityComponent;
import com.impvhc.xat.di.activity.ActivityModule;

/**
 * Created by victor on 8/6/17.
 */

public abstract class BasePresenter<M,V>{

    protected M model;
    protected V view;

    protected BasePresenter(V view) {
        if (view == null) {
            throw new IllegalArgumentException("View must not be null");
        }
        this.view = view;
    }

    protected BasePresenter(M model, V view) {
        this(view);
        if (model == null) {
            throw new IllegalArgumentException("Model must be not be null");
        }
        this.model = model;
    }


    abstract public void onCreate();

    public void onDestroy(){
        this.model = null;
        this.view = null;
    }

    public ActivityComponent getActivityComponent(View view){
        return XatApplication.get()
                .getApplicationComponent()
                .plus(new ActivityModule((Activity) view.getContext()));
    }
}
