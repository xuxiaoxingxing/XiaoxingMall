package com.xiaoxing.mvp_core.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPreferences 帮助类
 * Created by xuxing on 2016/3/30 0030.
 */
public class SharedPreferencesHelper {

    public static SharedPreferencesHelper spHelper;

    public static SharedPreferences preferences;

    public static SharedPreferences.Editor editor;

    public static SharedPreferencesHelper getInstance(Context mContext) {
        if (spHelper == null) {
            spHelper = new SharedPreferencesHelper();
//            preferences = mContext.getSharedPreferences("Preferences", Activity.MODE_PRIVATE);
            preferences = mContext.getSharedPreferences("TEXT", Activity.MODE_PRIVATE);
            editor = preferences.edit();
        }
        return spHelper;
    }

    public void putString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public String getString(String key) {
        return preferences.getString(key, "");
    }

    public void putInt(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    public int getInt(String key) {
        return preferences.getInt(key, 0);
    }

    public int getInt(String key, int flag) {
        return preferences.getInt(key, flag);
    }

    public void putBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    public boolean getBoolean(String key) {
        return preferences.getBoolean(key, false);
    }

    public boolean getBoolean(String key, boolean flag) {
        return preferences.getBoolean(key, flag);
    }

    public void removeString(String key) {
        editor.remove(key);
        editor.commit();
    }

}
