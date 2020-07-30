package com.ray;

import com.ray.Entity.Account;
import com.ray.config.AOPConfig;
import com.ray.dao.AccountDao;
import com.ray.dao.MemberDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {
    public static void main(String[] args) {
        System.out.println("hello");
//read spring config
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AOPConfig.class);


        //get bean from container
        AccountDao d = ctx.getBean(AccountDao.class);
        //calll business method
        MemberDao m = ctx.getBean(MemberDao.class);
        List<Account> acs = null;
        boolean tripWire = false;
        try {
            tripWire = true;
            acs = d.findAccounts(tripWire);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("In Main module, After Throwing from find account");
        System.out.println("---");
        System.out.println(acs);
        System.out.println("\b");
        acs.forEach(x -> System.out.println("\n\nAccount returned in list:s" + x));
        ctx.close();

    }


}
