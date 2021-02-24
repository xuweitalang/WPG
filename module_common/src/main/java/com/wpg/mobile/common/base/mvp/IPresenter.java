package com.wpg.mobile.common.base.mvp;

/**
 * @Author: xuwei
 * @Date: 2021/2/18 15:34
 * @Description:
 */
public interface IPresenter<V extends IView> {
    void attachView(V view);

    void detachView();
}
