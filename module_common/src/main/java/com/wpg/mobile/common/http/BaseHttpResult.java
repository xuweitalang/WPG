package com.wpg.mobile.common.http;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @author xuwei
 */
public class BaseHttpResult<T> implements Serializable {
    private static final long serialVersionUID = 2690553609250007325L;
    @SerializedName("success")
    private boolean success;

    @SerializedName("errorCode")
    private String errorCode;

    @SerializedName("errorMessage")
    private String errorMessage;

    @SerializedName("resultData")
    private T resultData;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getResultData() {
        return resultData;
    }

    public void setResultData(T resultData) {
        this.resultData = resultData;
    }

    @Override
    public String toString() {
        if (resultData != null) {
            return "BaseResponse{" +
                    "success=" + success +
                    ", errorCode='" + errorCode + '\'' +
                    ", errorMessage='" + errorMessage + '\'' +
                    ", resultData=" + resultData.toString() +
                    '}';
        } else {
            return "BaseResponse{" +
                    "success=" + success +
                    ", errorCode='" + errorCode + '\'' +
                    ", errorMessage='" + errorMessage + '\'' +
                    '}';
        }
    }
}
