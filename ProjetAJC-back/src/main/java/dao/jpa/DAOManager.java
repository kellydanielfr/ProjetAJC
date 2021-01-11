package dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import config.Context;
import dao.IDAOManager;
import model.Manager;

public class DAOManager implements IDAOManager{

	@Override
	public Manager save(Manager t) {
		
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		try{t=em.merge(t);}
		catch(Exception e) {System.out.println("Error save Admin");}
		em.getTransaction().commit();
		em.close();
		return t;
		
	}

	@Override
	public void delete(Manager t) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		try{em.remove(em.merge(t));}
		catch(Exception e) {System.out.println("Error delete Admin");}
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Manager findById(Integer id) {
		Manager admin=null;
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		try{admin=em.find(Manager.class,id);}
		catch(Exception e) {System.out.println("Error find Admin");}
		
		
		em.close();
		return admin;
	}

	@Override
	public List<Manager> findAll() {
		List<Manager> employes = new ArrayList();
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		try 
		{
			Query query= em.createQuery("from Admin",Manager.class);
			employes=query.getResultList();
		}
		catch(Exception e){System.out.println("Error findAll Admin");}
		em.close();
		return employes;
	}

}
