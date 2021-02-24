package com.wpg.mobile.common.app;

import android.content.Context;

/**
 * @Author: xuwei
 * @Date: 2021/2/18 11:15
 * @Description: App 环境
 */
public class AppState {
    private Context mContext;

    private AppState() {
    }

    public static AppState getInstance() {
        return SingleHolder.INSTANCE;
    }

    public void init(Context application) {
        if (mContext != null && mContext != application) {
            throw new IllegalArgumentException("context has been init, there is another context try to init, please check");
        } else {
            mContext = application;
        }
    }

    public Context getContext() {
        if (mContext == null) {
            throw new RuntimeException("mContext didn't init, please init before getContext");
        }
        return mContext;
    }

    private static class SingleHolder {
        private static final AppState INSTANCE = new AppState();

        private SingleHolder() {
        }
    }
}
