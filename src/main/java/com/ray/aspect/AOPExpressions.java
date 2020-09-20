package com.ray.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPExpressions {


    // @Pointcut("execution(* com.ray.dao.*.*(..))")
    @Pointcut("execution(* com.ray.dao.*.*(..))")
    public void alldaomethod() {
        System.out.println("==>Step 1 @point cut alldaomethod()");
    }

   // @Before("alldaomethod()")
    public void beforeAllMethodLogging() {
        System.out.println("==>Step 2 before all method? beforeAllMethodLogging");
    }

  //  @Before("alldaomethod()")
    public void beforeAllMethodAPIANALYST() {
        System.out.println("==>Step 3 before all method? beforeAllMethodAPIANALYST");
    }

    @Pointcut("execution(* com.ray.dao.*.set*(..))")
    public void setter() {

    }

    @Pointcut("execution(* com.ray.dao.*.get*(..))")
    public void getter() {

    }

    @Pointcut("alldaomethod() && !(getter() || setter())")
    public void AllActionNotGetterandSetter() {

    }

}
