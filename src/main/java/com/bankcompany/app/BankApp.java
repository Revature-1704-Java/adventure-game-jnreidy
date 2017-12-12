package com.bankcompany.app;

import java.io.*;
import java.util.*;

public class BankApp 
{
    private Set<String> userList = new TreeSet<>();
    
    public static void main( String[] args )
    {
	BankApp session = new BankApp();
	session.start();
    }

    public void start(){
	Parser p = new Parser();
	boolean stop = false;
	Scanner sc = new Scanner(System.in);
	while(!stop){
	    String input;
	    input = sc.nextLine();
	    p.parse(input);
	    stop = doCommand(input);
	}
    }

    public boolean doCommand(String command){
	if(command.equals("open")){
	    createAccount();
	    return false;
	} else if(command.equals("view")){
	    //	    viewAccount();
	    return false;
	} else if(command.equals("deposit")){
	    depositCommand();
	    return false;
	} else if(command.equals("withdraw")){
	    withdrawCommand();
	    return false;
	} else if(command.equals("quit")){
	    return true;
	} else {
	    return false;
	}
    }

    public void createAccount(){
	String filename = "";
	String input = "";
	boolean gtg = true;
	while(gtg){
	    System.out.println("Please enter unique user ID");
	    Scanner sc = new Scanner(System.in);
	    input = sc.nextLine();
	    if(userList.contains(input)){
		System.out.println("Non unique user ID please enter a unique user id");
	    } else { 
		userList.add(input);
		System.out.println("here");
		System.out.println(userList);
		gtg = false;
	    }
	    sc.close();
	}
	filename = input;
	filename = filename.concat("checkingaccount.txt");
	System.out.println(input + " " + filename);
	try (FileWriter fw = new FileWriter(filename)){
		float balance = 0.0f;
		String write = String.valueOf(balance);
		fw.write(write);
	    } catch (IOException ex){
	    ex.printStackTrace();
	}
	String savings = input;
	savings = savings.concat("savingsaccount.txt");
	System.out.println(input + " " + savings);
	try(FileWriter fw = new FileWriter(savings)){
		float balance = 0.0f;
		String write = String.valueOf(balance);
		fw.write(write);
	    } catch (IOException ex) {
	    ex.printStackTrace();
	}
		
    }

    public void depositCommand() {
	System.out.println("Which account would you like to deposit to?");
	Scanner sc = new Scanner(System.in);
	String input = "";
	input = input.concat(sc.nextLine());
	System.out.println("Please enter your userID");
	String username = sc.nextLine();
	System.out.println("Please enter amount to deposit");
	String amount = sc.nextLine();
	float deposit = Float.parseFloat(amount);
	if(input.equals("checking")){
	    CheckingAccount CheckA = new CheckingAccount();
	    String filename = username.concat("checkingaccount.txt");
	    try(BufferedReader br = new BufferedReader(new FileReader(filename))){
		    String balance = br.readLine();
		    float currentBalance = Float.parseFloat(balance);
		    CheckA.setBalance(currentBalance);
		    CheckA.deposit(deposit);
		} catch (IOException ex){
		ex.printStackTrace();
	    }
	    try(FileWriter fw = new FileWriter(filename)){
		    float balance = CheckA.getBalance();
		    String write = String.valueOf(balance);
		    fw.write(write);
		} catch (IOException ex) {
		ex.printStackTrace();
	    }
	} else if(input.equals("savings")){
	    SavingsAccount SaveA = new SavingsAccount();
	    String filename = username.concat("savingsaccount.txt");
            try(BufferedReader br = new BufferedReader(new FileReader(filename))){
                    String balance = br.readLine();
                    float currentBalance = Float.parseFloat(balance);
                    SaveA.setBalance(currentBalance);
                    SaveA.deposit(deposit);
                } catch (IOException ex){
                ex.printStackTrace();
            }
            try(FileWriter fw = new FileWriter(filename)){
                    float balance = SaveA.getBalance();
                    String write = String.valueOf(balance);
                    fw.write(write);
                } catch (IOException ex) {
                ex.printStackTrace();
            }
	}
	
    }
    public void withdrawCommand(){
	System.out.println("Which account would you like to withdraw from?");
        Scanner sc = new Scanner(System.in);
        String input = "";
        input = input.concat(sc.nextLine());
        System.out.println("Please enter your userID");
        String username = sc.nextLine();
        System.out.println("Please enter amount to withdraw");
        String amount = sc.nextLine();
        float deposit = Float.parseFloat(amount);
        if(input.equals("checking")){
            CheckingAccount CheckA = new CheckingAccount();
            String filename = username.concat("checkingaccount.txt");
            try(BufferedReader br = new BufferedReader(new FileReader(filename))){
                    String balance = br.readLine();
                    float currentBalance = Float.parseFloat(balance);
                    CheckA.setBalance(currentBalance);
                    CheckA.withdraw(deposit);
                } catch (IOException ex){
                ex.printStackTrace();
            }
            try(FileWriter fw = new FileWriter(filename)){
                    float balance = CheckA.getBalance();
                    String write = String.valueOf(balance);
                    fw.write(write);
                } catch (IOException ex) {
                ex.printStackTrace();
            }

	}
    }
}
