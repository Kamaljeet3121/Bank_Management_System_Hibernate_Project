package classProject;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

	@Entity
	@Table(name="branches")
	public class Branch {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO,generator = "branches_SEQ")
		@SequenceGenerator(initialValue = 11,allocationSize = 1,name = "branches_SEQ")
		private int id;
		private String name;
		private String address;
		
		@ManyToOne
		@JoinColumn
		private Bank bank; //1.
		
		@OneToMany(mappedBy = "branch") //2.
		private List<Account> accounts;
		
		@OneToMany(mappedBy = "branch") //3.
		private List<Loan> loans;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public Bank getBank() {
			return bank;
		}

		public void setBank(Bank bank) {
			this.bank = bank;
		}

		public List<Account> getAccounts() {
			return accounts;
		}

		public void setAccounts(List<Account> accounts) {
			this.accounts = accounts;
		}

		public List<Loan> getLoans() {
			return loans;
		}

		public void setLoans(List<Loan> loans) {
			this.loans = loans;
		}

		@Override
		public String toString() {
			return "Branch [id=" + id + ", name=" + name + ", address=" + address + "]";
		}
		
		
}
