package com.wpg.mobile.demo;


import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.wpg.mobile.common.constant.RoutePath;
import com.wpg.mobile.common.base.BaseActivity;
import com.wpg.mobile.demo.databinding.DemoActivityMainBinding;

@Route(path = RoutePath.ROUTE_DEMO_MAIN)
public class DemoMainActivity extends BaseActivity<DemoActivityMainBinding> {
    @Autowired
    String test;

    @Override
    protected void initData() {
        viewBinding.tvTest.setText(test == null ? "null" : test);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void start() {

    }
}