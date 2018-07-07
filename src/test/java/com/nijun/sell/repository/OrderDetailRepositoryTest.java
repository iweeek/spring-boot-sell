package com.nijun.sell.repository;

import com.nijun.sell.dataobject.OrderDetail;
import com.nijun.sell.dataobject.OrderMaster;
import com.nijun.sell.enums.OrderStatusEnum;
import com.nijun.sell.enums.PayStatusEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: nijun
 * Date: 2018/7/6
 * Time: 2:51 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;


    @Test
    public void test() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123456");
        orderDetail.setProductIcon("http://xxxxxxxxxx.jpg");
        orderDetail.setProductId("123456");
        orderDetail.setProductName("皮皮虾");
        orderDetail.setProductPrice(new BigDecimal(3.6));
        orderDetail.setProductQuantity(2);
        orderDetail.setOrderId("123456");

        OrderDetail orderDetail1 = repository.save(orderDetail);
        assertNotEquals(null, orderDetail1);
    }

    @Test
    public void findByOrderId() {

        List<OrderDetail> orderDetails = repository.findByOrderId("1234567");
        assertNotEquals(null, orderDetails);
    }
}