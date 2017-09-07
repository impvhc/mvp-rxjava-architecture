package com.impvhc.xat;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by victor on 8/7/17.
 */

public class AppSharedPreferences {

    private SharedPreferences mSharedPreferences;
    /**/
    private static final String EMPTY = "";
    private static final String EMAIL = "email";
    private static final String DISPLAY_NAME = "display_name";
    private static final String GOOGLE_ID_TOKEN = "id_token_google";
    private static final String GOOGLE_ID = "id_google";
    private static final String PARSE_ID = "id_parse";
    private static final String PARSE_SESSION_TOKEN = "session_token_parse";

    /**/

    public AppSharedPreferences(Context context) {
        mSharedPreferences = context.getSharedPreferences(context.getPackageName(),Context.MODE_PRIVATE);
    }

    /*Default Shared Preferences*/
    private void putString(String key, String value){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(key,value);
        editor.apply();
    }

    private void putInt(String key, int value){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(key,value);
        editor.apply();
    }

    private void putBoolean(String key, boolean value){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(key,value);
        editor.apply();
    }

    private String getString(String key){
        return mSharedPreferences.getString(key,EMPTY);
    }

    private int getInt(String key, int value){
        return mSharedPreferences.getInt(key,0);
    }

    private boolean getBoolean(String key, boolean value){
        return mSharedPreferences.getBoolean(key,false);
    }
    /**/

    public void putEmail(String email){
        putString(EMAIL,email);
    }

    public String getEmail(){
        return getString(EMAIL);
    }

    public void putDisplayName(String displayName) {
        putString(DISPLAY_NAME,displayName);
    }

    public String getDisplayName(){
        return getString(DISPLAY_NAME);
    }

    public void putIdGoogle(String id) {
        putString(GOOGLE_ID,id);
    }

    public String getIdGoogle(){
        return getString(GOOGLE_ID);
    }

    public void putIdTokenGoogle(String idToken) {
        putString(GOOGLE_ID_TOKEN,idToken);
    }

    public String getIdTokenGoogle() {
        return getString(GOOGLE_ID_TOKEN);
    }

    public void putIdParse(String objectId) {
        putString(PARSE_ID,objectId);
    }

    public String getIdParse() {
        return getString(PARSE_ID);
    }

    public void putParseSessionToken(String sessionToken) {
        putString(PARSE_SESSION_TOKEN,sessionToken);
    }

    public String getParseSessionToken() {
        return getString(PARSE_SESSION_TOKEN);
    }

}
