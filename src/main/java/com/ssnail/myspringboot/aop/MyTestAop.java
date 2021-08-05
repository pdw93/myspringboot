package com.ssnail.myspringboot.aop;

import com.ssnail.myspringboot.application.user.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * aop笔记类
 *
 * @author pengdengwang
 * @since 2021/7/29
 */
@Aspect
public class MyTestAop {

    @Pointcut("within(com.ssnail.myspringboot.rpc.IOutService+)")
    public void beforePointCut(){}

    @Pointcut("args(user)")
    public void argsPointCut(User user){}


    @Before("execution(* com.ssnail.myspringboot.rpc.*.*(..)) && beforePointCut()")
    public boolean before(JoinPoint joinPoint) {
        System.out.println(joinPoint.toShortString());
        return true;
    }
}
