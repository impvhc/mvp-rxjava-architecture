
package com.impvhc.xat.api.entity;


import com.google.gson.annotations.SerializedName;

public class GoogleData {

    @SerializedName("access_token")
    private String mAccessToken;
    @SerializedName("id")
    private String mId;

    public String getAccessToken() {
        return mAccessToken;
    }

    public void setAccessToken(String accessToken) {
        mAccessToken = accessToken;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }


    @Override
    public String toString() {
        return "GoogleData{" +
                "mAccessToken='" + mAccessToken + '\'' +
                ", mId='" + mId + '\'' +
                '}';
    }
}
