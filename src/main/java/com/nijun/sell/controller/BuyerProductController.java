package com.nijun.sell.controller;

import com.nijun.sell.VO.ProductInfoVO;
import com.nijun.sell.VO.ProductVO;
import com.nijun.sell.VO.ResultVO;
import com.nijun.sell.dataobject.ProductCategory;
import com.nijun.sell.dataobject.ProductInfo;
import com.nijun.sell.service.CategoryService;
import com.nijun.sell.service.ProductService;
import com.nijun.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: nijun
 * Date: 2018/7/6
 * Time: 12:24 PM
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {

        // 1. 查询所有商家商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        // 2. 查询类目（一次性）
        List<Integer> categoryTypeList = new ArrayList<>();
        // 传统做法
//        for (ProductInfo productInfo : productInfoList) {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        // 精简方法（java8，lambda）
        categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategories = categoryService.findByCategoryTypeIn(categoryTypeList);

        // 3. 数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategories) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
//                productInfoVO.setProductId(productInfo.getProductId());
//                productInfoVO.setProductName(productInfo.getProductName());
//                productInfoVO.setProductDescription(productInfo.getProductDescription());
//                productInfoVO.setProductIcon(productInfo.getProductIcon());
//                productInfoVO.setProductPrice(productInfo.getProductPrice());
                    BeanUtils.copyProperties(productInfo, productInfoVO);

                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);

            productVOList.add(productVO);
        }

        ResultVO success = ResultVOUtil.success(productVOList);

        return success;
    }
}
