package com.wpg.mobile.demo.debug;

import android.widget.Toast;

import com.wpg.mobile.common.base.BaseActivity;
import com.wpg.mobile.demo.databinding.DemoActivityDebugBinding;


public class Demo_DebugActivity extends BaseActivity<DemoActivityDebugBinding> {

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        viewBinding.tvTest.setOnClickListener(v -> Toast.makeText(Demo_DebugActivity.this, viewBinding.tvTest.getText().toString(), Toast.LENGTH_LONG).show());
    }

    @Override
    protected void start() {

    }
}
