package com.bolo4963gmail.mygankio.AcitivityClasses;

import android.support.v7.app.AppCompatActivity;

import com.bolo4963gmail.mygankio.App;
import com.bolo4963gmail.mygankio.ReceiverClasses.NetworkChangeReceiver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10733 on 2017/1/15.
 */

public class ActivityCollector {

    private static List<BaseActivity> activities = new ArrayList<>();

    public static void add(BaseActivity activity) {
        activities.add(activity);
    }

    public static void remove(BaseActivity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {

        App.getContext().unregisterReceiver(NetworkChangeReceiver.ReceiverProvider.getReceiver());

        for (AppCompatActivity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
    
}
