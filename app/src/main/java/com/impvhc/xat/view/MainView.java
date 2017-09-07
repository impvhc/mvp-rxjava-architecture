package com.impvhc.xat.view;

import android.content.Context;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.widget.TextView;

import com.impvhc.xat.R;
import com.impvhc.xat.adapter.MainAdapter;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.support.design.widget.RxBottomNavigationView;
import com.jakewharton.rxbinding2.support.v4.view.RxViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;

/**
 * Created by victor on 9/6/17.
 */

public class MainView extends CoordinatorLayout {

    @BindView(R.id.message)
    TextView message;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    @BindView(R.id.fragment_container)
    ViewPager fragmentContainer;

    public MainView(Context context) {
        super(context);
        inflate(getContext(), R.layout.activity_main, this);
        ButterKnife.bind(this);
    }

    public Observable<MenuItem> getObservableNavigation() {
        return RxBottomNavigationView.itemSelections(navigation);
    }

    public void setNavigationPosition(int id_item){
        navigation.setSelectedItemId(id_item);
    }

    public void setMessage(int id) {
        message.setText(id);
    }

    public void setAdapter(MainAdapter mainAdapter){
        fragmentContainer.setAdapter(mainAdapter);
    }

    public void setViewPagerPosition(int position){
        fragmentContainer.setCurrentItem(position,true);
    }

    public InitialValueObservable<Integer> getObservableViewPager(){
        return RxViewPager.pageSelections(fragmentContainer);
    }

}
