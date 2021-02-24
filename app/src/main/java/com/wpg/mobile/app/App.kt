package com.wpg.mobile.app

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import com.alibaba.android.arouter.launcher.ARouter
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import com.wpg.mobile.BuildConfig

/**
 * @author chenxz
 * @date 2018/12/22
 * @desc
 */
class App : Application() {

    private val TAG = "App"

    private var refWatcher: RefWatcher? = null

    companion object {
        fun getRefWatcher(context: Context): RefWatcher? {
            val app = context.applicationContext as App
            return app.refWatcher
        }
    }

    override fun onCreate() {
        super.onCreate()
        initLeakCanary()
        initRouter()
    }

    private fun initLeakCanary() {
        if (BuildConfig.DEBUG) {
            refWatcher = if (LeakCanary.isInAnalyzerProcess(this))
                RefWatcher.DISABLED
            else LeakCanary.install(this)

            registerActivityLifecycleCallbacks(mActivityLifecycleCallbacks)
        }
    }

    private fun initRouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }

    private val mActivityLifecycleCallbacks = object : ActivityLifecycleCallbacks {
        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            Log.d(TAG, "onCreated: " + activity.componentName.className)
        }

        override fun onActivityStarted(activity: Activity) {
            Log.d(TAG, "onStart: " + activity.componentName.className)
        }

        override fun onActivityResumed(activity: Activity) {
            Log.d(TAG, "onResume: " + activity.componentName.className)
        }

        override fun onActivityPaused(activity: Activity) {
            Log.d(TAG, "onPause: " + activity.componentName.className)
        }

        override fun onActivityStopped(activity: Activity) {
            Log.d(TAG, "onStop: " + activity.componentName.className)
        }

        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
            Log.d(TAG, "onSaveInstanceState: " + activity.componentName.className)
        }

        override fun onActivityDestroyed(activity: Activity) {
            Log.d(TAG, "onDestroy: " + activity.componentName.className)
        }
    }

}