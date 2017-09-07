package com.impvhc.xat.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;

import com.google.android.gms.common.SignInButton;
import com.impvhc.xat.R;
import com.jakewharton.rxbinding2.view.RxView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;

/**
 * Created by victor on 9/6/17.
 */

public class SignInView extends CoordinatorLayout {
    private final ProgressDialog progressDialog = new ProgressDialog(getContext());

    @BindView(R.id.sign_in_button)
    SignInButton signInButton;

    public SignInView(Context context) {
        super(context);
        inflate(getContext(), R.layout.activity_sign_in, this);
        ButterKnife.bind(this);
        progressDialog.setMessage(getResources().getString(R.string.validating_user));
        signInButton.setSize(SignInButton.SIZE_STANDARD);
    }

    public Observable<Object> getObservableSignInBtn() {
        return RxView.clicks(signInButton);
    }

    public void showLoading(boolean loading) {
        if (loading) {
            progressDialog.show();
        } else {
            progressDialog.dismiss();
        }
    }

    public void showMessage(String message) {
        Snackbar.make(this, message, Snackbar.LENGTH_LONG).show();
    }
}
