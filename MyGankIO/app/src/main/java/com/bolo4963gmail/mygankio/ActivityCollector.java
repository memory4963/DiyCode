package com.bolo4963gmail.mygankio;

import android.support.v7.app.AppCompatActivity;

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
        for (AppCompatActivity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        System.exit(0);
    }
    
}
