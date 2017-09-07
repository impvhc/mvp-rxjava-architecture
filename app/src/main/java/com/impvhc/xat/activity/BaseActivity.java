package com.impvhc.xat.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.impvhc.xat.R;
import com.impvhc.xat.XatApplication;
import com.impvhc.xat.di.activity.ActivityComponent;
import com.impvhc.xat.di.activity.ActivityModule;
import com.impvhc.xat.util.SignInUtil;

/**
 * Created by victor on 9/5/17.
 */

public class BaseActivity extends AppCompatActivity {

    public ActivityComponent getActivityComponent(Activity activity){
        return XatApplication.get()
                .getApplicationComponent()
                .plus(new ActivityModule(activity));
    }

    public static void finish(Activity activity){
        activity.finish();
    }

    public static void transitionLeft(Activity activity){
        activity.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    public static void transitionRight(Activity activity){
        activity.overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        transitionRight(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        SignInUtil.getInstance().handleSignInResult(requestCode,resultCode,data);
    }
}
