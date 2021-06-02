package com.life.task.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lkj
 * @date 2021/5/20
 */
@Component
@ConfigurationProperties("login")
@Data
public class LoginConfigurationProperties {

    private String captchaType;

}
