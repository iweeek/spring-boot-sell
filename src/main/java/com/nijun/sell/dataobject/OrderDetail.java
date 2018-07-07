package com.nijun.sell.dataobject;

import com.nijun.sell.enums.OrderStatusEnum;
import com.nijun.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by IntelliJ IDEA.
 * User: nijun
 * Date: 2018/7/6
 * Time: 1:39 PM
 */
@Entity
@Data
@DynamicUpdate
public class OrderDetail {

    /** 订单id. */
    @Id
    private String detailId;

    /** 订单名字. */
    private String orderId;

    /** 商品id. */
    private String productId;

    /** 商品名字. */
    private String productName;

    /** 商品价格. */
    private BigDecimal productPrice;

    /** 订购数量. */
    private int productQuantity;

    /** 商品图片. */
    private String productIcon;

//    /** 创建时间. */
//    private Timestamp createTime;
//
//    /** 更新时间. */
//    private Timestamp updateTime;


}
