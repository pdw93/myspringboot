package com.ssnail.myspringboot.aop;

import com.ssnail.myspringboot.rpc.IOutService;
import com.ssnail.myspringboot.rpc.OutServiceImpl;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.support.AopUtils;

/**
 * @author pengdengwang
 * @since 2021/7/29
 */
public class MyAopTest {

    @Test
    public void aopTest() {
        IOutService service = new OutServiceImpl();

        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(service);
        proxyFactory.addAspect(MyTestAop.class);

        IOutService proxy = proxyFactory.getProxy();
        proxy.getFirstUser();

        boolean jdkDynamicProxy = AopUtils.isJdkDynamicProxy(proxy);
        System.out.println("is jdk proxy " + jdkDynamicProxy);

        boolean cglibProxy = AopUtils.isCglibProxy(proxy);
        System.out.println("is cglib proxy " + cglibProxy);
    }
}
