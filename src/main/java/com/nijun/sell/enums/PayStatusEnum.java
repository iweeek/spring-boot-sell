package com.nijun.sell.enums;

import lombok.Getter;

/**
 * Created by IntelliJ IDEA.
 * User: nijun
 * Date: 2018/7/6
 * Time: 2:26 PM
 */
@Getter
public enum PayStatusEnum implements CodeEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付完成");
    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
