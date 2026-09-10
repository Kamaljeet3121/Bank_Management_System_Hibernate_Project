package main;

import java.util.Scanner;

import menus.*;

public class Main {
	
	
	public static void main() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("=======================================\n"
						 + "===Welcome To Bank Management System===\n"
						 + "=======================================\n"
						 + "--Please Select from below--\n"
						 + "----------------------------\n"
						 + "-->1.Manage Banks\n"
						 + "-->2.Manage Branches\n"
						 + "-->3.Manage Customers\n"
						 + "-->4.Manage Accounts\n"
						 + "-->5.Manage Loans\n"
						 + "-->6.Exit");
		
		switch(in.nextInt()){
		case 1  -> BankMenu.bankMainMenu();
		case 2  -> BranchMenu.branchMainMenu();
		case 3  -> CustomerMenu.customerMainMenu();
		case 4  -> AccountMenu.accountMainMenu();
		case 5  -> LoanMenu.loanMainMenu();
		case 6  -> exitMethod();
		default -> {System.out.println("Invalid Input, Please try again..\n");
					main();
		}
	}
			
	}
	public static void exitMethod() {
		System.out.println("ThankYou for using the Application..\nGood-Bye.");
		System.exit(0);
		
	}
	
	public static void main(String[] args) {
//		Resources.getEntityManagerFactory();
		while(true) {
			main();
		}
	}
}
