package com.nijun.sell.service.impl;

import com.nijun.sell.dataobject.OrderDetail;
import com.nijun.sell.dto.OrderDTO;
import com.nijun.sell.enums.OrderStatusEnum;
import com.nijun.sell.enums.PayStatusEnum;
import com.nijun.sell.service.OrderService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: nijun
 * Date: 2018/7/6
 * Time: 3:46 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {
    
    /** logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImplTest.class);

    @Autowired
    private OrderService orderService;

    private final String BUYER_OPENID = "101010";
    private final String ORDERID = "1530865630423892014";

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("倪小军");
        orderDTO.setBuyerAddress("中国");
        orderDTO.setBuyerOpenid(BUYER_OPENID);
        orderDTO.setBuyerPhone("12313123123");

        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("213123");
        orderDetail.setProductQuantity(5);
        orderDetailList.add(orderDetail);

        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setProductId("123456");
        orderDetail1.setProductQuantity(10);
        orderDetailList.add(orderDetail1);

        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO dto = orderService.create(orderDTO);
        LOGGER.info("【创建订单】result={}", dto);
        assertNotEquals(null, dto);
    }

    @Test
    public void findOne() {
        OrderDTO result = orderService.findOne(ORDERID);
        LOGGER.info("【查询单个订单】result={}", result.toString());
    }

    @Test
    public void findList() {
        PageRequest pageRequest = new PageRequest(0, 2);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID, pageRequest);
        assertNotEquals(0, orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne(ORDERID);
        OrderDTO result = orderService.cancel(orderDTO);
        assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findOne(ORDERID);
        OrderDTO result = orderService.finish(orderDTO);
        assertEquals(OrderStatusEnum.FINISH.getCode(), result.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne(ORDERID);
        OrderDTO result = orderService.paid(orderDTO);
        assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
    }

    @Test
    public void test() {
        PageRequest pageRequest = new PageRequest(0, 2);
        Page<OrderDTO> orderDTOPage = orderService.findList(pageRequest);
        assertNotEquals(0, orderDTOPage.getTotalElements());
        Assert.assertTrue("查询的所有订单", orderDTOPage.getTotalElements() > 0);
    }
}