package dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import config.Context;
import dao.IDAOCompte;
import model.Compte;

public class DAOCompte implements IDAOCompte{
	@Override
	public Compte save(Compte t) {
		
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		try{t=em.merge(t);}
		catch(Exception e) {System.out.println("Error save Compte");}
		em.getTransaction().commit();
		em.close();
		return t;
		
	}

	@Override
	public void delete(Compte t) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		try{em.remove(em.merge(t));}
		catch(Exception e) {System.out.println("Error delete Compte");}
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Compte findById(Integer id) {
		Compte c=null;
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		try{c=em.find(Compte.class,id);}
		catch(Exception e) {System.out.println("Error find Compte");}
		
		em.close();
		return c;
	}

	@Override
	public List<Compte> findAll() {
		List<Compte> comptes = new ArrayList();
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		try 
		{
			Query query= em.createQuery("from Compte",Compte.class);
			comptes=query.getResultList();
		}
		catch(Exception e){System.out.println("Error findAll Compte");}
		em.close();
		return comptes;
	}

	@Override
	public Compte connect(String mail, String password) {
		Compte c = null;
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		try 
		{
			Query query= em.createQuery("from Compte c where c.mail=:mail and c.password=:password",Compte.class);
			query.setParameter("mail", mail);
			query.setParameter("password", password);
			c=(Compte) query.getSingleResult();
		}
		catch(Exception e){System.out.println("Error connect Compte");}
		em.close();
		return c;
	}

}
