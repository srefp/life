package com.sr.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author lkj
 * @date 2021/5/1
 */
@SpringBootApplication
@MapperScan("com.sr.core.mapper")
public class SrApplication {
    public static void main(String[] args) {
        SpringApplication.run(SrApplication.class, args);
    }
}
