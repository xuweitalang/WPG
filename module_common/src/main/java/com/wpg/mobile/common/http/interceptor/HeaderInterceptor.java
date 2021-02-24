package com.wpg.mobile.common.http.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Author: xuwei
 * @Date: 2021/2/20 11:23
 * @Description: 设置请求头
 */
public class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        builder.addHeader("Content-type", "application/json; charset=utf-8");
        // .header("token", token);
        // .method(request.method(), request.body());
        return chain.proceed(builder.build());
    }
}
