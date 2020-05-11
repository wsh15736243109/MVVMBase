package com.baseandroidlibrary.application;

import android.app.Application;
import android.content.Context;

import com.baseandroidlibrary.R;
import com.baseandroidlibrary.Utils.ViewUtils.AdaptationUtil;
import com.baseandroidlibrary.Utils.log.MyLog;
import com.baseandroidlibrary.configure.DefaultConfig;
import com.baseandroidlibrary.interfaceClass.application.ApplicationInterface;

/**
 * Created by zy on 2018/7/3.
 */

public abstract class BaseApplication extends Application implements ApplicationInterface{

    public static Context sApplicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sApplicationContext = this;
        AdaptationUtil.init(sApplicationContext);
        initConfig();
        initConfigApp();
        MyLog.initLogger("http_log");
    }

    @Override
    public void initConfig() {
        DefaultConfig.activityConfigure .setNavigationBarAlpha(1f)
                .setNavigationColor(DefaultConfig.appDefaultColor)
                .setDefaultBar(true)
                .setBarColor(DefaultConfig.appDefaultColor)
//                .setBarHeight(AdaptationUtil.dip2px(60))
                .setBarHeight(60)
                .setResId(R.layout.actionbar_layout)
                .setTitleBarAlpha(1f)
                .setFullScreen(false)
                .setTitleViewColor(DefaultConfig.appDefaultColor);
    }


}
