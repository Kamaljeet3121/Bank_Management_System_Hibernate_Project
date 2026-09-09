package crud;

import static util.Resources.*;

import java.util.List;
import java.util.Scanner;

import classProject.Bank;
import classProject.Branch;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class BankCrud {
	
	static Scanner sc = new Scanner(System.in);
		static EntityManager entityManager = getEntityManagerFactory().createEntityManager();
		static EntityTransaction et = entityManager.getTransaction();
		
	public static void createBank() {
		
		Bank b1 = new Bank();
		System.out.println("Enter Bank Name");
		b1.setName(sc.next());
		System.out.println("Enter Bank Code");
		b1.setCode(sc.nextInt());
		System.out.println("Enter Address");
		sc.nextLine();
		b1.setAddress(sc.nextLine());
		
		et.begin();
		entityManager.persist(b1);
		et.commit();
		
		System.out.println("-->Bank Created<--");
	}
	
	public static void updateBankName() {
		
		System.out.println("Enter the BankId");
		
		Bank b = entityManager.find(Bank.class, sc.nextInt());
		if(b!=null) {
			System.out.println("Enter New Bank Name");
			b.setName(sc.next());
			et.begin();
			entityManager.merge(b);
			et.commit();
			System.out.println("-->Branch Name Updated<--");
		}else {
			System.out.println("Bank not found.\nPlease Enter valid Bank Id");
			updateBankName();
			}
		
	}
	public static void updateBankCode() {
		
		System.out.println("Enter the BankId");
		
		Bank b = entityManager.find(Bank.class, sc.nextInt());
		if(b!=null) {
			System.out.println("Enter New Bank Code");
			b.setCode(sc.nextInt());
			et.begin();
			entityManager.merge(b);
			et.commit();
			System.out.println("-->Code Updated<--");
		}else{
			System.out.println("Bank not found.\nPlease Enter valid Bank Id");
			updateBankCode();
			}
	}
	
	public static void updateBankAddress() {
		
		System.out.println("Enter the BankId");
		
		Bank b = entityManager.find(Bank.class, sc.nextInt());
		if(b!=null) {
			System.out.println("Enter New Address");
			b.setName(sc.nextLine());
			et.begin();
			entityManager.merge(b);
			et.commit();
			System.out.println("-->Address Updated<--");
		}else{
			System.out.println("Bank not found.\nPlease Enter valid Bank Id");
			updateBankAddress();
			}
	}
	
	public static void removeBank() {
		
		System.out.println("Enter the BankId");
		
		Bank b = entityManager.find(Bank.class, sc.nextInt());
		if(b!=null) {
			for(Branch branches:b.getBranches())
				branches.setBank(null);
			et.begin();
			entityManager.merge(b);
			et.commit();
			et.begin();
			entityManager.remove(b);
			et.commit();
			System.out.println("-->Bank Deleted<--");
		}else {
			System.out.println("Bank not found.\nPlease Enter valid Bank Id");
			removeBank();
			}
	}
	
	
	public static void fetchAllBank() {
		
		String query = "select b from Bank b";
		Query q = entityManager.createQuery(query);
		
		List<Bank> banks = q.getResultList();
		
		for (Bank bank : banks) {
			System.out.println(bank);
		}
		
	}
	
}




