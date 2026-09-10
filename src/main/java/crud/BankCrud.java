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
		b1.setName(sc.nextLine());
		System.out.println("Enter Address");
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
			sc.nextLine();
			b.setName(sc.nextLine());
			et.begin();
			entityManager.merge(b);
			et.commit();
			System.out.println("-->Branch Name Updated<--");
		}else {
			System.out.println("Bank not found.\nPlease Enter valid Bank Id\n");
			updateBankName();
			}
		
	}
	
	public static void updateBankAddress() {
		
		System.out.println("Enter the BankId");
		
		Bank b = entityManager.find(Bank.class, sc.nextInt());
		if(b!=null) {
			System.out.println("Enter New Address");
			sc.nextLine();
			b.setAddress(sc.nextLine());
			et.begin();
			entityManager.merge(b);
			et.commit();
			System.out.println("-->Address Updated<--");
		}else{
			System.out.println("Bank not found.\nPlease Enter valid Bank Id\n");
			updateBankAddress();
			}
	}
	
	public static void removeBank() {
		
		System.out.println("Enter the BankId");
		
		Bank b = entityManager.find(Bank.class, sc.nextInt());
		if(b!=null) {
			et.begin();
			for(Branch branch:b.getBranches())
				branch.setBank(null);
			entityManager.remove(b);
			et.commit();
			System.out.println("-->Bank Deleted<--");
		}else {
			System.out.println("Bank not found.\nPlease Enter valid Bank Id\n");
			removeBank();
			}
	}
	
	
	public static void fetchAllBank() {
		
		String query = "select b from Bank b order by id";
		Query q = entityManager.createQuery(query);
		
		List<Bank> banks = q.getResultList();
		
		for (Bank bank : banks) {
			System.out.println(bank);
		}
		
	}
	
}




