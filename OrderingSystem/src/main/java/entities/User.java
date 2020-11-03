package entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@NamedQueries({
	@NamedQuery(name="User.findAll", query="select o from User o"), 
	@NamedQuery(name = "User.findByUsername", query = "select o from User o where o.username=:username")
})

@Entity
public class User {
		
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String username;
	
	
	@OneToOne
	private Address Address;
	

	public User() {

	}

	public User(String username, Address Address) {
		this.username = username;
		this.Address = Address;
		
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public Address getAddress() {
		return Address;
	}

	public void setAddress(Address Address) {
		this.Address = Address;
	}
	
	

}
