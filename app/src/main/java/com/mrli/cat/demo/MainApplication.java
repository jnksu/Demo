package com.mrli.cat.demo;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by MrLi on 2015/10/20.
 * 用于环境初始化
 */
public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
