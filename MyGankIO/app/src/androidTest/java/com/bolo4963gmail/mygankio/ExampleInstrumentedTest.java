package com.bolo4963gmail.mygankio;

import android.support.test.runner.AndroidJUnit4;

import com.bolo4963gmail.mygankio.ConnectionClasses.OkHttpConnection;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Map;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private static final String TAG = "ExampleInstrumentedTest";

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Map<String, String> map = OkHttpConnection.login("bolo4963@gmail.com", "456rtyFGHvbn");
        if (map != null) {
            System.out.print("token" + map.get("token"));
        }
    }
}
