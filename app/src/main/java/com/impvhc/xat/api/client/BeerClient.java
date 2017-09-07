package com.impvhc.xat.api.client;

import com.impvhc.xat.model.BeerResponse;
import com.impvhc.xat.model.ClassesResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;

import static com.impvhc.xat.Constant.HEADER_SESSION_TOKEN;

/**
 * Created by victor on 9/6/17.
 */

public interface BeerClient {
    @GET("classes/test")
    Observable<ClassesResponse<List<BeerResponse>>> beers(@Header(HEADER_SESSION_TOKEN) String token);
}
