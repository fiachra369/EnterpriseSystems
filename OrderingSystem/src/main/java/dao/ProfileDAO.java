package dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Profile;



public class ProfileDAO {
	
	protected static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("FiachrasPU"); 	
	
	public ProfileDAO() {
		
	}
	
	public void persist(Profile Profile) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(Profile);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Profile Profile) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(Profile));
		em.getTransaction().commit();
		em.close();
	}
	
	public Profile merge(Profile Profile) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Profile updatedProfile = em.merge(Profile);
		em.getTransaction().commit();
		em.close();
		return updatedProfile;
	}
	
	


}
