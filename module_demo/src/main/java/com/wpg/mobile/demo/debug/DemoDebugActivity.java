package com.wpg.mobile.demo.debug;

import android.widget.Toast;

import com.wpg.mobile.common.base.BaseActivity;
import com.wpg.mobile.demo.databinding.DemoActivityDebugBinding;


public class DemoDebugActivity extends BaseActivity<DemoActivityDebugBinding> {

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        viewBinding.tvTest.setOnClickListener(v -> Toast.makeText(DemoDebugActivity.this, viewBinding.tvTest.getText().toString(), Toast.LENGTH_LONG).show());
    }

    @Override
    protected void start() {

    }
}
