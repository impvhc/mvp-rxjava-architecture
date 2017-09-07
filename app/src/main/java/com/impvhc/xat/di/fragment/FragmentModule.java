package com.impvhc.xat.di.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.impvhc.xat.presenter.EmptyPresenter;
import com.impvhc.xat.view.EmptyView;
import com.tbruyelle.rxpermissions2.RxPermissionsFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by victor on 8/4/17.
 */

@Module
public class FragmentModule {

    private Fragment mFragment;

    private Context mContext;

    public FragmentModule(Fragment mFragment) {
        this.mFragment = mFragment;
        this.mContext = mFragment.getContext();
    }

    @Provides
    @FragmentScope
    RxPermissionsFragment providesRxPermissions() {
        return new RxPermissionsFragment();
    }

    @Provides
    @FragmentScope
    public EmptyView providesEmptyView(){
        return new EmptyView(mContext);
    }

    @Provides
    @FragmentScope
    public EmptyPresenter providesEmptyPresenter(EmptyView view){
        return new EmptyPresenter(view);
    }
}
