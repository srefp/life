package com.life.task;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author lkj
 * @date 2021/5/14
 */
@SpringBootTest
public class LogTest {

    private static final Logger log = LoggerFactory.getLogger("adminLogger");

    @Test
    public void testLog() {
        log.info("新增用户{}", "小明");
    }
}
