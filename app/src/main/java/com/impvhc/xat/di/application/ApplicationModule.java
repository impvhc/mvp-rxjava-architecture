package com.impvhc.xat.di.application;

import android.app.Application;

import com.impvhc.xat.AppSharedPreferences;

import dagger.Module;
import dagger.Provides;

/**
 * Created by victor on 9/5/17.
 */

@Module
public class ApplicationModule {
    Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationScope
    Application providesApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationScope
    AppSharedPreferences providesSharedPreferences(Application application) {
        return new AppSharedPreferences(application);
    }
}
