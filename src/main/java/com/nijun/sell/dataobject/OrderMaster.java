package com.nijun.sell.dataobject;

import com.nijun.sell.enums.OrderStatusEnum;
import com.nijun.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: nijun
 * Date: 2018/7/6
 * Time: 1:39 PM
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    /** 订单id. */
    @Id
    private String orderId;

    /** 买家名字. */
    private String buyerName;
    /** 买家电话. */
    private String buyerPhone;
    /** 买家地址. */
    private String buyerAddress;
    /** 买家openId. */
    private String buyerOpenid;
    /** 总金额. */
    private BigDecimal orderAmount;
    /** 订单状态. */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    /** 支付状态. */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 创建时间. */
    private Date createTime;
    /** 更新时间. */
    private Date updateTime;
}
