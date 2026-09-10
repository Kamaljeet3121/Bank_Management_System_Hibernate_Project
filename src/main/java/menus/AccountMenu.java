package menus;

import java.util.Scanner;

import crud.AccountCrud;
import main.Main;

public class AccountMenu {
	static Scanner in = new Scanner(System.in);
	public static void accountMainMenu() {
		System.out.println("=====Account Menu=====\n"
				 + "-->1.Create New Account\n"
				 + "-->2.View All Account\n"
				 + "-->3.Update Account\n"
				 + "-->4.Delete Account\n"
				 + "-->5.Back To Main Menu\n"
				 + "-->6.Exit\n");
		switch (in.nextInt()) {
		case 1  -> AccountCrud.createAccount();
		case 2  -> AccountCrud.fetchAllAccount();
		case 3  -> updateAccountMenu();
		case 4  -> AccountCrud.removeAccount();
		case 5  -> Main.main();
		case 6  -> Main.exitMethod();
		default ->{System.out.println("Invalid Input, Please try again..\n");
				   accountMainMenu();
			}
		}
	}
	public static void updateAccountMenu() {
		System.out.println("------------------------\n"
						 + "-->1.Update Account Type\n"
						 + "-->2.Update Account Balance\n"
						 + "-->3.Exit\n");
		switch(in.nextInt()) {
		case 1  -> AccountCrud.updateAccountType();
		case 2  -> AccountCrud.updateAccountBalance();
		case 3  -> Main.exitMethod();
		default -> {System.out.println("Invalid Input, Please try again..\n");
					updateAccountMenu();
			}
		}
	}
}

