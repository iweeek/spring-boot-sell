package com.nijun.sell.utils;

import com.nijun.sell.VO.ResultVO;

/**
 * User: nijun
 * Date: 2018/7/6
 * Time: 1:23 PM
 * Description: 接口返回实体封装工具
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(null);
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }


}
