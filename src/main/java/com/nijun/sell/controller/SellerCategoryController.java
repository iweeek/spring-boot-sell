package com.nijun.sell.controller;

import com.nijun.sell.dataobject.ProductCategory;
import com.nijun.sell.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * User: nijun
 * Date: 2018/7/7
 * Time: 10:43 PM
 * Description:
 */
@Controller
@Slf4j
@RequestMapping("/seller/category")
public class SellerCategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ModelAndView list(Map<String, String> map) {
        List<ProductCategory> productCategories = categoryService.findAll();


//        return new
    }
}
