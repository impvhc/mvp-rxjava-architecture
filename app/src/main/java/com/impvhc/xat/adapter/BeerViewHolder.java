package com.impvhc.xat.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.impvhc.xat.R;
import com.impvhc.xat.XatApplication;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by victor on 9/6/17.
 */

public class BeerViewHolder extends RecyclerView.ViewHolder {

    @Inject
    Picasso picasso;

    @BindView(R.id.beer_name)
    TextView beerName;

    @BindView(R.id.beer_description)
    TextView beerDescription;

    @BindView(R.id.beer_image)
    ImageView beerImage;

    BeerViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        XatApplication.get().getApplicationComponent().inject(this);
    }

    void setBeerName(String name){
        beerName.setText(name);
    }

    void setBeerDescription(String description){
        beerDescription.setText(description);
    }

    void setBeerImage(String url){
        picasso.load(url).into(beerImage);
    }
}
