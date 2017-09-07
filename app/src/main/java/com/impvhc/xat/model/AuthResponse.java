
package com.impvhc.xat.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class AuthResponse {

    @SerializedName("createdAt")
    private String mCreatedAt;
    @SerializedName("objectId")
    private String mObjectId;
    @SerializedName("sessionToken")
    private String mSessionToken;

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getObjectId() {
        return mObjectId;
    }

    public void setObjectId(String objectId) {
        mObjectId = objectId;
    }

    public String getSessionToken() {
        return mSessionToken;
    }

    public void setSessionToken(String sessionToken) {
        mSessionToken = sessionToken;
    }

}
