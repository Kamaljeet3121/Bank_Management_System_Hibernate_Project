package menus;

import java.util.Scanner;

import crud.LoanCrud;
import main.Main;

public class LoanMenu {
	static Scanner in = new Scanner(System.in);
	public static void loanMainMenu() {
		System.out.println("=====Loan Menu=====\n"
				 + "-->1.Create New Loan\n"
				 + "-->2.View All Loan\n"
				 + "-->3.Update Loan\n"
				 + "-->4.Delete Loan\n"
				 + "-->5.Back To Main Menu\n"
				 + "-->6.Exit\n");
		switch (in.nextInt()) {
		case 1  -> LoanCrud.createLoan();
		case 2  -> LoanCrud.fetchAllLoans();
		case 3  -> updateLoanMenu();
		case 4  -> LoanCrud.removeLoan();
		case 5  -> Main.main();
		case 6  -> Main.exitMethod();
		default ->{System.out.println("Invalid Input, Please try again..\n");
				   loanMainMenu();
			}
		}
	}
	public static void updateLoanMenu() {
		System.out.println("------------------------\n"
						 + "-->1.Update Loan Type\n"
						 + "-->2.Update Loan Amount\n"
						 + "-->3.Exit\n");
		switch(in.nextInt()) {
		case 1  -> LoanCrud.updateLoanType();
		case 2  -> LoanCrud.updateLoanAmount();
		case 3  -> Main.exitMethod();
		default -> {System.out.println("Invalid Input, Please try again..\n");
					updateLoanMenu();
			}
		}
	}
}
