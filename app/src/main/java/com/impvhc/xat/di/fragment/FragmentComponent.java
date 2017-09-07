package com.impvhc.xat.di.fragment;

import com.impvhc.xat.fragment.EmptyFragment;

import dagger.Subcomponent;

/**
 * Created by victor on 8/4/17.
 */
@FragmentScope
@Subcomponent(modules = { FragmentModule.class })
public interface FragmentComponent {
    void inject(EmptyFragment emptyFragment);
}
