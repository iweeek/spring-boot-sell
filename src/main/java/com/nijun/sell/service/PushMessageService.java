package com.nijun.sell.service;

import com.nijun.sell.dto.OrderDTO;

/**
 * User: nijun
 * Date: 2018/7/8
 * Time: 3:22 PM
 * Description:
 */
public interface PushMessageService {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
