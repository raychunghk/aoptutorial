package com.ray.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPExpressions {
    @Pointcut("execution(* com.ray.dao.*.set*(..))")
    public void setter() {

    }
    @Pointcut("execution(* com.ray.dao.*.get*(..))")
    public void getter() {

    }
    @Pointcut("execution(* com.ray.dao.*.*(..))")
    public void allmethod() {

    }

    @Pointcut("allmethod() && !(getter() || setter())")
    public void AllActionNotGetterandSetter() {
        //  System.out.println("===>>All action but not getter and setter");
    }
}
