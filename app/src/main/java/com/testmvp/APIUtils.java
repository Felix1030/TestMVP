package com.testmvp;

import android.util.Log;

/**
 * Created by Master on 2017/9/6.
 */

public class APIUtils {

    public static String login(String userName, String password) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "success";
    }

    public static void login(String userName, String password, OnResultListener listener) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (null != listener) {
            Log.e("------","success");
            listener.onResult("success");
        }
    }
}
