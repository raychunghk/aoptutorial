package com.ray;

import com.ray.Entity.Account;
import com.ray.config.AOPConfig;
import com.ray.dao.AccountDao;
import com.ray.dao.MemberDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.logging.Logger;

public class AfterReturningApp {
    private static Logger mylogger = Logger.getLogger(AfterReturningApp.class.getName());

    public static void main(String[] args) {
        mylogger.info("hello");
//read spring config
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AOPConfig.class);


        //get bean from container
        AccountDao d = ctx.getBean(AccountDao.class);
        //calll business method
        MemberDao m = ctx.getBean(MemberDao.class);
        List<Account> acs = d.findAccounts(false);
        mylogger.info("In Main module, After returning from find account");
        mylogger.info("---");
        mylogger.info(acs.toString());
        mylogger.info("\b");
        acs.forEach(x -> mylogger.info("\n\nAccount returned in list:s" + x));
        ctx.close();

    }


}
