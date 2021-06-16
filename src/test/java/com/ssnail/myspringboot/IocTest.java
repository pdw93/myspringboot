package com.ssnail.myspringboot;

import com.ssnail.myspringboot.application.user.User;
import com.ssnail.myspringboot.config.AnnotationConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 容器测试类
 *
 * @author pengdengwang
 * @since 2021/6/10
 */
public class IocTest {

    /**
     * 测试{@link org.springframework.context.annotation.AnnotationConfigApplicationContext}
     */
    @Test
    public void testAnnotationConfigApplicationContext() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        User user = context.getBean(User.class);
        System.out.println(user.getName());
    }
}
