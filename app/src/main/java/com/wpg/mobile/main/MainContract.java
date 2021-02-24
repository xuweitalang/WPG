package com.wpg.mobile.main;


import com.wpg.mobile.common.base.mvp.IModel;
import com.wpg.mobile.common.base.mvp.IPresenter;
import com.wpg.mobile.common.base.mvp.IView;

/**
 * @Author: xuwei
 * @Date: 2021/2/19 16:36
 * @Description:
 */
public interface MainContract {
    interface View extends IView {
    }

    interface Model extends IModel {
    }

    interface Presenter extends IPresenter<View> {
    }
}
