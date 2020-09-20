package com.ray.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyLoggingAspectB {
    //tutorial #39, use full qualified package.class.method name to reference pointcut expression.
   // @Before("com.ray.aspect.AOPExpressions.AllActionNotGetterandSetter()")
    public void testAnalystAPI() {
        System.out.println("==>Order(1) Test combine point cut; perform API analyst : ");
    }
}
