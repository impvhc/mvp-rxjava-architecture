package com.impvhc.xat.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by victor on 9/6/17.
 */

public class ClassesResponse<T> {
    @SerializedName("results")
    T results;

    public T getResults(){
        return results;
    }
}
