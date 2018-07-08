package com.nijun.sell.dataobject.mapper;

import com.nijun.sell.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Procattr;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * User: nijun
 * Date: 2018/7/8
 * Time: 8:15 PM
 * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//@WebMvcTest
@Slf4j
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void insertByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("categoryName", "师兄最不爱");
        map.put("categoryType", 101);
        int result = mapper.insertByMap(map);
        assertEquals(1, result);
    }

    @Test
    public void insertByObject() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("师兄最不爱");
        productCategory.setCategoryType(100);
        int result = mapper.insertByObject(productCategory);
        assertEquals(1, result);
    }

    @Test
    public void findByCategoryType() {
        List<ProductCategory> categoryType = mapper.findByCategoryName("师兄最不爱");
        assertNotEquals(null, categoryType);
    }

    @Test
    public void updateByCategoryType() {
        int result = mapper.updateByCategoryType("师兄最爱的分类", 100);
        assertNotEquals(1, result);
    }

    @Test
    public void updateByObject() {
        ProductCategory productCategory = new ProductCategory("师兄最爱的分类", 101);
        int result = mapper.updateByObject(productCategory);
        assertNotEquals(1, result);
    }

    @Test
    public void deleteByCategoryType() {
        int result = mapper.deleteByCategoryType(100);
    }

    @Test
    public void selectByCategoryType() {
        ProductCategory productCategory = mapper.selectByCategoryType(100);
        assertNotNull(productCategory);
    }
}