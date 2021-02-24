package com.wpg.mobile.common.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import com.alibaba.android.arouter.launcher.ARouter;
import com.netease.common.utils.CommonUtil;
import com.netease.common.utils.KeyBoardUtil;

import org.greenrobot.eventbus.EventBus;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 项目父Activity
 */
public abstract class BaseActivity<VB extends ViewBinding> extends AppCompatActivity {
    public VB viewBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // 强制竖屏
        //利用反射，调用指定ViewBinding中的inflate方法填充视图
        Type superclass = getClass().getGenericSuperclass();
        if (superclass instanceof ParameterizedType) {
            //如果支持泛型
            try {
                Class<VB> clazz = (Class<VB>) ((ParameterizedType) superclass).getActualTypeArguments()[0];
                Method method = clazz.getMethod("inflate", LayoutInflater.class);
                viewBinding = (VB) method.invoke(null, getLayoutInflater());
            } catch (Exception e) {
                e.printStackTrace();
            }
            setContentView(viewBinding.getRoot());
        }

        if (useEventBus()) {
            EventBus.getDefault().register(this);
        }
        ARouter.getInstance().inject(this);
        initView();
        initData();
        start();
    }

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化 View
     */
    protected abstract void initView();

    /**
     * 开始请求
     */
    protected abstract void start();

    /**
     * 是否使用 EventBus
     */
    public boolean useEventBus() {
        return false;
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_UP) {
            View v = getCurrentFocus();
            // 如果不是落在EditText区域，则需要关闭输入法
            if (KeyBoardUtil.INSTANCE.isHideKeyboard(v, ev)) {
                KeyBoardUtil.INSTANCE.hideKeyBoard(this, v);
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (useEventBus()) {
            EventBus.getDefault().unregister(this);
        }
        CommonUtil.INSTANCE.fixInputMethodManagerLeak(this);
    }
}
