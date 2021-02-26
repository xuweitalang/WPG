package com.wpg.mobile.home;

import com.orhanobut.logger.Logger;
import com.wpg.mobile.common.base.mvp.BasePresenter;
import com.wpg.mobile.common.http.BaseHttpResult;
import com.wpg.mobile.common.http.BaseObserver;
import com.wpg.mobile.main.entity.User;

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

        mModel.login(request).compose(applyBinding())
                .subscribe(new BaseObserver<User>(mView) {
                    @Override
                    public void onSuccess(BaseHttpResult<User> result) {
                        Logger.d(TAG, "login: " + result.getResultData().toString());
                        mView.loginSuccess(result.getResultData());
                    }

                    @Override
                    public void onFailure(String errMsg, boolean isNetError) {
                        Logger.e(errMsg);
                    }
                });
    }
}
