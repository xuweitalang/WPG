package com.wpg.mobile.common.http.exception;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import com.wpg.mobile.common.R;
import com.wpg.mobile.common.app.AppState;
import com.wpg.mobile.common.utils.ResourceUtil;


/**
 * @Author: xuwei
 * Api异常处理
 */
public class ApiException extends Exception {

    private static final String TAG = "ApiException";
    private final String mErrorCode;
    private final String mErrorMsg;

    public ApiException(String errorCode) {
        Log.d(TAG, "error:" + errorCode);
        mErrorCode = errorCode;
        mErrorMsg = getErrorMessage(errorCode);
    }

    public String getErrorCode() {
        return mErrorCode;
    }

    @Override
    public String getMessage() {
        return mErrorMsg;
    }

    @Override
    public String toString() {
        return "error code: " + mErrorCode + " message: " + mErrorMsg;
    }

    private String getErrorMessage(String errorCode) {
        Context context = AppState.getInstance().getContext();
        Resources res = context.getResources();
        int stringResId = ResourceUtil.getStringId(context, "error_msg_" + errorCode);
        return stringResId != 0 ? res.getString(stringResId) : res.getString(R.string.common_error_default);
    }
}
