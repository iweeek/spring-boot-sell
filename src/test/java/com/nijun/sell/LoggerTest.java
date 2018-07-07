package com.nijun.sell;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by IntelliJ IDEA.
 * User: nijun
 * Date: 2018/7/5
 * Time: 7:54 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

    @Test
    public void test1() {
        String name = "nijun";
        String password = "123456";
        log.info("name: {}, password: {}", name, password);
        log.debug("debug...");
        log.info("info...");
        log.error("error...");
    }
}
