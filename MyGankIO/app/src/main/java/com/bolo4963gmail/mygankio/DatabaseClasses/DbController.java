package com.bolo4963gmail.mygankio.DatabaseClasses;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by 10733 on 2017/1/26.
 */

class DbController {

    private static SQLiteDatabase db;

    static final String DB_NAME = "DiyCodeDb";
    static final String USER_INFORMATION = "user_information";
    static final String TOKEN = "token";
    static final String REFRESH_TOKEN = "refresh_token";
    static final String HEAD_IMAGE_PATH = "head_image_path";

    static SQLiteDatabase getDatabase() {
        if (db != null) {
            return db;
        }
        return null;
    }



}
