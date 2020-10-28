package dao;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Food;


public class FoodDAO {
	
	protected static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("FiachrasPU"); 	
	
	public FoodDAO() {
		
	}
	
	public void persist(Food Food) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(Food);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Food Food) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(Food));
		em.getTransaction().commit();
		em.close();
	}
	
	public Food merge(Food Food) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Food updatedFood = em.merge(Food);
		em.getTransaction().commit();
		em.close();
		return updatedFood;
	}
	
	


}