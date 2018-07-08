package com.nijun.sell.repository;

import com.nijun.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: nijun
 * Date: 2018/7/6
 * Time: 9:33 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void test() {
        ProductCategory productCategory = repository.findById(1).get();
        System.out.println(productCategory.toString());
    }

    @Test
//    @Transactional
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory("男生最爱", 4);
//        ProductCategoryMapper productCategory = repository.findById(1).get();
//        productCategory.setCategoryType(20);
        ProductCategory category = repository.save(productCategory);
        assertNotNull(category);
        assertNotEquals(null, category);
    }

    @Test
    public void findByCategoryTypeIn() {

        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> categories = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, categories.size());
    }
}