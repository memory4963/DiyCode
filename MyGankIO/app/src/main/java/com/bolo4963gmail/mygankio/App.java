package com.bolo4963gmail.mygankio;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;

import com.bolo4963gmail.mygankio.ReceiverClasses.NetworkChangeReceiver;

/**
 * Created by 10733 on 2017/1/26.
 */

public class App extends Application {

    private static Context ctx;

    @Override
    public void onCreate() {
        super.onCreate();
        ctx = this;

        //动态注册BroadcastReceiver
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        registerReceiver(NetworkChangeReceiver.ReceiverProvider.getReceiver(), intentFilter);
    }

    public static Context getContext() {
        return ctx;
    }
}
