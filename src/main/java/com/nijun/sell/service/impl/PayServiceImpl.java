package com.nijun.sell.service.impl;

import com.lly835.bestpay.service.BestPayService;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.nijun.sell.dto.OrderDTO;
import com.nijun.sell.service.PayService;
import org.springframework.stereotype.Service;

/**
 * User: nijun
 * Date: 2018/7/7
 * Time: 12:10 PM
 * Description:
 */
@Service
public class PayServiceImpl implements PayService {


    @Override
    public void create(OrderDTO orderDTO) {
        BestPayService bestPayService = new BestPayServiceImpl();
    }
}
