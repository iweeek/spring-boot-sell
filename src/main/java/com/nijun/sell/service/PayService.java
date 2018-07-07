package com.nijun.sell.service;

import com.nijun.sell.dto.OrderDTO;

/**
 * User: nijun
 * Date: 2018/7/7
 * Time: 12:09 PM
 * Description:
 */
public interface PayService {

    void create(OrderDTO orderDTO);
}
