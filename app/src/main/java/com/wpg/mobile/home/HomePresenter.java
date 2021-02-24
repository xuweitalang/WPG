package com.wpg.mobile.home;

import android.util.Log;

import com.wpg.mobile.common.base.mvp.BasePresenter;
import com.wpg.mobile.common.http.RxSchedulers;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xuwei
 * @Date: 2021/2/22 16:02
 * @Description:
 */
public class HomePresenter extends BasePresenter<HomeContract.Model, HomeContract.View> implements HomeContract.Presenter {
    private static final String TAG = "HomePresenter";

    @Override
    public HomeContract.Model createModel() {
        return new HomeModel();
    }

    @Override
    public void login() {
        Map<String, String> request = new HashMap();
        request.put("loginName", "huangdp");
        request.put("password", "123456");

        addDispose(mModel.login(request).compose(RxSchedulers.applySchedulers())
                .subscribe(userBaseHttpResult -> {
                    if (userBaseHttpResult.isSuccess()) {
                        Log.d(TAG, "login: " + userBaseHttpResult.getResultData().toString());
                        mView.loginSuccess(userBaseHttpResult.getResultData());
                    }
                }));
    }
}
