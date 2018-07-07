package com.nijun.sell.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nijun.sell.dataobject.OrderDetail;
import com.nijun.sell.enums.OrderStatusEnum;
import com.nijun.sell.enums.PayStatusEnum;
import com.nijun.sell.utils.EnumUtil;
import com.nijun.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: nijun
 * Date: 2018/7/6
 * Time: 3:00 PM
 */
@Data
// 值为null的字段将不返回
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    /** 订单id. */
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
    private Integer orderStatus;
    /** 支付状态. */
    private Integer payStatus;
    /** 创建时间. */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    /** 更新时间. */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    private List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }
}
