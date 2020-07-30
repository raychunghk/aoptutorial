package com.ray.dao;

import org.springframework.stereotype.Component;

@Component()
public class MemberDao {
    public String AddSSSSS(){
        System.out.println(getClass()+": in Accountdao ");
        return "hello:";
    }

    public void gotoSleep() {
        System.out.println("go to sleep");
    }
}
