package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.User;

public class UserDAO {
	
	protected static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("FiachrasPU"); 	
	
	public UserDAO() {
		
	}
	
	public void persist(User User) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(User);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(User User) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(User));
		em.getTransaction().commit();
		em.close();
	}
	
	public User merge(User User) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		User updatedUser = em.merge(User);
		em.getTransaction().commit();
		em.close();
		return updatedUser;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<User> UsersFromDB = new ArrayList<User>();
		UsersFromDB = em.createNamedQuery("User.findAll").getResultList();
		em.getTransaction().commit();
		em.close();
		return UsersFromDB;
	}
	
	public User getUserByUsername(String username){
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<User> Users = (List<User>) 
				em.createNamedQuery("User.findByUsername").
				setParameter("username", username).getResultList();
		em.close();
		//Do whatever you want with the User(s) with that username
		//Here we just return the first one
		User sub = new User();
		for(User s: Users) {
			sub = s;
		}
		return sub;
	}

}
