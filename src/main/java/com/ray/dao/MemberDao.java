package com.ray.dao;

import org.springframework.stereotype.Component;

@Component()
public class MemberDao {
    public String AddAccountSSS(){
        System.out.println(getClass()+": in Accountdao AddAccountSSS   in member");
        return "hello:";
    }

    public void gotoSleep() {
        System.out.println("go to sleep");
    }
}
