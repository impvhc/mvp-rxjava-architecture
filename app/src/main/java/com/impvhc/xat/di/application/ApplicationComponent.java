package com.impvhc.xat.di.application;

import com.impvhc.xat.di.activity.ActivityComponent;
import com.impvhc.xat.di.activity.ActivityModule;
import com.impvhc.xat.di.fragment.FragmentComponent;
import com.impvhc.xat.di.fragment.FragmentModule;

import dagger.Component;

/**
 * Created by victor on 9/5/17.
 */

@ApplicationScope
@Component(modules = {ApplicationModule.class, NetworkModule.class, ApiModule.class})
public interface ApplicationComponent {
    ActivityComponent plus(ActivityModule activityModule);

    FragmentComponent plus(FragmentModule fragmentModule);
}


