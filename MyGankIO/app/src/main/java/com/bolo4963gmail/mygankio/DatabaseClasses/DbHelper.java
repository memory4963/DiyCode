package com.bolo4963gmail.mygankio.DatabaseClasses;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bolo4963gmail.mygankio.App;

/**
 * Created by 10733 on 2017/1/26.
 */

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(int version) {
        super(App.getContext(), DbController.DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
