package com.wpg.mobile.home;


import com.wpg.mobile.common.base.mvp.BaseModel;
import com.wpg.mobile.common.http.BaseHttpResult;
import com.wpg.mobile.main.entity.User;
import com.wpg.mobile.utils.RetrofitUtil;

import java.util.Map;

import io.reactivex.Observable;

/**
 * @Author: xuwei
 * @Date: 2021/2/22 16:04
 * @Description:
 */
public class HomeModel extends BaseModel implements HomeContract.Model {

    @Override
    public Observable<BaseHttpResult<User>> login(Map loginRequest) {
        return RetrofitUtil.getHttpService().login(loginRequest);
    }
}
