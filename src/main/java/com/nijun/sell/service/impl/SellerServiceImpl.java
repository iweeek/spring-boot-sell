package com.nijun.sell.service.impl;

import com.nijun.sell.dataobject.SellerInfo;
import com.nijun.sell.repository.SellerInfoRepository;
import com.nijun.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: nijun
 * Date: 2018/7/8
 * Time: 12:16 AM
 * Description:
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        SellerInfo sellerInfo = repository.findByOpenid(openid);
        return sellerInfo;
    }
}
