package com.nijun.sell.service;

import com.nijun.sell.dataobject.SellerInfo;
import org.springframework.stereotype.Service;

/**
 * User: nijun
 * Date: 2018/7/8
 * Time: 12:14 AM
 * Description:
 */
public interface SellerService {


    /**
     * 通过openid查询卖家
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
