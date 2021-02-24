package com.wpg.mobile.common.http;

/**
 * Created by monkey on 2017/12/1.
 * 一些状态码在前端需要做特殊处理，例如token过期，登录需要验证码等.
 */

public class ErrorCode {

    public static final String STATUS_OK = "200";

    public static final String NEED_IMAGE_CAPTCHA = "4110005";
    public static final String NEED_IMAGE_CAPTCHA_FOR_SECURITY = "4200010";
    public static final String IMAGE_CAPTCHA_EXPIRED = "4200007";
    public static final String IMAGE_CAPTCHA_WRONG = "4200008";

    public static final String TOKEN_INVALID = "4400001";
    public static final String TOKEN_EXPIRED = "4400002";

    public static final String PARAM_EXIST = "4000002";

    public static final String FACE_ID_NOT_BIND = "4700001";

    private ErrorCode() {
    }
}
