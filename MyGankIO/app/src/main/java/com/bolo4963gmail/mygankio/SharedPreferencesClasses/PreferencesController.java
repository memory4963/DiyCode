package com.bolo4963gmail.mygankio.SharedPreferencesClasses;

import android.content.Context;
import android.content.SharedPreferences;

import com.bolo4963gmail.mygankio.App;

/**
 * Created by 10733 on 2017/1/27.
 */

public class PreferencesController {

    public static final String TOKEN = "token";
    public static final String REFRESH_TOKEN = "refresh_token";
    public static final String USER_NAME = "user_name";
    public static final String USER_MAIL = "user_mail";
    public static final String HEAD_IMAGE_URL = "head_image_path";
    public static final String PREFERENCES_NAME = "shared_preferences";

    private static SharedPreferences sharedPreferences;

    public static synchronized void init() {
        sharedPreferences =
                App.getContext().getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);

        if (sharedPreferences.getString(TOKEN, "111").equals("111")) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(TOKEN, "FIRST_TIME");
            editor.putString(REFRESH_TOKEN, "");
            editor.putString(USER_NAME, "");
            editor.putString(USER_MAIL, "");
            editor.putString(HEAD_IMAGE_URL, "");
            editor.apply();
        }
    }

    public static String getString(String key) {
        if (sharedPreferences == null) {
            init();
        }
        return sharedPreferences.getString(key, "");
    }

    public static void setPreferences(String key, String data) {
        if (sharedPreferences == null) {
            init();
        }
        sharedPreferences.edit().putString(key, data).apply();
    }
    
}
