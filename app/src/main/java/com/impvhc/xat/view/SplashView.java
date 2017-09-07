package com.impvhc.xat.view;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;

import com.impvhc.xat.R;

/**
 * Created by victor on 9/5/17.
 */

public class SplashView extends CoordinatorLayout {

    public SplashView(Context context) {
        super(context);
        inflate(getContext(), R.layout.activity_splash, this);
    }

}
