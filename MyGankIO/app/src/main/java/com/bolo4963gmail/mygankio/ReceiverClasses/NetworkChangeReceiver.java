package com.bolo4963gmail.mygankio.ReceiverClasses;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Parcelable;

/**
 * Created by 10733 on 2017/1/31.
 */

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        //监听wifi开与关，与wifi连接无关
        if (WifiManager.WIFI_STATE_CHANGED_ACTION.equals(intent.getAction())) {
            int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, 0);
            switch (wifiState) {
                case WifiManager.WIFI_STATE_DISABLED:

                    break;
                case WifiManager.WIFI_STATE_DISABLING:

                    break;
                case WifiManager.WIFI_STATE_ENABLED:

                    break;
                case WifiManager.WIFI_STATE_ENABLING:

                    break;
                case WifiManager.WIFI_STATE_UNKNOWN:

                    break;
                default:
                    break;
            }
        }

        //监听是否连上了有效地无线路由
        if (WifiManager.NETWORK_STATE_CHANGED_ACTION.equals(intent.getAction())) {
            Parcelable parcelableExtra = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
            if (parcelableExtra != null) {
                NetworkInfo networkInfo = (NetworkInfo) parcelableExtra;
                NetworkInfo.State state = networkInfo.getState();
                boolean isConnected = state == NetworkInfo.State.CONNECTED;
                if (isConnected) {
                    //连接上了
                } else {
                    //未连接上
                }
            }
        }

        //监听网络的打开或关闭,
        //比上两个广播要慢
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            ConnectivityManager manager =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
            if (activeNetwork != null) {
                if (activeNetwork.isConnected()) {
                    if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                        //wifi可用
                    } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                        //移动网络可用
                    } else {
                        //无网络可用
                    }
                }
            }
        }

    }

    public static class ReceiverProvider {

        private static NetworkChangeReceiver receiver;

        /**
         * 非线程安全
         * @return receiver
         */
        public static NetworkChangeReceiver getReceiver() {
            if (receiver == null) {
                receiver = new NetworkChangeReceiver();
            }
            return receiver;
        }
    }

}
