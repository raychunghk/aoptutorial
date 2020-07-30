package com.ray.aspect;


import com.ray.Entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("com.ray.aspect.AOPExpressions.AllActionNotGetterandSetter()()")
    public void MyLoggingDemoAdvice(JoinPoint jp) {
        System.out.println("\n=====>>@Before advice");
        //show signature
        MethodSignature sign = (MethodSignature) jp.getSignature();
        System.out.println("intercepting method(signature):" + sign.getName());
        //desplay method argements
        Object[] objs = jp.getArgs();
        Arrays.stream(objs).forEach((x) -> {
            System.out.println("Arguments" + x);
            if (x instanceof Account) {
                Account a = (Account) x;
                System.out.println("Account a.getnmae" + a.getName());
                System.out.println("Account a.getlevel" + a.getLevel());
            }
        });
    }
}
