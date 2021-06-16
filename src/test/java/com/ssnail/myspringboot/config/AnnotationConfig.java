package com.ssnail.myspringboot.config;

import com.ssnail.myspringboot.application.user.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author pengdengwang
 * @since 2021/6/10
 */
@Configuration
public class AnnotationConfig {

    @Bean
    public User getUser() {
        return new User();
    }
}
