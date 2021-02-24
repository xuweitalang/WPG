package com.wpg.mobile.home;

import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wpg.mobile.common.constant.RoutePath;
import com.wpg.mobile.common.base.mvp.BaseMvpFragment;
import com.wpg.mobile.databinding.FragmentHomeBinding;
import com.wpg.mobile.main.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xuwei
 */
public class HomeFragment extends BaseMvpFragment<FragmentHomeBinding, HomeContract.View, HomeContract.Presenter> implements HomeContract.View {

    private String mTitle;

    public static HomeFragment getInstance(String title) {
        HomeFragment fragment = new HomeFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        fragment.mTitle = title;
        return fragment;
    }

    @Override
    protected HomeContract.Presenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {
        super.initView();
        viewBinding.btnDemo.setOnClickListener(v -> ARouter.getInstance().build(RoutePath.ROUTE_DEMO_MAIN).
                withString("test", "传递参数").navigation());
        viewBinding.btnLogin.setOnClickListener(v -> login());

        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        TestAdapter adapter = new TestAdapter(getActivity(), list);
        viewBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        viewBinding.recyclerView.setAdapter(adapter);
    }

    private void login() {
        mPresenter.login();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void start() {

    }

    @Override
    public void loginSuccess(User user) {
        Toast.makeText(getActivity(), user.getUserId(), Toast.LENGTH_SHORT).show();
    }
}