package com.nijun.sell.repository;

import com.nijun.sell.dataobject.OrderMaster;
import com.nijun.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * User: nijun
 * Date: 2018/7/6
 * Time: 10:45 AM
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {


    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
