package com.nijun.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: nijun
 * Date: 2018/7/6
 * Time: 10:31 AM
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {


    /** 商品id. */
    @Id
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
    /** 商品状态. */
    private Integer productStatus;
    /** 类目编号. */
    private Integer categoryType;

}
