package com.ray.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyAPIAnalytistAspect {
    @Pointcut("execution(* com.ray.dao.*.*(..))")
    public void allmethod() {

    }
    /*
    @Before("allmethod()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>Executing @Before for AddAccount(No param)");

    }*/

    @Before("com.ray.aspect.AOPExpressions.AllActionNotGetterandSetter()")
    public void performAPIAnalyticsAdvice() {
        System.out.println("\n=====>>performAPIAnalytics(No param)");

    }


}
