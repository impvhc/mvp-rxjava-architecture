package com.impvhc.xat.presenter;

import android.view.MenuItem;

import com.impvhc.xat.R;
import com.impvhc.xat.adapter.MainAdapter;
import com.impvhc.xat.view.MainView;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by victor on 9/6/17.
 */

public class MainPresenter extends BasePresenter<Void,MainView> {

    @Inject
    MainAdapter mainAdapter;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    public MainPresenter(MainView view) {
        super(view);
    }

    @Override
    public void onCreate() {
        getActivityComponent(view).inject(this);
        compositeDisposable.add(getSubscriptionNavigation());
        compositeDisposable.add(getSubscriptionViewPager());
        mainAdapter.setCount(3);
        view.setAdapter(mainAdapter);
    }

    private Disposable getSubscriptionViewPager(){
        return view.getObservableViewPager().subscribe(integer -> {
            switch (integer) {
                case 0:
                    view.setNavigationPosition(R.id.navigation_home);
                    break;
                case 1:
                    view.setNavigationPosition(R.id.navigation_dashboard);
                    break;
                case 2:
                    view.setNavigationPosition(R.id.navigation_notifications);
                    break;
            }
        });
    }

    private Disposable getSubscriptionNavigation(){
        return view.getObservableNavigation().subscribe((MenuItem menuItem) -> {
            switch (menuItem.getItemId()) {
                case R.id.navigation_home:
                    view.setMessage(R.string.title_home);
                    view.setViewPagerPosition(0);
                    break;
                case R.id.navigation_dashboard:
                    view.setMessage(R.string.title_dashboard);
                    view.setViewPagerPosition(1);
                    break;
                case R.id.navigation_notifications:
                    view.setMessage(R.string.title_notifications);
                    view.setViewPagerPosition(2);
                    break;
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}
