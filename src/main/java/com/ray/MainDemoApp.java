package com.ray;

import com.ray.Entity.Account;
import com.ray.config.AOPConfig;
import com.ray.dao.AccountDao;
import com.ray.dao.MemberDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        System.out.println("hello");
//read spring config
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AOPConfig.class);


        //get bean from container
        AccountDao d = ctx.getBean(AccountDao.class);
        //calll business method
        MemberDao m = ctx.getBean(MemberDao.class);

        //d.AddAccount();
        d.setName ("hello");
        d.setServicecode("service");
        String name, ser;
        name = d.getName();
        ser = d.getServicecode();
        //d.dowork();
        //close the context
        m.gotoSleep();
        d.AddAccount(new Account("sdf", "level1"), true);
        ctx.close();

    }


}
