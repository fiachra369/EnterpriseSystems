package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Profile {
		
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String description;

	@OneToMany(fetch = FetchType.EAGER)
	private List<Food> Foods = new ArrayList<Food>();
	
	public Profile() {

	}

	
	public Profile(String description, List<Food> Foods) {
		super();
		this.description = description;
		this.Foods = Foods;
	}
	
	
	public Profile(String description) {
		this.description = description;
	}

	public void addFood(Food Food) {
		Foods.add(Food);
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public List<Food> getFoods() {
		return Foods;
	}



	public void setFoods(List<Food> Foods) {
		this.Foods = Foods;
	}

	
	

}
