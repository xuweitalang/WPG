package com.wpg.mobile.api;


import com.wpg.mobile.common.http.BaseHttpResult;
import com.wpg.mobile.main.entity.User;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @Author: xuwei
 * @Date: 2021/2/20 15:09
 * @Description:
 */
public interface ApiService {
    /**
     * 登录
     *
     * @return
     */
    @POST("app/login")
    Observable<BaseHttpResult<User>> login(@Body Map loginRequest);

}
