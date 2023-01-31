package com.example.eagle.utils;


import static com.example.eagle.utils.Constants.KEY_TOKAN;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PreferenceUtils {
    private static String tokan;
    private static Context context;

    public  PreferenceUtils(){

    }

    public static boolean saveTokan(String token, Context context) {
        PreferenceUtils.tokan = tokan;
        PreferenceUtils.context = context;
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(KEY_TOKAN, token);
        prefsEditor.apply();
        return true;
    }

    public static String getTokan(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(KEY_TOKAN, null);
    }


}
