package com.nijun.sell.aspect;

import com.nijun.sell.constant.CookieConstant;
import com.nijun.sell.constant.RedisConstant;
import com.nijun.sell.exception.SellerAuthorizeException;
import com.nijun.sell.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * User: nijun
 * Date: 2018/7/8
 * Time: 2:17 PM
 * Description:
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Pointcut("execution(public * com.nijun.sell.controller.Seller*.*(..))" +
    "&& !execution(public * com.nijun.sell.controller.SellerUserController.*(..))")
    public void verify() {

    }

    @Before("verify()")
    public void doVerify() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        // 查询cookie
//        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
//        if (cookie == null) {
//            log.warn("【登录校验】Cookie中查不到token");
//            throw new SellerAuthorizeException();
//        }
//
//        // 去redis里查
//        String tokenValue = stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, CookieConstant.TOKEN));
//        if (StringUtils.isEmpty(tokenValue)) {
//            log.warn("【登录校验】Redis中查不到token");
//            throw new SellerAuthorizeException();
//        }
    }
}
