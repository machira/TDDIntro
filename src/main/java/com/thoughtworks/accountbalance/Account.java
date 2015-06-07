package com.thoughtworks.accountbalance;

/**
 * Created by machira on 6/7/15.
 */
public class Account {
    double balance;

    Account(double balance){
        this.balance = balance;
    }

    public double deposit(double deposit){
        balance += deposit;
        return balance;
    }

    public double withdraw(double withdraw){
        if (withdraw < balance){
            balance -= withdraw;
        }
        return balance;
    }
}
