package menus;

import java.util.Scanner;
import main.Main;
import crud.BankCrud;

public class BankMenu {
	static Scanner in = new Scanner(System.in);
	public static void bankMainMenu() {
		System.out.println("======Bank Menu======\n"
						 + "-->1.Create New Bank\n"
						 + "-->2.View All Banks\n"
						 + "-->3.Update Bank\n"
						 + "-->4.Delete Bank\n"
						 + "-->5.Back To Main Menu\n"
						 + "-->6.Exit");
		switch (in.nextInt()) {
		case 1  -> BankCrud.createBank();
		case 2  -> BankCrud.fetchAllBank();
		case 3  -> updateBankMenu();
		case 4  -> BankCrud.removeBank();
		case 5  -> Main.main();
		case 6  -> Main.exitMethod();
		default ->{System.out.println("Invalid Input, Please try again..\n");
				   bankMainMenu();
			}
		}
	}
	public static void updateBankMenu() {
		System.out.println("------------------------\n"
						 + "-->1.Update Bank Name\n"
						 + "-->2.Update Bank Address\n"
						 + "-->3.Exit\n");
		switch(in.nextInt()) {
		case 1  -> BankCrud.updateBankName();
		case 2  -> BankCrud.updateBankAddress();
		case 3  -> Main.exitMethod();
		default -> {System.out.println("Invalid Input, Please try again..\n");
					updateBankMenu();
			}
		}
	}
}
