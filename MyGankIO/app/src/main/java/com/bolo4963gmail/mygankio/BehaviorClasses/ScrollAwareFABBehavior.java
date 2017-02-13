package com.bolo4963gmail.mygankio.BehaviorClasses;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;

import com.bolo4963gmail.mygankio.R;

/**
 * Created by 10733 on 2017/2/12.
 */

public class ScrollAwareFABBehavior extends FloatingActionButton.Behavior {

//    private static final Interpolator INTERPOLATOR = new FastOutSlowInInterpolator();
//    private boolean mIsAnimatingOut = false;
//
//    public ScrollAwareFABBehavior(Context context, AttributeSet attrs) {
//        super();
//    }
//
//    @Override
//    public boolean onStartNestedScroll(final CoordinatorLayout coordinatorLayout,
//                                       final FloatingActionButton child,
//                                       final View directTargetChild,
//                                       final View target,
//                                       final int nestedScrollAxes) {
//        // Ensure we react to vertical scrolling
//        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL || super.onStartNestedScroll(
//                coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
//    }
//
//    @Override
//    public void onNestedScroll(final CoordinatorLayout coordinatorLayout,
//                               final FloatingActionButton child,
//                               final View target,
//                               final int dxConsumed,
//                               final int dyConsumed,
//                               final int dxUnconsumed,
//                               final int dyUnconsumed) {
//        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed,
//                             dyUnconsumed);
//        if (dyConsumed > 0 && !this.mIsAnimatingOut && child.getVisibility() == View.VISIBLE) {
//            // User scrolled down and the FAB is currently visible -> hide the FAB
//            animateOut(child);
//        } else if (dyConsumed < 0 && child.getVisibility() != View.VISIBLE) {
//            // User scrolled up and the FAB is currently not visible -> show the FAB
//            animateIn(child);
//        }
//    }
//
//    // Same animation that FloatingActionButton.Behavior uses to hide the FAB when the AppBarLayout exits
//    private void animateOut(final FloatingActionButton button) {
//        if (Build.VERSION.SDK_INT >= 14) {
//            ViewCompat.animate(button)
//                    .translationY(button.getHeight() + getMarginBottom(button))
//                    .setInterpolator(INTERPOLATOR)
//                    .withLayer()
//                    .setListener(new ViewPropertyAnimatorListener() {
//
//                        public void onAnimationStart(View view) {
//                            ScrollAwareFABBehavior.this.mIsAnimatingOut = true;
//                        }
//
//                        public void onAnimationCancel(View view) {
//                            ScrollAwareFABBehavior.this.mIsAnimatingOut = false;
//                        }
//
//                        public void onAnimationEnd(View view) {
//                            ScrollAwareFABBehavior.this.mIsAnimatingOut = false;
//                            view.setVisibility(View.GONE);
//                        }
//                    })
//                    .start();
//        } else {
//
//        }
//    }
//
//    // Same animation that FloatingActionButton.Behavior uses to show the FAB when the AppBarLayout enters
//    private void animateIn(FloatingActionButton button) {
//        button.setVisibility(View.VISIBLE);
//        if (Build.VERSION.SDK_INT >= 14) {
//            ViewCompat.animate(button)
//                    .translationY(0)
//                    .setInterpolator(INTERPOLATOR)
//                    .withLayer()
//                    .setListener(null)
//                    .start();
//        }
//    }
//
//    private int getMarginBottom(View v) {
//        int marginBottom = 0;
//        final ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
//        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
//            marginBottom = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
//        }
//        return marginBottom;
//    }

    // TODO: 2017/2/12 完善FAB滑动问题
    private int toolbarHeight;

    public ScrollAwareFABBehavior(Context context, AttributeSet attrs) {
        super();
        this.toolbarHeight = getToolbarHeight(context);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton fab, View dependency) {
        return super.layoutDependsOn(parent, fab, dependency) || (dependency instanceof AppBarLayout);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton fab, View dependency) {
        boolean returnValue = super.onDependentViewChanged(parent, fab, dependency);
        if (dependency instanceof AppBarLayout) {
            CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
            int fabBottomMargin = lp.bottomMargin;
            int distanceToScroll = fab.getHeight() + fabBottomMargin;
            float ratio = (float)dependency.getY()/(float)toolbarHeight;
            fab.setTranslationY(-distanceToScroll * ratio);
        }
        return returnValue;
    }

    public static int getToolbarHeight(Context context) {
        final TypedArray styledAttributes = context.getTheme().obtainStyledAttributes(
                new int[]{R.attr.actionBarSize});
        int toolbarHeight = (int) styledAttributes.getDimension(0, 0);
        styledAttributes.recycle();

        return toolbarHeight;
    }
}
