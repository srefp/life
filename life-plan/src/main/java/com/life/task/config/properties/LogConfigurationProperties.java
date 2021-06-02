package com.life.task.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lkj
 * @date 2021/5/19
 */
@Component
@ConfigurationProperties("log")
@Data
public class LogConfigurationProperties {

    private Level level;

    private String file;

    private String maxSize;

    @Data
    static class Level {
        private String root;
        private String my;
    }
}


