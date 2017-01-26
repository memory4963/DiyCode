package com.bolo4963gmail.mygankio;

import android.app.Application;
import android.content.Context;

/**
 * Created by 10733 on 2017/1/26.
 */

public class App extends Application {

    private static Context ctx;

    @Override
    public void onCreate() {
        super.onCreate();
        ctx = this;
    }

    public static Context getContext() {
        return ctx;
    }
}
