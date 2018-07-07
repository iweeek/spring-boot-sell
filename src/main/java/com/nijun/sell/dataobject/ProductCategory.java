package com.nijun.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: nijun
 * Date: 2018/7/6
 * Time: 9:27 AM
 */
@Entity
@Data
@DynamicUpdate
public class ProductCategory {

    /** 类目id. */
    @Id
    /*Table 'spring.hibernate_sequence' doesn't exist*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer categoryId;

    /** 类目名字. */
    private  String categoryName;

    /** 类目编号. */
    @Column(unique = true)
    private  Integer categoryType;
    
    /** 创建时间. */
    @CreatedDate
    @Column(columnDefinition="timestamp default current_timestamp comment '创建时间'")
    private Date createTime;

    /** 更新时间. */
    @LastModifiedDate
    @Column(columnDefinition="timestamp default current_timestamp on update current_timestamp comment '更新时间'")
    private Date updateTime;

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    public ProductCategory() {
    }
}
