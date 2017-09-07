package com.impvhc.xat.presenter;

import com.impvhc.xat.view.EmptyView;

/**
 * Created by victor on 9/4/17.
 */

public class EmptyPresenter extends BasePresenter<Void,EmptyView> {
    public EmptyPresenter(EmptyView view) {
        super(view);
    }

    @Override
    public void onCreate() {

    }
}
