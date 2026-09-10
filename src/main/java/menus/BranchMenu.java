package menus;

import java.util.Scanner;

import crud.BranchCrud;
import main.Main;

public class BranchMenu {
	static Scanner in = new Scanner(System.in);
	
	public static void branchMainMenu() {
		System.out.println("=====Branch Menu=====\n"
				 + "-->1.Create New Branch\n"
				 + "-->2.View All Branches\n"
				 + "-->3.Update Branch\n"
				 + "-->4.Delete Branch\n"
				 + "-->5.Back To Main Menu\n"
				 + "-->6.Exit\n");
		switch (in.nextInt()) {
		case 1  -> BranchCrud.createBranch();
		case 2  -> BranchCrud.fetchAllBranch();
		case 3  -> updateBranchMenu();
		case 4  -> BranchCrud.removeBranch();
		case 5  -> Main.main();
		case 6  -> Main.exitMethod();
		default ->{System.out.println("Invalid Input, Please try again..\n");
				   branchMainMenu();
			}
		}
	}
	public static void updateBranchMenu() {
		System.out.println("------------------------\n"
						 + "-->1.Update Branch Name\n"
						 + "-->2.Update Branch Address\n"
						 + "-->3.Exit\n");
		switch(in.nextInt()) {
		case 1  -> BranchCrud.updateBranchName();
		case 2  -> BranchCrud.updateBranchAddress();
		case 3  -> Main.exitMethod();
		default -> {System.out.println("Invalid Input, Please try again..\n");
					updateBranchMenu();
			}
		}
	}
}
