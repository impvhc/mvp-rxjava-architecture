package com.impvhc.xat.api.service;

import com.impvhc.xat.api.client.BeerClient;
import com.impvhc.xat.model.BeerResponse;
import com.impvhc.xat.model.ClassesResponse;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by victor on 9/6/17.
 */

public class BeerService {
    private BeerClient mBeerClient;

    public BeerService(BeerClient mBeerClient) {
        this.mBeerClient = mBeerClient;
    }

    public Observable<ClassesResponse<List<BeerResponse>>> beers(String session_token){
        return mBeerClient.beers(session_token);
    }
}
