package dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Address;



public class AddressDAO {
	
	protected static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("FiachrasPU"); 	
	
	public AddressDAO() {
		
	}
	
	public void persist(Address Address) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(Address);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Address Address) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(Address));
		em.getTransaction().commit();
		em.close();
	}
	
	public Address merge(Address Address) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Address updatedAddress = em.merge(Address);
		em.getTransaction().commit();
		em.close();
		return updatedAddress;
	}
	
	


}
