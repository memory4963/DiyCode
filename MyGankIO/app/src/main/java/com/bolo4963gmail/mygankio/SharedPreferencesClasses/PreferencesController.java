package com.bolo4963gmail.mygankio.SharedPreferencesClasses;

import android.content.Context;
import android.content.SharedPreferences;

import com.bolo4963gmail.mygankio.App;

/**
 * Created by 10733 on 2017/1/27.
 */

public class PreferencesController {

    private static final String TOKEN = "token";
    private static final String REFRESH_TOKEN = "refresh_token";
    private static final String HEAD_IMAGE_PATH = "head_image_path";
    private static final String PREFERENCES_NAME = "shared_preferences";

    private static SharedPreferences sharedPreferences;

    public static void init() {
        sharedPreferences =
                App.getContext().getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);

        if (sharedPreferences.getString(TOKEN, "111").equals("111")) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(TOKEN, "");
            editor.putString(REFRESH_TOKEN, "");
            editor.putString(HEAD_IMAGE_PATH, "");
            editor.apply();
        }
    }

    public static String getString(String key) throws Exception {
        if (sharedPreferences == null) {
            throw new Exception(
                    "先调用init()再调用getSharedPreferences()。[Please invoke method init() first.]");
        }
        return sharedPreferences.getString(key, "");
    }

    public static void setPreferences(String key, String data) throws Exception {
        if (sharedPreferences == null) {
            throw new Exception(
                    "先调用init()再调用getSharedPreferences()。[Please invoke method init() first.]");
        }
        sharedPreferences.edit().putString(key, data).apply();
    }
    
}
