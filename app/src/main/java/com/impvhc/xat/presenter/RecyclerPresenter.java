package com.impvhc.xat.presenter;

import com.impvhc.xat.AppSharedPreferences;
import com.impvhc.xat.adapter.BeerAdapter;
import com.impvhc.xat.api.service.BeerService;
import com.impvhc.xat.view.RecyclerView;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by victor on 9/4/17.
 */

public class RecyclerPresenter extends BasePresenter<Void,RecyclerView> {

    @Inject
    BeerService beerService;

    @Inject
    AppSharedPreferences appSharedPreferences;

    @Inject
    BeerAdapter beerAdapter;

    public RecyclerPresenter(RecyclerView view) {
        super(view);
    }

    @Override
    public void onCreate() {
        getActivityComponent(view).inject(this);
        compositeDisposable.add(getSubscriptionBeers());
        view.setRecyclerViewAdater(beerAdapter);
    }

    private Disposable getSubscriptionBeers(){
        return beerService.beers(appSharedPreferences.getParseSessionToken())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(beerResponses -> {
                    beerAdapter.addItems(beerResponses.getResults());
                });
    }
}
