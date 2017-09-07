package com.impvhc.xat.di.application;

import com.impvhc.xat.api.client.AuthClient;
import com.impvhc.xat.api.client.BeerClient;
import com.impvhc.xat.api.service.AuthService;
import com.impvhc.xat.api.service.BeerService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by victor on 8/7/17.
 */

@Module
public class ApiModule {
    @ApplicationScope
    @Provides
    public AuthService providesSignInService(AuthClient authClient) {
        return new AuthService(authClient);
    }

    @ApplicationScope
    @Provides
    public AuthClient providesSignInClient(Retrofit retrofit) {
        return retrofit.create(AuthClient.class);
    }

    @ApplicationScope
    @Provides
    public BeerService providesBeerService(BeerClient beerClient) {
        return new BeerService(beerClient);
    }

    @ApplicationScope
    @Provides
    public BeerClient providesBeerClient(Retrofit retrofit) {
        return retrofit.create(BeerClient.class);
    }
}
