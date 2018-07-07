package com.nijun.sell.utils;

import java.util.Random;

import static java.lang.System.currentTimeMillis;

/**
 * User: nijun
 * Date: 2018/7/6
 * Time: 3:19 PM
 * Description: 生成随机数
 */
public class KeyUtil {

    public static synchronized String getUniqueKey(){
        Random random = new Random();
        Integer a = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(a);
    }
}
