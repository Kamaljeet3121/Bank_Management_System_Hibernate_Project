package classProject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="loans")
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "loans_SEQ")
	@SequenceGenerator(initialValue = 201,allocationSize = 1,name = "loans_SEQ")
	private int id;
	private String loanType;
	private double amount;
	
	@ManyToOne	//3.
	@JoinColumn
	private Branch branch;
	
	@OneToOne		//4.
	private Customer customer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
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
		return "Loan [id=" + id + ", loanType=" + loanType + ", amount=" + amount + "]";
	}
	
	

}
