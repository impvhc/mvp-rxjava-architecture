package com.impvhc.xat.view;

import android.content.Context;
import android.widget.LinearLayout;

import com.impvhc.xat.R;

import butterknife.ButterKnife;

/**
 * Created by victor on 9/4/17.
 */

public class EmptyView extends LinearLayout {
    public EmptyView(Context context) {
        super(context);
        inflate(getContext(), R.layout.view_empty, this);
        ButterKnife.bind(this);
    }
}
