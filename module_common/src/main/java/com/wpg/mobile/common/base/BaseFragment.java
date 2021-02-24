package com.wpg.mobile.common.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

import org.greenrobot.eventbus.EventBus;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Author: xuwei
 * @Date: 2021/2/22 15:02
 * @Description:
 */
public abstract class BaseFragment<VB extends ViewBinding> extends Fragment {
    public VB viewBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Type type = getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            try {
                Class<VB> clazz = (Class<VB>) ((ParameterizedType) type).getActualTypeArguments()[0];
                Method method = clazz.getDeclaredMethod("inflate", LayoutInflater.class, ViewGroup.class, boolean.class);
                viewBinding = (VB) method.invoke(null, getLayoutInflater(), container, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return viewBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (useEventBus()) {
            EventBus.getDefault().register(this);
        }
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
}
