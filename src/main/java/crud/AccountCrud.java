package crud;

import java.util.List;
import java.util.Scanner;

import classProject.Account;
import classProject.Branch;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.Resources;

public class AccountCrud {
	static Scanner in = new Scanner(System.in);
	static EntityManager em = Resources.getEntityManagerFactory().createEntityManager();
	static EntityTransaction et = em.getTransaction();
	
	public static void createAccount() {
		System.out.println("Enter the Branch_ID to map");
		
		Branch branch = em.find(Branch.class, in.nextInt());
		
		if(branch!=null) {
			Account acc = new Account();
			acc.setBranch(branch);
			System.out.println("Enter Account Type:");
			acc.setAccType(in.next());
			System.out.println("Enter Balance:");
			acc.setBalance(in.nextInt());
			
			et.begin();
			em.persist(acc);
			et.commit();
			
			System.out.println("-->Account Created<--");
		}else {
			System.out.println("Branch Not Found..\nPlease Enter Valid Branch_ID:");
			createAccount();
		}
		
	}
	public static void updateAccountBalance() {
		System.out.println("Enter the Account_No");
		Account acc = em.find(Account.class, in.nextInt());
		if(acc!=null) {
			System.out.println("Enter new Balance:");
			acc.setBalance(in.nextInt());
			et.begin();
			em.merge(acc);
			et.commit();
			System.out.println("-->Balance Updated<--");
		}else {
			System.out.println("Account not found.\nPlease Enter valid Account_No");
			updateAccountBalance();
			}
	}
	
	public static void updateAccountType() {
		System.out.println("Enter the Account_No");
		Account acc = em.find(Account.class, in.nextInt());
		if(acc!=null) {
			System.out.println("Enter new Account_Type:");
			acc.setAccType(in.next());
			et.begin();
			em.merge(acc);
			et.commit();
			System.out.println("-->Account_Type Updated<--");
		}else {
			System.out.println("Account not found.\nPlease Enter valid Account_No");
			updateAccountType();
		}
	}
	
	public static void fetchAllAccount() {
		String query = "select b from Account b";
		for(Account acc: (List<Account>)em.createQuery(query).getResultList()) {
			System.out.println(acc);
		}
	}
	public static void removeAccount() {
		
	}
	
}
