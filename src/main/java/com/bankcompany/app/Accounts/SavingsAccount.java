package com.bankcompany.app;

public class SavingsAccount extends Accounts {
    public void withdraw(float amount){
	System.out.println("You can not directly withdraw from your Savings Account");
    }
}