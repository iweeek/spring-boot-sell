package com.nijun.sell.enums;

import lombok.Data;
import lombok.Getter;

/**
 * Created by IntelliJ IDEA.
 * User: nijun
 * Date: 2018/7/6
 * Time: 2:26 PM
 */
@Getter
public enum OrderStatusEnum implements CodeEnum {
    NEW(0, "新订单"),
    FINISH(1, "完结"),
    CANCEL(2, "已取消");

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
