package com.impvhc.xat;

import android.app.Application;

import com.impvhc.xat.di.application.ApplicationComponent;
import com.impvhc.xat.di.application.ApplicationModule;
import com.impvhc.xat.di.application.DaggerApplicationComponent;
import com.impvhc.xat.di.application.NetworkModule;

import net.danlew.android.joda.JodaTimeAndroid;

import timber.log.Timber;

import static com.impvhc.xat.Constant.BASE_URL;

/**
 * Created by victor on 9/5/17.
 */

public class XatApplication extends Application {
    private static XatApplication mAppContext;

    public static XatApplication get() {
        return mAppContext;
    }

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = (XatApplication) getApplicationContext();

        if(BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree(){
                @Override
                protected void log(int priority, String tag, String message, Throwable t) {
                    super.log(priority, Constant.LOG_TAG, message, t);
                }
            });
        }

        JodaTimeAndroid.init(this);

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(get()))
                .networkModule(new NetworkModule(BASE_URL))
                .build();
    }

    public ApplicationComponent getApplicationComponent(){
        return mApplicationComponent;
    }
}
