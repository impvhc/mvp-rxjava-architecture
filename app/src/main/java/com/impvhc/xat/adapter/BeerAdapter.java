package com.impvhc.xat.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.impvhc.xat.R;
import com.impvhc.xat.model.BeerResponse;

import java.util.List;

/**
 * Created by victor on 9/6/17.
 */

public class BeerAdapter extends RecyclerView.Adapter<BeerViewHolder> {

    private final List<BeerResponse> mBeerResponseList;

    public BeerAdapter(List<BeerResponse> mBeerResponseList) {
        this.mBeerResponseList = mBeerResponseList;
    }

    @Override
    public BeerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_beer,parent,false);
        return new BeerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BeerViewHolder holder, int position) {
        BeerResponse beerResponse = mBeerResponseList.get(position);
        holder.setBeerName(beerResponse.getName());
        holder.setBeerDescription(beerResponse.getDescription());
    }

    @Override
    public int getItemCount() {
        return mBeerResponseList.size();
    }

    public void addItems(List<BeerResponse> beerResponses) {
        mBeerResponseList.addAll(beerResponses);
        notifyDataSetChanged();
    }
}
