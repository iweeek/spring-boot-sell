package com.nijun.sell.enums;

import lombok.Getter;

/**
 * Created by IntelliJ IDEA.
 * User: nijun
 * Date: 2018/7/6
 * Time: 3:09 PM
 */
@Getter
public enum ResultEnum {
    SUCCESS(0, "成功"),
    PARAM_ERROR(1, "参数不正确"),
    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11, "商品库存不正确"),
    ORDER_NOT_EXIST(12, "订单不存在"),
    ORDERDEATIL_NOT_EXIST(13, "订单详情不存在"),
    ORDER_STATUS_ERROR(14, "订单状态不正确"),
    ORDER_UPDATE_FAIL(15, "订单更新失败"),
    ORDER_DETAIL_EMPTY(16, "订单详情为空"),
    ORDER_PAY_STATUS_ERROR(17, "订单支付状态不正确"),
    ORDER_PAY_UPDATE_FAIL(18, "订单支付更新失败"),
    ORDER_CREATE_FAIL(19, "订单创建失败"),
    CART_EMPTY(20, "购物车不能为空"),
    ORDER_OWNER_ERROR(21, "该订单不属于当前用户"),
    WECHAT_MP_ERROR(22, "微信公众账号方面错误"),
    ORDER_CANCEL_SUCCESS(23, "订单取消成功"),
    ORDER_FINISH_SUCCESS(24, "订单完结成功"),
    PRODUCT_STATUS_ERROR(25, "商品状态不正确"),
    PRODUCT_ONSALE_SUCCESS(26, "商品上架成功"),
    PRODUCT_OFFSALE_SUCCESS(27, "商品下架成功"),
    PRODUCT_SAVE_SUCCESS(28, "商品保存成功"),
    CATEGORY_SAVE_SUCCESS(29, "类目保存成功"),
    LOGIN_FAIL(30, "登录失败"),
    LOGOUT_SUCCESS(31, "登出成功"),
    WECHAT_OPEN_ERROR(32, "微信开放平台方面错误"),

    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
