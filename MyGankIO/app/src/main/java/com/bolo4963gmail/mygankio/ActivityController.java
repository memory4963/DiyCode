package com.bolo4963gmail.mygankio;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10733 on 2017/1/15.
 */

public class ActivityController {

    private List<BaseActivity> activityList;

    final private ActivityController activityController = new ActivityController();

    final public synchronized ActivityController getInstance() {
        return activityController;
    }

    private ActivityController() {
        activityList = new ArrayList<>();
    }

    public void add(BaseActivity activity) {
        activityList.add(activity);
    }

    public void remove(BaseActivity activity) {
        activityList.remove(activity);
    }

    public void removeAll() {
        for (int i = 0; i < activityList.size(); i++) {
            activityList.remove(i);
        }
    }
    
}
