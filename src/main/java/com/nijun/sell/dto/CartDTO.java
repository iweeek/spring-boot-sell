package com.nijun.sell.dto;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * User: nijun
 * Date: 2018/7/6
 * Time: 3:33 PM
 */
@Data
public class CartDTO {

    /* 商品Id. */
    private  String productId;
    /* 数量. */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
