package com.nijun.sell.service;

import com.nijun.sell.dataobject.ProductCategory;
import com.nijun.sell.dataobject.ProductInfo;
import com.nijun.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: nijun
 * Date: 2018/7/6
 * Time: 10:23 AM
 */
public interface ProductService {

    ProductInfo findOne(String productId);

    /**
     * 查询所有在架商品
     * @return
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    // 加库存
    void increaseStock(List<CartDTO> cartDTOList);

    // 减库存
    void decreaseStock(List<CartDTO> cartDTOList);

    // 上架
    ProductInfo onSale(String productId);

    // 下架
    ProductInfo offSale(String productId);
}
