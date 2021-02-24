package com.wpg.mobile.demo.debug;

import android.util.Log;

import com.wpg.mobile.common.base.BaseApplication;
import com.wpg.mobile.common.constant.Cons;
import com.wpg.mobile.demo.BuildConfig;


public class DemoDebugApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(Cons.TAG, "order/debug/Order_DebugApplication");
    }

    @Override
    public boolean isDebug() {
        return BuildConfig.DEBUG;
    }
}
