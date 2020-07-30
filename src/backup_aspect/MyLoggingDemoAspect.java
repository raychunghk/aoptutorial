package com.ray.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyLoggingDemoAspect {

    @Before("com.ray.aspect.AOPExpressions.AllActionNotGetterandSetter()()")
    public void MyLoggingDemoAdvice() {
        System.out.println("\n=====>>@Before advice");


    }
}
