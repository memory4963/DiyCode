package com.bolo4963gmail.mygankio.javaClasses;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Scroller;

import java.lang.ref.WeakReference;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by 10733 on 2016/12/14.
 */

public class HeaderScrollingBehavior extends CoordinatorLayout.Behavior<AppBarLayout> {

    private boolean isExpanded = false;
    private boolean isScrolling = false;

    private WeakReference<View> dependentView;
    private Scroller scroller;
    private Handler handler;

    public HeaderScrollingBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        scroller = new Scroller(context);
        handler = new Handler() {

            @Override
            public void close() {

            }

            @Override
            public void flush() {

            }

            @Override
            public void publish(LogRecord record) {

            }
        };
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, AppBarLayout child, View dependency) {
//        if (dependency != null && dependency.getId() == R.id.)
        return true;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent,
                                          AppBarLayout child,
                                          View dependency) {
        return true;
    }
}
