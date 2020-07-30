package com.ray.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCLoudLogAspect {
    @Before("com.ray.aspect.AOPExpressions.AllActionNotGetterandSetter()()")
    public void logToCLoudAsynAdvice() {
        System.out.println("\n=====>>Logging to cloud Async advice");

    }
}
