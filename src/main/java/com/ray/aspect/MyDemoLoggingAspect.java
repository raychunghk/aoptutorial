package com.ray.aspect;


import com.ray.Entity.Account;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    private static Logger mylogger = Logger.getLogger(MyDemoLoggingAspect.class.getName());

    @Around("execution(* com.ray.service.TrafficeFortuneService.getFortune(..))")
    public Object AroundAddFortuneAdvice(ProceedingJoinPoint jp) throws Throwable {

        /*
        Print method name
        get starting timestamp
        run method
        get ending timestamp
        compute duration.
         */

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
        LocalDateTime now = LocalDateTime.now();
        long begin = System.currentTimeMillis();
        mylogger.info("==>@Around start time:" + now.format(dtf));
        String method = jp.getSignature().toShortString();
        mylogger.info("===>THe @AROUND  advicer's targed method :" + method);

        Object result = null;
        try {
            result = jp.proceed();
        } catch (Throwable throwable) {

            mylogger.warning(throwable.getMessage());
            throw throwable;
            // result = "Majro error! but no error , helicopeter on teh wya!";
        }

        long end = System.currentTimeMillis();
        now = LocalDateTime.now();
        mylogger.info("==>@Around ending time:" + now.format(dtf));
        long duration = end - begin;

        mylogger.info("==>@Around Method " + method + " taken :" + duration / 1000.0 + " to execute");
        return result;
    }

    @After("execution(* com.ray.dao.AccountDao.findAccounts(..))")
    public void AfterFindAccousntAdvice(JoinPoint jp) {
        mylogger.info("===>THe @AFTER (finally) advicer's targed method :" + jp.getSignature().toShortString());

    }

    @AfterThrowing(
            pointcut = "execution(* com.ray.dao.AccountDao.findAccounts(..))"
            , throwing = "MyException")
    public void afterThrowingFindAccountAdvice(JoinPoint jp, Throwable MyException) {
        mylogger.info("===>THe @AfterThroiwng advicer's targed method :" + jp.getSignature().toShortString());
        mylogger.info("\r\n===>The Exception is : " + MyException.getMessage());
    }


    //add after returning
    @AfterReturning(
            pointcut = "execution(* com.ray.dao.AccountDao.findAccounts(..))"
            , returning = "rtnobj")
    public void afterReturningFindAccountAdvice(JoinPoint jp, List<Account> rtnobj) {
//print out the advising method
        mylogger.info("===>Executing @AfterReturning advice: Advising method" + jp.getSignature().toShortString());
        mylogger.info("\r\nReturning object is: " + rtnobj);
        ConvertFirstToUpperCase(rtnobj);
    }

    // @Before("com.ray.aspect.AOPExpressions.AllActionNotGetterandSetter()()")
    public void MyLoggingDemoAdvicex(JoinPoint jp) {
        mylogger.info("\n=====>>@Before advice");
        //show signature
        MethodSignature sign = (MethodSignature) jp.getSignature();
        mylogger.info("intercepting method(signature):" + sign.getName());
        //desplay method argements
        Object[] objs = jp.getArgs();

        Arrays.stream(objs).forEach((x) -> {
            mylogger.info("Arguments" + x);
            if (x instanceof Account) {
                Account a = (Account) x;
                mylogger.info("Account a.getnmae" + a.getName());
                mylogger.info("Account a.getlevel" + a.getLevel());
            }
        });
    }

    //@Before("execution(* com.ray.dao.*.Add*())")
    // @Before("execution(* com.ray.dao.*.Add*(..))")
    public void beforeAddAccountadvice() {
        System.out.println("\n===>Executing @Before advice on addAccount");
    }

    //@Before("execution(* com.ray.dao.*.Add*(*.*.Entity.Account, ..))")
    @Before("execution(* com.ray.dao.*.*(..))")
    public void beforeAddAccountwithAccountParamadvice() {
        System.out.println("\n===>Executing @Before advice with account param on addAccount\n");
    }

    public void ConvertFirstToUpperCase(List<Account> acs) {
        Account acc = acs.get(0);
        acs.forEach(x -> x.setName(x.getName().toUpperCase()));

    }
}
