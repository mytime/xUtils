package com.yanwanfu.jikeutils;

import android.app.Application;

import org.xutils.x;

/**
 * Created by yanwanfu on 16/6/17.
 */
public class JikeApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化xUtils
        x.Ext.init(this);
    }
}
