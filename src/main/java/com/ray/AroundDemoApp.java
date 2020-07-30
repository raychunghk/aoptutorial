package com.ray;

import com.ray.config.AOPConfig;
import com.ray.service.TrafficeFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class  AroundDemoApp {
    private static Logger mylogger = Logger.getLogger(AroundDemoApp.class.getName());
    public static void main(String[] args) {

//read spring config
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AOPConfig.class);


        //get bean from container
        TrafficeFortuneService fs = ctx.getBean(TrafficeFortuneService.class);
        mylogger.info("Main Program: Around Demo App");
        mylogger.info("Calling getFortune");
        String data = fs.getFortune();
        mylogger.info("\nReturned data from getFurtune:" + data);
        mylogger.info("\nFinsihed!");
        ctx.close();

    }


}
