package classProject;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "banks")
public class Bank {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "banks_SEQ")
	@SequenceGenerator(initialValue = 1,allocationSize = 1,name = "banks_SEQ")
	private int id;
	private int code;
	private String name;
	private String address;
	
	@OneToMany(mappedBy = "bank") //1.
	private List<Branch> branches;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
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

	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

	@Override
	public String toString() {
		return "Bank [id=" + id + ", code=" + code + ", name=" + name + ", address=" + address + "]";
	}

	
	
	
}
