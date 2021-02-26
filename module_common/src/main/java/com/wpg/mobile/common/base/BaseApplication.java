package com.wpg.mobile.common.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.wpg.mobile.common.app.AppState;

/**
 * 项目父Application
 */
public abstract class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppState.getInstance().init(this);
        initLogger();
        initRouter();
    }

    private void initLogger() {
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    private void initRouter() {
        if (isDebug()) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }

    public abstract boolean isDebug();
}
