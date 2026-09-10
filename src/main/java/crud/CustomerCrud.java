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

public class CustomerCrud {
	static Scanner in = new Scanner(System.in);
	static EntityManager em = Resources.getEntityManagerFactory().createEntityManager();
	static EntityTransaction et = em.getTransaction();
	
	public static void createCustomer() {
		
		Customer c1 = new Customer();
		
		System.out.println("Enter Name:");
		c1.setName(in.nextLine());
	
		System.out.println("Enter Contact No.");
		c1.setPhoneNo(in.nextLong());
		
		System.out.println("Enter Address");
		in.nextLine();
		c1.setAddress(in.nextLine());
		
		et.begin();
		em.persist(c1);
		et.commit();
		System.out.println("-->Customer Data Inserted<--");
		
	}
	public static void updateCustomerPhoneNo() {
		System.out.println("Enter Customer ID:");
		Customer c = em.find(Customer.class, in.nextInt());
		if(c!=null) {
			et.begin();
			System.out.println("Enter New Contact_No:");
			c.setPhoneNo(in.nextLong());
			em.merge(c);
			et.commit();
			System.out.println("-->Contact_No Updated<--");
		}else {
			System.out.println("Customer not found.\nPlease Enter valid Customer Id\n");
			updateCustomerPhoneNo();
			}
	}
	
	public static void updateCustomerAddress() {
		System.out.println("Enter Customer ID:");
		Customer c = em.find(Customer.class, in.nextInt());
		if(c!=null) {
			et.begin();
			System.out.println("Enter New Address:");
			in.nextLine();
			c.setAddress(in.nextLine());
			em.merge(c);
			et.commit();
			System.out.println("-->Address Updated<--");
		}else {
			System.out.println("Customer not found.\nPlease Enter valid Customer Id\n");
			updateCustomerAddress();
			}
	}
	
	public static void removeCustomer() {
		System.out.println("Enter the Customer_Id");
		
		Customer c = em.find(Customer.class, in.nextInt());
		if(c!=null) {
			et.begin();
			for(Account acc:c.getAccounts())
				acc.setCustomer(null);
			for (Loan loan : c.getLoans()) {
				loan.setCustomer(null);
			}
			em.remove(c);
			et.commit();
			System.out.println("-->Customer Deleted<--");
		}else {
			System.out.println("Customer not found.\nPlease Enter valid Customer_Id\n");
			removeCustomer();
			}
	}
	
	public static void fetchAllCustomers() {
		String query = "select c from Customer c order by id";
		for(Customer c: (List<Customer>)em.createQuery(query).getResultList()) {
			System.out.println(c);
		}
		
	}
	
}
