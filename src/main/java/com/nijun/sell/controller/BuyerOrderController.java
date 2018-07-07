package com.nijun.sell.controller;

import com.nijun.sell.VO.ProductInfoVO;
import com.nijun.sell.VO.ProductVO;
import com.nijun.sell.VO.ResultVO;
import com.nijun.sell.converter.OrderForm2OrderDTOConverter;
import com.nijun.sell.dataobject.OrderMaster;
import com.nijun.sell.dataobject.ProductCategory;
import com.nijun.sell.dataobject.ProductInfo;
import com.nijun.sell.dto.OrderDTO;
import com.nijun.sell.enums.ResultEnum;
import com.nijun.sell.exception.SellException;
import com.nijun.sell.form.OrderForm;
import com.nijun.sell.service.BuyerService;
import com.nijun.sell.service.CategoryService;
import com.nijun.sell.service.OrderService;
import com.nijun.sell.service.ProductService;
import com.nijun.sell.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: nijun
 * Date: 2018/7/6
 * Time: 12:24 PM
 */
@RestController
@Slf4j
@RequestMapping("/buyer/order")
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;

    // 创建订单 create
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm,
                                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info("【创建订单】参数不正确, orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO result = orderService.create(orderDTO);
        if (result == null) {
            log.error("【创建订单】创建订单失败");
            throw new SellException(ResultEnum.ORDER_CREATE_FAIL);
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("orderid", result.getOrderId());
        ResultVO success = ResultVOUtil.success(map);
        return success;
    }

    // 订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page",defaultValue = "0") Integer page,
                                         @RequestParam(value = "size",defaultValue = "10") Integer size) {
        if (StringUtils.isEmpty(openid)) {
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest pageRequest = new PageRequest(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, pageRequest);

        return ResultVOUtil.success(orderDTOPage.getContent());
    }

    // 查询订单详情 detail
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderid") String orderid) {
        if (StringUtils.isEmpty(openid)) {
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderid);
        ResultVO resultVO = ResultVOUtil.success(orderDTO);
        return resultVO;
    }

    // 取消订单 cancel
    @PostMapping("/cancel")
    public ResultVO<OrderDTO> cancel(@RequestParam("openid") String openid,
                       @RequestParam("orderid") String orderid) {

        OrderDTO orderDTO = buyerService.cancelOrder(openid, orderid);
        OrderDTO result = orderService.cancel(orderDTO);
        return ResultVOUtil.success();
    }

}
