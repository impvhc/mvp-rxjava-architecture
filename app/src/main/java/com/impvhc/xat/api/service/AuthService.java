package com.impvhc.xat.api.service;

import com.impvhc.xat.api.client.AuthClient;
import com.impvhc.xat.api.entity.AuthRequest;
import com.impvhc.xat.model.AuthResponse;

import io.reactivex.Observable;


/**
 * Created by victor on 8/7/17.
 */

public class AuthService {
    private AuthClient mAuthClient;

    public AuthService(AuthClient mAuthClient) {
        this.mAuthClient = mAuthClient;
    }

    public Observable<AuthResponse> signUp (AuthRequest request){
        return mAuthClient.signUp(request);
    }

    public Observable<AuthResponse> me (String session_token){
        return mAuthClient.me(session_token);
    }
}
