package crud;

import java.util.List;
import java.util.Scanner;

import classProject.Account;
import classProject.Branch;
import classProject.Customer;
import classProject.Loan;
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
			createAccountstage2(branch);
			
		}else {
			System.out.println("Branch Not Found..\nPlease Enter Valid Branch_ID:\n");
			createAccount();
		}
		
	}
	
	private static void createAccountstage2(Branch b) {
		
		System.out.println("Enter Customer ID to map:");
		
		Customer c = em.find(Customer.class, in.nextInt());
		if(c!=null) {
		et.begin();
		Account acc = new Account();
		acc.setBranch(b);
		acc.setCustomer(c);
		System.out.println("Enter Account Type:");
		in.nextLine();
		acc.setAccType(in.nextLine());
		System.out.println("Enter Balance:");
		acc.setBalance(in.nextInt());
		
		em.persist(acc);
		et.commit();
		System.out.println("-->Account Created<--");
		}else {
			System.out.println("Customer Id Not Found..\\nPlease Enter Valid Customer_ID:\n");
			createAccountstage2(b);
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
			System.out.println("Account not found.\nPlease Enter valid Account_No\n");
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
			System.out.println("Account not found.\nPlease Enter valid Account_No\n");
			updateAccountType();
		}
	}
	
	public static void fetchAllAccount() {
		String query = "select b from Account b order by id";
		for(Account acc: (List<Account>)em.createQuery(query).getResultList()) {
			System.out.println(acc);
		}
	}
	public static void removeAccount() {
		System.out.println("Enter the Account_Id");
		
		Account a = em.find(Account.class, in.nextInt());
		if(a!=null) {
			et.begin();
			em.remove(a);
			et.commit();
			System.out.println("-->Account Deleted<--");
		}else {
			System.out.println("Account not found.\nPlease Enter valid Account_Id\n");
			removeAccount();
			}
	}
	
}
