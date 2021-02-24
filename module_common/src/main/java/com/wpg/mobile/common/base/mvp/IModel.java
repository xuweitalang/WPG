package com.wpg.mobile.common.base.mvp;

import io.reactivex.disposables.Disposable;

/**
 * @Author: xuwei
 * @Date: 2021/2/18 15:33
 * @Description:
 */
public interface IModel {
    void addDisposable(Disposable disposable);

    void onDetach();
}
