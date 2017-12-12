package com.bankcompany.app;

import java.util.Scanner;

public class Parser {
    private String[] commands = {"open", "view", "deposit", "withdraw", "quit"};
    private Scanner sc = new Scanner(System.in);

    public boolean isCommand(String command){
	for(int i = 0; i < commands.length; i++){
            if(command.equals(commands[i])){
		return true;
	    }
	}
	return false;
    }
	
    public String parse(String input){
	//	String input;
	//	input = sc.nextLine();
	if(isCommand(input)){
	    return input;
	} else {
	    System.out.println("Not a valid command");
	    String str = "";
	    return str;
	}
    }
	    
}