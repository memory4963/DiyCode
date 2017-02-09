package com.bolo4963gmail.mygankio.FIlesStoreClasses;

import android.content.Context;

import com.bolo4963gmail.mygankio.App;
import com.bolo4963gmail.mygankio.GsonClasses.TopicsGson;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by 10733 on 2017/1/31.
 */

public class FileStoreManager {

    public static final String FILE_NAME = "TempDiyCodeData";

    private static FileOutputStream out;
    private static FileInputStream in;

    public static void init() {
        try {
            out = App.getContext().openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            in = App.getContext().openFileInput(FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean setTopics(TopicsGson topicsGson) {
        if (out == null) {
            init();
        }
        ObjectOutputStream stream = null;
        try {
            stream = new ObjectOutputStream(out);
            stream.writeObject(topicsGson);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static TopicsGson getTopics() {
        if (in == null) {
            init();
        }

        ObjectInputStream stream = null;
        try {
            stream = new ObjectInputStream(in);
            return (TopicsGson) stream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
