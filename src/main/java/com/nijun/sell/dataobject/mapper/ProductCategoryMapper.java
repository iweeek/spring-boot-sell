package com.nijun.sell.dataobject.mapper;

import com.nijun.sell.dataobject.ProductCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * User: nijun
 * Date: 2018/7/8
 * Time: 8:11 PM
 * Description:
 */
public interface ProductCategoryMapper {

    @Insert("insert into product_category(category_name, category_type) value(" +
            "#{categoryName, jdbcType=VARCHAR}, #{categoryType, jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    @Insert("insert into product_category(category_name, category_type) value(" +
            "#{categoryName, jdbcType=VARCHAR}, #{categoryType, jdbcType=INTEGER})")
    int insertByObject(ProductCategory productCategory);

    @Select("select * from product_category where category_type = #{categoryType}")
    @Results({
            @Result(column = "category_type", property = "categoryType"),
            @Result(column = "category_id", property = "categoryId"),
            @Result(column = "category_name", property = "categoryName"),
    })
    ProductCategory findByCategoryType(Integer categoryType);

    @Select("select * from product_category where category_name = #{categoryName}")
    @Results({
            @Result(column = "category_type", property = "categoryType"),
            @Result(column = "category_id", property = "categoryId"),
            @Result(column = "category_name", property = "categoryName"),
    })
    List<ProductCategory> findByCategoryName(String categoryName);


    @Update("update product_category set category_name = #{categoryName} where category_type = #{categoryType}")
    int updateByCategoryType(@Param("categoryName") String categoryName, @Param("categoryType")Integer categoryType);


    @Update("update product_category set category_name = #{categoryName} where category_type = #{categoryType}")
    int updateByObject(ProductCategory productCategory);


    @Delete("delete from  product_category where category_type = #{categoryType}")
    int deleteByCategoryType(@Param("categoryType")Integer categoryType);

    ProductCategory selectByCategoryType(Integer categoryType);

}
