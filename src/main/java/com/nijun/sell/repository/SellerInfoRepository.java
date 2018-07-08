package com.nijun.sell.repository;

import com.nijun.sell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * User: nijun
 * Date: 2018/7/8
 * Time: 12:07 AM
 * Description:
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {

    SellerInfo findByOpenid(String openid);
}
