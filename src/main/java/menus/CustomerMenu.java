package menus;

import java.util.Scanner;

import crud.CustomerCrud;
import main.Main;

public class CustomerMenu {
	static Scanner in = new Scanner(System.in);
	public static void customerMainMenu() {
		System.out.println("=====Customer Menu=====\n"
				 + "-->1.Create New Customer\n"
				 + "-->2.View All Customer\n"
				 + "-->3.Update Customer\n"
				 + "-->4.Delete Customer\n"
				 + "-->5.Back To Main Menu\n"
				 + "-->6.Exit\n");
		switch (in.nextInt()) {
		case 1  -> CustomerCrud.createCustomer();
		case 2  -> CustomerCrud.fetchAllCustomers();
		case 3  -> updateCustomerMenu();
		case 4  -> CustomerCrud.removeCustomer();
		case 5  -> Main.main();
		case 6  -> Main.exitMethod();
		default ->{System.out.println("Invalid Input, Please try again..\n");
				   customerMainMenu();
			}
		}
	}
	public static void updateCustomerMenu() {
		System.out.println("------------------------\n"
						 + "-->1.Update Customer Contact_No\n"
						 + "-->2.Update Customer Address\n"
						 + "-->3.Exit\n");
		switch(in.nextInt()) {
		case 1  -> CustomerCrud.updateCustomerPhoneNo();
		case 2  -> CustomerCrud.updateCustomerAddress();
		case 3  -> Main.exitMethod();
		default -> {System.out.println("Invalid Input, Please try again..\n");
					updateCustomerMenu();
			}
		}
	}
}
