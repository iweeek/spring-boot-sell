package com.nijun.sell.service;

import com.nijun.sell.dataobject.ProductCategory;
import com.nijun.sell.dto.OrderDTO;
import org.aspectj.weaver.ast.Or;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: nijun
 * Date: 2018/7/6
 * Time: 10:23 AM
 */
public interface OrderService {

    /* 创建订单. */
    OrderDTO create(OrderDTO orderDTO);

    /* 查询单个订单. */
    OrderDTO findOne(String orderId);

    /* 查询订单列表 */
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /* 取消订单. */
    OrderDTO cancel(OrderDTO orderDTO);

    /* 完结订单. */
    OrderDTO finish(OrderDTO orderDTO);

    /* 支付订单. */
    OrderDTO paid(OrderDTO orderDTO);

    /* 查询订单列表 */
    Page<OrderDTO> findList(Pageable pageable);

}
