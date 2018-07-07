package com.nijun.sell.repository;

import com.nijun.sell.dataobject.OrderDetail;
import com.nijun.sell.dataobject.OrderMaster;
import com.nijun.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: nijun
 * Date: 2018/7/6
 * Time: 10:45 AM
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {


    List<OrderDetail> findByOrderId(String orderId);
}
