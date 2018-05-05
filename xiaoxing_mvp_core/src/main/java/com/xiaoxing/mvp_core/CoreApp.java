package com.xiaoxing.mvp_core;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.chenenyu.router.Configuration;
import com.chenenyu.router.Router;
import com.xiaoxing.mvp_core.utils.SpUtil;

/**
 * Created by hpw on 16/10/28.
 */

public abstract class CoreApp extends Application {
    private static CoreApp mApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        SpUtil.init(this);


        // 初始化
        Router.initialize(new Configuration.Builder()
                // 调试模式，开启后会打印log
                .setDebuggable(BuildConfig.DEBUG)
                // 模块名，每个使用Router的module都要在这里注册
                .registerModules("app", "tad", "xiaoxing_mvp_core", "xiaoxing", "car", "bubbleseekbar","share","pay","order")
                .build());

    }

    public static synchronized CoreApp getInstance() {
        return mApp;
    }

    public static Context getAppContext() {
        return mApp.getApplicationContext();
    }

    public static Resources getAppResources() {
        return mApp.getResources();
    }

    public abstract String setBaseUrl();
}
