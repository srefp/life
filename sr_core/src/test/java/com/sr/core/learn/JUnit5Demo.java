package com.sr.core.learn;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lkj
 * @date 2021/5/16
 */
@DisplayName("JUnit5功能测试")
public class JUnit5Demo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 断言：前面断言失败，后面的代码都不会执行
     */
    @DisplayName("测试简单断言")
    @Test
    public void testSimpleAssertions() {
        int cal = cal(2, 3);
        assertEquals(6, cal, "业务逻辑计算失败");
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertSame(obj1, obj2, "两个对象不一样");
    }

    public int cal(int i, int j) {
        return i + j;
    }

    @DisplayName("array assertion")
    @Test
    public void array() {
        assertArrayEquals(new int[]{2, 1}, new int[]{1, 2}, "数组不一致");
    }

    @DisplayName("测试DisplayName注解")
    @Test
    public void testDisplayName() {
        System.out.println(1);
        System.out.println(jdbcTemplate);
    }

    @Disabled
    @DisplayName("测试方法2")
    @Test
    public void test2() {
        System.out.println(2);
    }

    @RepeatedTest(5)
    public void test3() {
        System.out.println(5);
    }

    /**
     * 规定方法超时时间。超出时间测试出异常
     *
     * @throws InterruptedException 异常
     */
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    @Test
    public void testTimeout() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(500);
    }

    @BeforeEach
    public void testBeforeEach() {
        System.out.println("测试就要开始了...");
    }

    @AfterEach
    public void testAfterEach() {
        System.out.println("测试结束了...");
    }

    @BeforeAll
    public static void testBeforeAll() {
        System.out.println("所有测试就要开始了...");
    }

    @AfterAll
    public static void testAfterAll() {
        System.out.println("所有测试结束了...");
    }
}
