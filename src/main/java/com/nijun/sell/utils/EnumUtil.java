package com.nijun.sell.utils;

import com.nijun.sell.enums.CodeEnum;

/**
 * User: nijun
 * Date: 2018/7/7
 * Time: 3:08 PM
 * Description: 枚举工具类
 */
public class EnumUtil {

    /**
     * 返回枚举类型中code与指定code相同的枚举变量。
     * @param code
     * @param enumClass
     * @param <T>
     * @return
     */
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
