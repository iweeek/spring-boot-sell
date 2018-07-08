package com.nijun.sell.form;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import java.util.Date;

/**
 * User: nijun
 * Date: 2018/7/7
 * Time: 11:34 PM
 * Description:
 */
@Data
public class CategoryForm {

    /** 类目id. */
    private  Integer categoryId;

    /** 类目名字. */
    private  String categoryName;

    /** 类目编号. */
    private  Integer categoryType;

}
