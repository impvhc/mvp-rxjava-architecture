package com.impvhc.xat.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.LinearLayout;

import com.impvhc.xat.R;
import com.impvhc.xat.adapter.BeerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by victor on 9/4/17.
 */

public class RecyclerView extends LinearLayout {
    @BindView(R.id.recycler_beer)
    android.support.v7.widget.RecyclerView recyclerBeer;

    public RecyclerView(Context context) {
        super(context);
        inflate(getContext(), R.layout.view_recycler, this);
        ButterKnife.bind(this);
        recyclerBeer.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void setRecyclerViewAdater(BeerAdapter recyclerViewAdater) {
        recyclerBeer.setAdapter(recyclerViewAdater);
    }
}
