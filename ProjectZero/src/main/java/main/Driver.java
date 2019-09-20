package main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import beans.BankAccounts;
import beans.RegisteredUser;
import dao.BankAccountDAOImpl;
import dao.BankgAccountDAO;
import dao.RegisteredUserDAO;
import dao.RegisteredUserDAOImpl;
import dao.SuperUserStmts;
import dao.SuperUserStmtsImpl;
import dao.UserStmtsDAO;
import dao.UserStmtsDAOImpl;
import util.InvalidChoiceException;
import util.OverdraftException;


public class Driver {

	public static void main(String[] args) throws SQLException, IOException, OverdraftException, InvalidChoiceException {
		
		RegisteredUserDAO ru = new RegisteredUserDAOImpl();
		SuperUserStmts sus = new SuperUserStmtsImpl();
		UserStmtsDAO us = new UserStmtsDAOImpl();
		
		boolean login = true;
		while(login) {
	
		Scanner scanner = new Scanner(System.in);

		
		System.out.println("Welcome to Central Perk Bank! \n"
				+ "please choose one of the following options:\n"
				+ "\tA. Sign in \n"
				+ "\tB. Create an account");
		
		String choice = scanner.nextLine();

		switch(choice.toUpperCase()) {
			case "A":System.out.println("Enter your username:");
					String superUsername = scanner.nextLine();
					System.out.println("Enter your password");
					String superPassword = scanner.nextLine();
				
					boolean userIn = true;
					String greeting = "\nYou are a super user\n";
					String regGreeting = "\nYou are a regular user\n";
		
					while(userIn)	
						if(ru.getUserWithCred(superUsername, superPassword)==1) {
							System.out.println(greeting);
							greeting = "";
							System.out.println("Select from the following:\n\n"
							+ "1. View all users\t\t\6. Create an account\n"
							+ "2. Create a new user\t\t7. Delete an account\n"
							+ "3. Update existing user\t\t8. Make a deposit\n"
							+ "4. Delete a user\t\t9. Make a withdrawal\n"
							+ "5. View your Account\t\t10. logout\n");
					
							String choice2 = scanner.nextLine();
							switch((String)choice2) {
						
							case "1":	
								System.out.println(ru.getRegisteredUsers());
							break;								
							case "2": 
								Scanner myscanner = new Scanner(System.in);							
								System.out.println("Please enter a new Username: ");
								String nusrnme = myscanner.nextLine();
								System.out.println("Create a password: ");
								String npw = myscanner.nextLine();
								sus.createNewUser(nusrnme, npw);
							break;							
							case "3":
								System.out.println("Enter your new password: ");
								String newPassword = scanner.nextLine();
								sus.updatePassword(superUsername, newPassword);
							break;							
							case "4":
								try{System.out.println("Enter user Id for user which you want to delete");
								int id = scanner.nextInt();
								sus.deleteUser(id);	}		
								catch(InputMismatchException e) {
									System.out.println("That is not a valid account");}
							break;								
							case "5":
								us.getAccountWithId(superUsername);
							break;							
							case "6": 
								try {
								System.out.println("Please enter an initial deposit amount: ");
								double b = scanner.nextDouble();
								us.createAccount(b, superUsername);}
								catch(InputMismatchException d) {
									System.out.println("That is not a valid amount");}
							break;							
							case "7":
								System.out.println("Are you sure you would like to delete your account?");
								String confirmation = scanner.nextLine();
								confirmation.trim();
								if(confirmation.equalsIgnoreCase("yes")) {
									us.deleteAccount(superUsername);
								}else {
									System.out.println("Your account is still active");}	
							break;						
							case "8":
								try {
								System.out.println("Enter deposit amount: ");
								double deposit = scanner.nextDouble();
								us.makeDeposit(deposit, superUsername);}
								catch(InputMismatchException d) {
									System.out.println("That is not a valid amount");}
							break;							
							case "9":
								try {
								System.out.println("Enter your withdrawal amount: ");
								double withdrawalAmount = (double)scanner.nextDouble();
								us.makeWithdrawal(withdrawalAmount, superUsername);}
								catch(InputMismatchException d) {
									System.out.println("That is not a valid amount");}
							break;							
							case "10":
								System.out.println("GoodBye!\n\n");
								userIn=false;
						}
					}else if(ru.getUserWithCred(superUsername, superPassword)==0) {
							System.out.println(regGreeting);
							regGreeting="";
					
						System.out.println("Select from the following:\n\n"
								+ "1. View your Account\n"
								+ "2. Create an account\n"			
								+ "3. Delete an empty account\n"
								+ "4. Make a deposit\n"
								+ "5. Make a withdrawal\n"
								+ "6. logout\n");
					
					
							String choice2 = scanner.nextLine();
					
				switch((String)choice2) {
					
					case "1":
						us.getAccountWithId(superUsername);
					break;				
					case "2": 
						try{
						System.out.println("Please enter an initial deposit amount: ");
						double b = scanner.nextDouble();
						us.createAccount(b, superUsername);}
						catch(InputMismatchException e) {
						System.out.println("Please enter a valie amount");}
					break;
					case "3":
						System.out.println("Are you sure you would like to delete your account?");
						String confirmation = scanner.nextLine();
						confirmation.trim();
						if(confirmation.equalsIgnoreCase("yes")) {
							us.deleteAccount(superUsername);
						}else {
						System.out.println("Your account is still active");
						}
					break;
					case "4":
					try {
						System.out.println("Enter deposit amount: ");
						double deposit = scanner.nextDouble();
						us.makeDeposit(deposit, superUsername);}
						catch(InputMismatchException d) {
						System.out.println("That is not a valid amount");}
					break;		
					case "5":
					try {
						System.out.println("Enter your withdrawal amount: ");
						double withdrawalAmount = (double)scanner.nextDouble();
						us.makeWithdrawal(withdrawalAmount, superUsername);}
						catch(InputMismatchException d) {
						System.out.println("That is not a valid amount");}						
					break;
					case "6":
						System.out.println("Would you like to logout?");
						String logoutconfirm = scanner.nextLine();
						logoutconfirm.trim();
						if(logoutconfirm.equalsIgnoreCase("yes")) {
							System.out.println("Have a nice day!\n\n");
							userIn = false;
							break;}}
			}else if(ru.getUserWithCred(superUsername, superPassword)==2) {
				System.out.println("That username/password combination does not exist\n");
				break;
			}	
				break;			
				case "B":
					Scanner myscanner = new Scanner(System.in);							
					System.out.println("Please enter a new Username: ");
					String nusrnme = myscanner.nextLine();
					System.out.println("Create a password: ");
					String npw = myscanner.nextLine();
					sus.createNewUser(nusrnme, npw);
				break;
				default: 
					System.out.println("\n Invalid option. Please enter A or B\n");				
			}
		}
	}
}




					
	

