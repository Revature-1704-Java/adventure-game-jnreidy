package com.bankcompany.app;

public class CheckingAccount extends Accounts{
    public void withdraw(float amount){
	float newBalance = this.balance - amount;
	if(newBalance >= this.min){
	    this.balance = newBalance;
	} else {
	    System.out.println("Overdraft transaction cancelled");
	}
    }
}