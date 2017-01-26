package com.bolo4963gmail.mygankio;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.bolo4963gmail.mygankio.RecyclerViewClasses.RecyclerViewAdapter;

import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private static final String TAG = "ExampleInstrumentedTest";

    @Inject RecyclerViewAdapter adapter;

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        if (adapter != null) {
            Log.d(TAG, "useAppContext: adapter is not null");
        }

    }
}
