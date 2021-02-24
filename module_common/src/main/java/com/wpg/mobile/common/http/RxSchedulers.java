package com.wpg.mobile.common.http;


import com.wpg.mobile.common.http.exception.ApiException;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Rx线程相关的切换
 */
public class RxSchedulers {

    public static <T> Observable<T> createCommonObservable(Observable<BaseHttpResult<T>> observable) {
        return observable.flatMap(new Function<BaseHttpResult<T>, Observable<T>>() {
            @Override
            public Observable<T> apply(BaseHttpResult<T> httpResult) throws Exception {
                if (ErrorCode.STATUS_OK.equals(httpResult.getErrorCode())) {
                    return Observable.just(httpResult.getResultData());
                } else {

                    return Observable.error(new ApiException(httpResult.getErrorCode()));
                }
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    public static <T> ObservableTransformer<T, T> applySchedulers() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(@NonNull Observable<T> upstream) {
                return upstream
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}