package com.impvhc.xat.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.impvhc.xat.fragment.EmptyFragment;
import com.impvhc.xat.fragment.RecyclerFragment;

/**
 * Created by victor on 9/6/17.
 */

public class MainAdapter extends FragmentStatePagerAdapter {

    private int mTabCount;

    public MainAdapter(FragmentManager fm) {
        super(fm);
        mTabCount = 0;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return EmptyFragment.newInstance();
            case 1:
                return RecyclerFragment.newInstance();
            case 2:
                return EmptyFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mTabCount;
    }

    public void setCount(int mTabCount){
        this.mTabCount = mTabCount;
    }
}
