package com.impvhc.xat.fragment;

import android.support.v4.app.Fragment;

import com.impvhc.xat.XatApplication;
import com.impvhc.xat.di.fragment.FragmentComponent;
import com.impvhc.xat.di.fragment.FragmentModule;

/**
 * Created by victor on 9/6/17.
 */

public class BaseFragment extends Fragment{
    public FragmentComponent getFragmentComponent(Fragment fragment){
        return XatApplication.get()
                .getApplicationComponent()
                .plus(new FragmentModule(fragment));
    }
}
