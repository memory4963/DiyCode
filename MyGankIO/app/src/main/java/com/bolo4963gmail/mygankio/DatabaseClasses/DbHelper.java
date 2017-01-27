package com.bolo4963gmail.mygankio.DatabaseClasses;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bolo4963gmail.mygankio.App;

/**
 * Created by 10733 on 2017/1/26.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static DbHelper dbHelper;

    public DbHelper() {
        super(App.getContext(), DbController.DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //建立user_information表
        db.execSQL("create if not exists " + DbController.USER_INFORMATION_TABLE + " ("
                           + DbController.TOKEN + " text, "
                           + DbController.REFRESH_TOKEN + " text, "
                           + DbController.HEAD_IMAGE_PATH + " text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static void init() {
        dbHelper = new DbHelper();
    }

    public static DbHelper getDbHelper() throws Exception {
        if (dbHelper == null) {
            throw new Exception("请先调用init()方法。[Please invoke init() first.]");
        }
        return dbHelper;
    }

}
