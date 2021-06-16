package com.ssnail.myspringboot.config;

import com.ssnail.myspringboot.application.user.Task;
import com.ssnail.myspringboot.application.user.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author pengdengwang
 * @since 2021/6/9
 */
@Configuration
public class TestMissingBeanConfig {

    @Bean
    public User getUser1(){
        return new User();
    }

//    @Bean
//    @ConditionalOnMissingBean(User.class)
//    public User getUser2(){
//        return new User();
//    }

    @Bean
    @ConditionalOnBean(User.class)
    public Task getTask() {
        return new Task();
    }
}
