package com.nijun.sell.service.impl;

import com.nijun.sell.dataobject.ProductInfo;
import com.nijun.sell.enums.ProductStatusEnum;
import com.nijun.sell.service.ProductService;
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
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: nijun
 * Date: 2018/7/6
 * Time: 11:57 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    /** logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImplTest.class);

    @Autowired
    private ProductService service;

    @Test
    public void findOne() {
        ProductInfo productInfo = service.findOne("123456");
        assertNotNull(productInfo);
        LOGGER.info(productInfo.toString());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> upAll = service.findUpAll();
        assertNotEquals(0, upAll.size());
    }

    @Test
    public void findAll() {
        PageRequest pageRequest = new PageRequest(0, 2);
        Page<ProductInfo> all = service.findAll(pageRequest);
        assertNotEquals(0, all.getSize());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("122112");
        productInfo.setProductName("皮蛋粥");
        productInfo.setProductIcon("asd");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好喝的粥");
        productInfo.setCategoryType(2);
        productInfo.setProductStatus(0);
        ProductInfo result = service.save(productInfo);
        assertNotEquals(null, result);
    }

    @Test
    public void onSale() {
        ProductInfo productInfo = service.onSale("213123");
        assertTrue("商品上架不正确", productInfo.getProductStatus().equals(ProductStatusEnum.UP.getCode()));
    }

    @Test
    public void offSale() {
        ProductInfo productInfo = service.offSale("213123");
        assertTrue("商品下架不正确", productInfo.getProductStatus().equals(ProductStatusEnum.DOWN.getCode()));
    }
}