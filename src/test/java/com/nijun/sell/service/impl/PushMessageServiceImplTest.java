package com.nijun.sell.service.impl;

import com.nijun.sell.dto.OrderDTO;
import com.nijun.sell.service.OrderService;
import com.nijun.sell.service.PushMessageService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * User: nijun
 * Date: 2018/7/8
 * Time: 3:34 PM
 * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PushMessageServiceImplTest {

    @Autowired
    private PushMessageService pushMessageService;

    @Autowired
    private OrderService orderService;
    @Test
    public void orderStatus() {
        OrderDTO orderDTO = orderService.findOne("1530865630423892014");
        pushMessageService.orderStatus(orderDTO);
    }
}