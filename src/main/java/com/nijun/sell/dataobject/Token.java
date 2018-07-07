package com.nijun.sell.dataobject;

import lombok.Data;

/**
 * User: nijun
 * Date: 2018/7/7
 * Time: 8:50 AM
 * Description:
 */
@Data
public class Token {

    /** 接口访问凭证. */
    private  String accessToken;

    /** 凭证有效期，单位：秒. */
    private int expiresIn;
}
