package com.impvhc.xat.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.impvhc.xat.presenter.EmptyPresenter;
import com.impvhc.xat.view.EmptyView;

import javax.inject.Inject;

/**
 * Created by victor on 9/4/17.
 */

public class EmptyFragment extends BaseFragment {
    @Inject
    EmptyView view;

    @Inject
    EmptyPresenter presenter;

    public static EmptyFragment newInstance() {
        return new EmptyFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getFragmentComponent(this).inject(this);
        presenter.onCreate();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter.onDestroy();
    }
}
