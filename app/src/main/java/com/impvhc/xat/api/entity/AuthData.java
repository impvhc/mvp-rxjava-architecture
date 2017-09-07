
package com.impvhc.xat.api.entity;


import com.google.gson.annotations.SerializedName;

public class AuthData {

    @SerializedName("google")
    private GoogleData mGoogle;

    public GoogleData getGoogle() {
        return mGoogle;
    }

    public void setGoogle(GoogleData google) {
        mGoogle = google;
    }

}
