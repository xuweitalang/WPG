package com.wpg.mobile.common.base.mvp;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @Author: xuwei
 * @Date: 2021/2/18 15:52
 * @Description:
 */
public abstract class BasePresenter<M extends IModel, V extends IView> implements IPresenter<V>, LifecycleObserver {
    protected M mModel;
    protected V mView;
    private CompositeDisposable mCompositeDisposable;

    @Override
    public void attachView(V view) {
        this.mView = view;
        this.mModel = createModel();
        if (mView instanceof LifecycleOwner) {
            ((LifecycleOwner) mView).getLifecycle().addObserver(this);
            if (mModel != null && mModel instanceof LifecycleObserver) {
                ((LifecycleOwner) mView).getLifecycle().addObserver((LifecycleObserver) mModel);
            }
        }
        if (useEventBus()) {
            EventBus.getDefault().register(this);
        }
    }

    /**
     * 将 {@link Disposable} 添加到 {@link CompositeDisposable} 中统一管理
     * 可在 Activity onDestroy() 中使用 {@link #unDispose()} 停止正在执行的 RxJava 任务，避免内存泄漏(框架已自行处理)
     *
     * @param disposable
     */
    public void addDispose(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);// 将所有 Disposable 放入集中处理
    }

    @Override
    public void detachView() {
        if (useEventBus()) {
            EventBus.getDefault().unregister(this);
        }
        unDispose();
    }

    private void unDispose() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
            mCompositeDisposable = null;
        }
        if (mModel != null) {
            mModel.onDetach();
            this.mModel = null;
        }
        this.mView = null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(LifecycleOwner owner) {
        // detachView()
        owner.getLifecycle().removeObserver(this);
    }


    public boolean useEventBus() {
        return false;
    }

    public abstract M createModel();
}
