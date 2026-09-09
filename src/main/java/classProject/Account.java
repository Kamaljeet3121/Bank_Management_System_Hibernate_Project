package classProject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="accounts")
public class Account {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO,generator = "accounts_SEQ")
		@SequenceGenerator(initialValue = 301,allocationSize = 1,name = "accounts_SEQ")
		private int accountNo;
		private String accType;
		private double	balance;
		
		@ManyToOne //2.
		@JoinColumn
		private Branch branch;
		
		@ManyToOne
		@JoinColumn		//5.
		private Customer customer;

		public int getAccountNo() {
			return accountNo;
		}

		public void setAccountNo(int accountNo) {
			this.accountNo = accountNo;
		}

		public String getAccType() {
			return accType;
		}

		public void setAccType(String accType) {
			this.accType = accType;
		}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}

		public Branch getBranch() {
			return branch;
		}

		public void setBranch(Branch branch) {
			this.branch = branch;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		@Override
		public String toString() {
			return "Account [accountNo=" + accountNo + ", accType=" + accType + ", balance=" + balance + "]";
		}
		
		
}
