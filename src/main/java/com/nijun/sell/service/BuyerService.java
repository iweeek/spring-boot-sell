package com.nijun.sell.service;

import com.nijun.sell.dto.OrderDTO;

/**
 * User: nijun
 * Date: 2018/7/6
 * Time: 10:53 PM
 * Description: 买家
 */
public interface BuyerService {

    // 查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    // 取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
