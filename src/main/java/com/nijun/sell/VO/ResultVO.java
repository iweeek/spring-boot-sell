package com.nijun.sell.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: nijun
 * Date: 2018/7/6
 * Time: 12:25 PM
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = 9178803610445970221L;

    /** 错误码. */
    private  Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体信息. */
    private T data;
}
