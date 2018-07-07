package com.nijun.sell.service.impl;

import com.nijun.sell.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: nijun
 * Date: 2018/7/6
 * Time: 10:26 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() {
        ProductCategory productCategory = categoryService.findOne(1);
        assertEquals(new Integer(1), productCategory.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> all = categoryService.findAll();
        assertNotEquals(0, all.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> list = Arrays.asList(2, 3, 4);
        List<ProductCategory> categories = categoryService.findByCategoryTypeIn(list);
        assertNotEquals(0, categories.size());
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory("儿童读物", 5);
        ProductCategory result = categoryService.save(productCategory);
        assertNotEquals(null, result);
    }
}