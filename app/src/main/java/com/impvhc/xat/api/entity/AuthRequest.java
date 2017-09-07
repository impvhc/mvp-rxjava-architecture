
package com.impvhc.xat.api.entity;

import com.google.gson.annotations.SerializedName;

public class AuthRequest {

    @SerializedName("authData")
    private AuthData mAuthData;
    @SerializedName("email")
    private String mEmail;

    public AuthData getAuthData() {
        return mAuthData;
    }

    public void setAuthData(AuthData authData) {
        mAuthData = authData;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

}
