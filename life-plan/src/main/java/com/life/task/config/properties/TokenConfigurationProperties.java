package com.life.task.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lkj
 * @date 2021/5/19
 */
@Component
@ConfigurationProperties("token")
@Data
public class TokenConfigurationProperties {

    private Integer expireSeconds;

    private String jwtSecret;

}
