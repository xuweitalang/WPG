package com.wpg.mobile.demo.debug;

import com.orhanobut.logger.Logger;
import com.wpg.mobile.common.base.BaseApplication;
import com.wpg.mobile.demo.BuildConfig;


public class DemoDebugApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.d("order/debug/OrderDebugApplication");
    }

    @Override
    public boolean isDebug() {
        return BuildConfig.DEBUG;
    }
}
