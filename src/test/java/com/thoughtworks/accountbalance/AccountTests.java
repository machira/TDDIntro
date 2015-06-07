package com.thoughtworks.accountbalance;

import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

public class AccountTests {
    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        Account account = new Account(100);
        account.deposit(50);
        Assert.assertThat(account.balance, is(150));
    }
//
//    @Test
//    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
//
//    }
//
//    @Test
//    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
//
//    }
}
