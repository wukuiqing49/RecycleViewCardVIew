package com.wkq.recyclerviewcardview;

import android.app.Application;
import android.content.Context;

/**
 * ================================================
 * 作者：WKQ
 * 时间:  2017/2/15 11:26
 * 用途:
 * 备注:
 * <p>
 * ================================================
 */

public class MyApplication extends Application {

    static  MyApplication instance= new MyApplication();
    static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
    }

    public static MyApplication getInstance() {
        return instance;
    }
    public static Context getMainContext() {
        return context;
    }
}
