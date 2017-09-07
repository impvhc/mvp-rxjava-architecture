package com.impvhc.xat.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.impvhc.xat.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by victor on 9/6/17.
 */

public class BeerViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.beer_name)
    TextView beerName;

    @BindView(R.id.beer_description)
    TextView beerDescription;

    public BeerViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setBeerName(String name){
        beerName.setText(name);
    }

    public void setBeerDescription(String description){
        beerDescription.setText(description);
    }
}
