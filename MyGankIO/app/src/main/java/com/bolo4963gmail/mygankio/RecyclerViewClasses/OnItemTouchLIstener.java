package com.bolo4963gmail.mygankio.RecyclerViewClasses;

import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;

/**
 * Created by 10733 on 2017/2/13.
 */

public abstract class OnItemTouchListener implements RecyclerView.OnItemTouchListener {

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
