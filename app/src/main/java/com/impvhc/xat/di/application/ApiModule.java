package com.impvhc.xat.di.application;

import com.impvhc.xat.api.client.AuthClient;
import com.impvhc.xat.api.service.AuthService;

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
    public AuthService provideSignInService(AuthClient authClient) {
        return new AuthService(authClient);
    }

    @ApplicationScope
    @Provides
    public AuthClient provideSignInClient(Retrofit retrofit) {
        return retrofit.create(AuthClient.class);
    }
}
