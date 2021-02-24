package com.wpg.mobile.home;


import com.wpg.mobile.common.base.mvp.IModel;
import com.wpg.mobile.common.base.mvp.IPresenter;
import com.wpg.mobile.common.base.mvp.IView;
import com.wpg.mobile.common.http.BaseHttpResult;
import com.wpg.mobile.main.entity.User;

import java.util.Map;

import io.reactivex.Observable;

/**
 * @Author: xuwei
 * @Date: 2021/2/22 15:50
 * @Description:
 */
public interface HomeContract {
    interface View extends IView {
        void loginSuccess(User user);
    }

    interface Model extends IModel {
        Observable<BaseHttpResult<User>> login(Map loginRequest);
    }

    interface Presenter extends IPresenter<View> {
        void login();
    }
}
