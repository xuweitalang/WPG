package com.wpg.mobile.utils;


import com.wpg.mobile.api.ApiService;
import com.wpg.mobile.common.http.BaseRetrofit;

/**
 * @Author: xuwei
 * @Date: 2021/2/20 15:11
 * @Description:
 */
public class RetrofitUtil extends BaseRetrofit {
    private static ApiService httpService;

    public static ApiService getHttpService() {
        if (httpService == null) {
            httpService = getRetrofit().create(ApiService.class);
        }
        return httpService;
    }

}
