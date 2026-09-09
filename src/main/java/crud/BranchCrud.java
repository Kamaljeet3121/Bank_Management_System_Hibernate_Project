package crud;

import java.util.List;
import java.util.Scanner;

import classProject.Bank;
import classProject.Branch;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.Resources;

public class BranchCrud {
	static Scanner in = new Scanner(System.in);
	static EntityManager em = Resources.getEntityManagerFactory().createEntityManager();
	static EntityTransaction et = em.getTransaction();
	
	public static void createBranch() {
		
		System.out.println("Enter the Bank_ID to map");
		
		Bank bank = em.find(Bank.class, in.nextInt());
		
		if(bank!=null) {
			
			Branch b = new Branch();
			b.setBank(bank);
			System.out.println("Enter Branch Name:");
			b.setName(in.next());
			System.out.println("Enter Branch Address:");
			in.next();
			b.setAddress(in.nextLine());
			et.begin();
			em.persist(b);
			et.commit();
			System.out.println("-->Branch Created<--");
			
		}else {
			System.out.println("Bank not found.\nPlease Enter valid Bank Id");
			createBranch();
			}
	}
	public static void updateBranchName() {
		System.out.println("Enter the Branch_Id");
		
		Branch b = em.find(Branch.class, in.nextInt());
		if(b!=null) {
			System.out.println("Enter New Branch Name");
			b.setName(in.next());
			et.begin();
			em.merge(b);
			et.commit();
			System.out.println("-->Branch Name Updated<--");
		}else {
			System.out.println("Bank not found.\nPlease Enter valid Branch Id");
			updateBranchName();
			}
	}
	
	public static void updateBranchAddress() {
		System.out.println("Enter the Branch_Id");
		
		Branch b = em.find(Branch.class, in.nextInt());
		if(b!=null) {
			System.out.println("Enter New Branch Address");
			in.next();
			b.setName(in.nextLine());
			et.begin();
			em.merge(b);
			et.commit();
			System.out.println("-->Branch Address Updated<--");
		}else {
			System.out.println("Bank not found.\nPlease Enter valid Branch Id");
			updateBranchName();
			}
	}
	public static void fetchAllBranch() {
		
		String query = "select b from Branch b";
		
		for (Branch branch : (List<Branch>)em.createQuery(query).getResultList()) {
			System.out.println(branch);
		}
	}
	public static void removeBranch() {
		
	}
	
}
