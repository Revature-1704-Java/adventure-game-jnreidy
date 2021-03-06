package com.bankcompany.app;

public abstract class Accounts{
    protected String accountID;
    protected float balance;
    protected float min = 0.0f;
    protected float maxDeposit = 9999.0f;

    public Accounts() {};
    
    public Accounts(String id, float balance){
	this.accountID = id;
	this.balance = balance;
    }
    public float getBalance(){
	return this.balance;
    }
    public void setBalance(float balance){
	this.balance = balance;
    }
    public String getAccountID(){
	return this.accountID;
    }
    public void setAccountID(String id){
	this.accountID = id;
    }
    public abstract void withdraw(float amount);

    public void deposit(float amount){
	if(maxDeposit > amount && amount > min){
	    this.balance += amount;
	} else {
	    System.out.println("Amount requested deposited is either to large or to negative.\nMax deposit per transaction = $9999.00");
	}
    }
    public float view(){
	return this.balance;
    }
}