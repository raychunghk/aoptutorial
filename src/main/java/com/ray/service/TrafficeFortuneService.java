package com.ray.service;

import com.ray.AroundDemoApp;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Component
public class TrafficeFortuneService {
    private static Logger mylogger = Logger.getLogger(TrafficeFortuneService.class.getName());

    public String getFortune() {
        try {
            mylogger.info("begin to wait in get fortune");
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "fail";
        }
        return "Expecte heavy traffic this morning";
    }

    public String getFortune(boolean tripWire) {
        if (tripWire) {
            throw new RuntimeException("Major Accident Highway closed");
        }
        try {
            mylogger.info("begin to wait in get fortune");
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "fail";
        }
        return getFortune();
    }
}
