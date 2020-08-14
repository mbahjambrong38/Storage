package com.baru.storage.preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private static String KEY_USERNAME = "key_userName";
    private static String KEY_USERID = "key_userID";
    private static String KEY_USERPASSWORD = "key_userPassword";


    public static void setContext(Context ctx){
        sharedPreferences = ctx.getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
    }

    public static void actionLogin(String userName, String userPassword, int userID){
        editor = sharedPreferences.edit();
        editor.putString(KEY_USERNAME, userName);
        editor.putString(KEY_USERPASSWORD, userPassword);
        editor.putInt(KEY_USERID, userID);
        editor.apply();

    }

    public static String getUserName(){
        return sharedPreferences.getString(KEY_USERNAME, null);
    }
    public static String getUserPassword(){
        return sharedPreferences.getString(KEY_USERPASSWORD, null);
    }
    public static int getUserID(){
        return sharedPreferences.getInt(KEY_USERID, 0);
    }
    public static void actionLogout(){
        editor = sharedPreferences.edit();
        editor.clear().apply();
    }

}
