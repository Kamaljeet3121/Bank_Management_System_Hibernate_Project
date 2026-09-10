package crud;

import java.util.List;
import java.util.Scanner;

import classProject.Branch;
import classProject.Customer;
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
			
			if(b!=null) 
				createLoanStage2(b);
			else {
				System.out.println("Branch Id not found\nPlease Enter Valid Branch_ID:\n");
				createLoan();
			}
			
		}
		private static void createLoanStage2(Branch b) {
			System.out.println("Enter Customer ID to map:");
			
			Customer c = em.find(Customer.class, in.nextInt());
			if(c!=null) {
				
				et.begin();
				Loan l = new Loan();
				l.setCustomer(c);
				l.setBranch(b);
				System.out.println("Enter Loan_Type:");
				in.nextLine();
				l.setLoanType(in.nextLine());
				System.out.println("Enter Loan Amount:");
				l.setAmount(in.nextInt());
				
				em.persist(l);
				et.commit();
				System.out.println("-->Loan Created<--");
			}else {
				System.out.println("Customer Id Not Found \nPlease Enter Valid Customer_ID:\n");
				createLoanStage2(b);
			}
			
		}
		public static void updateLoanType() {
			System.out.println("Enter Loan_ID:");
			Loan loan = em.find(Loan.class, in.nextInt());
			if(loan!=null) {
				System.out.println("Enter new Loan Type:");
				in.nextLine();
				loan.setLoanType(in.nextLine());
				
				et.begin();
				em.merge(loan);
				et.commit();
				
				System.out.println("-->Loan Type Updated<--");
			}else {
				System.out.println("Loan not found\nPlease Enter Valid Loan_ID:\n");
				updateLoanType();
			}
			
			
		}
		public static void updateLoanAmount() {
			System.out.println("Enter Loan_ID:");
			Loan loan = em.find(Loan.class, in.nextInt());
			if(loan!=null) {
				System.out.println("Enter new Loan Amount:");
				loan.setAmount(in.nextDouble());
				
				et.begin();
				em.merge(loan);
				et.commit();
				
				System.out.println("-->Loan Amount Updated<--");
			}else {
				System.out.println("Loan not found\nPlease Enter Valid Loan_ID:\n");
				updateLoanAmount();
			}
		}
		public static void removeLoan() {
			System.out.println("Enter Loan_ID:");
			Loan loan = em.find(Loan.class, in.nextInt());
			if(loan!=null) {
				
				et.begin();
				em.remove(loan);
				et.commit();
				
				System.out.println("-->Loan Deleted<--");
			}else {
				System.out.println("Loan not found\nPlease Enter Valid Loan_ID:\n");
				removeLoan();
			}
		}
		
		public static void fetchAllLoans() {
			String query = "select l from Loan l order by id";
			for(Loan loan: (List<Loan>)em.createQuery(query).getResultList()) {
				System.out.println(loan);
			}
		}
	
	
}
