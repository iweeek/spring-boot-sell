package com.nijun.sell.repository;

import com.nijun.sell.dataobject.OrderMaster;
import com.nijun.sell.enums.OrderStatusEnum;
import com.nijun.sell.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: nijun
 * Date: 2018/7/6
 * Time: 2:40 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "abc123";

    @Test
    public void test() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerAddress("china");
        orderMaster.setOrderAmount(new BigDecimal(123));
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setBuyerPhone("12312345645");
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        OrderMaster orderMaster1 = repository.save(orderMaster);
        assertNotEquals(null, orderMaster1);
    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest pageRequest = new PageRequest(0, 3);
        Page<OrderMaster> orderMasters = repository.findByBuyerOpenid(OPENID, pageRequest);
        Assert.assertNotEquals(0, orderMasters.getTotalElements());
    }
}