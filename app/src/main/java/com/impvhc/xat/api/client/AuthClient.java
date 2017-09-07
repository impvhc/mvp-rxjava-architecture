package com.impvhc.xat.api.client;

import com.impvhc.xat.api.entity.AuthRequest;
import com.impvhc.xat.model.AuthResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

import static com.impvhc.xat.Constant.HEADER_SESSION_TOKEN;

/**
 * Created by victor on 8/7/17.
 */

public interface AuthClient {
    @POST("users")
    Observable<AuthResponse> signUp(@Body AuthRequest authRequest);

    @GET("users/me")
    Observable<AuthResponse> me(@Header(HEADER_SESSION_TOKEN) String token);
}
