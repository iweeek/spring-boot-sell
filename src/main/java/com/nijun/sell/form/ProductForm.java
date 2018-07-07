package com.nijun.sell.form;

import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * User: nijun
 * Date: 2018/7/7
 * Time: 10:11 PM
 * Description:
 */
@Data
public class ProductForm {

    /** 商品id. */
    private String productId;

    /** 商品名称. */
    private String productName;
    /** 单价. */
    private BigDecimal productPrice;
    /** 库存. */
    private Integer productStock;
    /** 商品描述. */
    private String productDescription;
    /** 小图. */
    private String productIcon;
    /** 类目编号. */
    private Integer categoryType;
}
