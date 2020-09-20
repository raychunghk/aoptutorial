package com.ray.dao;

import com.ray.Entity.Account;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component()
public class AccountDao {

    public String getName() {
        System.out.println(getClass() + ": in getName ");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName ");
        this.name = name;
    }

    public String getServicecode() {
        System.out.println(getClass() + ": in getServicecode ");
        return servicecode;
    }

    public void setServicecode(String servicecode) {
        System.out.println(getClass() + ": in setServicecode ");
        this.servicecode = servicecode;
    }

    String name;
    String servicecode;

    public void AddAccount() {
        System.out.println(getClass() + ": in Accountdao ");
    }
    public void AddAccount(Account account) {
     //   account.setLevel(String.valueOf(isVIP));
        System.out.println(getClass() + ": in Accountdao with account parm only, account.name:"+account.getName());
    }
    public void AddAccount(Account account, boolean isVIP) {
        account.setLevel(String.valueOf(isVIP));
        System.out.println(getClass() + ": in Accountdao with account parm, and also vip param");
    }

    public List<Account> findAccounts(boolean tripWire) {
        List<Account> ac = new ArrayList<Account>();
        if (tripWire) {
            throw new RuntimeException("No soup for you!");
        }
        //create sample account
        ac.add(new Account("John", "Silver"));
        ac.add(new Account("Manson", "Platinujm"));
        ac.add(new Account("Luca", "Gold "));
        return ac;
    }

    /*
        public void AddAccount(Account account) {
            System.out.println(getClass() + ": in Accountdao with account parm");
        }*/
    public void dowork() {
        System.out.println("do work");
    }
}
