package crud;

import java.util.Scanner;

import classProject.Branch;
import classProject.Loan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.Resources;

public class LoanCrud {
	static Scanner in = new Scanner(System.in);
	static EntityManager em = Resources.getEntityManagerFactory().createEntityManager();
	static EntityTransaction et = em.getTransaction();
	
	public static void createLoan() {
		
		System.out.println("Enter the Branch_ID to map:");
		Branch b = em.find(Branch.class, in.nextInt());
		
		if(b!=null) {
			Loan l = new Loan();
			System.out.println("Enter Loan_Type:");
			l.setLoanType(in.next());
			System.out.println("Enter Loan Amount:");
			l.setAmount(in.nextInt());
			
			et.begin();
			em.persist(l);
			et.commit();
			System.out.println("-->Loan Created<--");
		}else {
			System.out.println("Branch not found\nPlease Enter Valid Branch_ID:");
		}
		
	}
}
