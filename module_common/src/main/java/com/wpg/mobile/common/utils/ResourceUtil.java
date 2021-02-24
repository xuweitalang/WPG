package com.wpg.mobile.common.utils;

import android.content.Context;

/**
 * 处理字符串类型id转换成R类资源int型id的问题。
 *
 * @author huangye
 */
public class ResourceUtil {

    private ResourceUtil() {
    }

    public static int getStringId(Context context, String name) {
        return context.getResources()
                .getIdentifier(name, "string", context.getPackageName());
    }

    public static int getDrawableId(Context context, String name) {
        return context.getResources()
                .getIdentifier(name, "drawable", context.getPackageName());
    }

}
