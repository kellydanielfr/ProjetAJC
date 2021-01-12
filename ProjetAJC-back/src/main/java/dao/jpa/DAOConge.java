package dao.jpa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import config.Context;
import dao.IDAOConge;
import model.Conge;


public class DAOConge implements IDAOConge{

	@Override
	public Conge save(Conge t) {
		
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		try{t=em.merge(t);}
		catch(Exception e) {System.out.println("Error save Conge");}
		em.getTransaction().commit();
		em.close();
		return t;
		
	}

	@Override
	public void delete(Conge t) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		try{em.remove(em.merge(t));}
		catch(Exception e) {System.out.println("Error delete Conge");}
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Conge findById(Integer id) {
		Conge emp=null;
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		try{emp=em.find(Conge.class,id);}
		catch(Exception e) {System.out.println("Error find Conge");}
		
		em.close();
		return emp;
	}

	@Override
	public List<Conge> findAll() {
		List<Conge> conges = new ArrayList();
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		try 
		{
			Query query= em.createQuery("from Conge",Conge.class);
			conges=query.getResultList();
		}
		catch(Exception e){System.out.println("Error findAll Conge");}
		em.close();
		return conges;
	}
	
	@Override
	public List<Conge> findAllFilterByDate(LocalDate dateDebut, LocalDate dateFin) {
		List<Conge> conges = new ArrayList();
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		try 
		{
			Query query= em.createQuery("from Conge e where e.dateDebut >= :dateDebut and e.dateFin <= :dateFin",Conge.class);
			query.setParameter("dateDebut", dateDebut);
			query.setParameter("dateFin", dateFin);
			conges=query.getResultList();
		}
		catch(Exception e){System.out.println("Error findAllFilterByDate Conge");}
		em.close();
		return conges;
	}
	
	@Override
	public List<Conge> findAllFilterByService(Integer id) {
		List<Conge> conges = new ArrayList();
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		try 
		{
			Query query= em.createQuery("Select c from Conge c left join c.salarie s left join s.service b where s.id=c.salarie and b.id=:id",Conge.class);
			query.setParameter("id",id);
			conges=query.getResultList();
		}
		catch(Exception e){System.out.println("Error findAllFilterByService Conge");}
		em.close();
		return conges;
	}
	
	@Override
	public List<Conge> findAllFilterByServiceDate(Integer id, LocalDate dateDebut, LocalDate dateFin) {
		List<Conge> conges = new ArrayList();
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		try 
		{
			Query query= em.createQuery("Select c from Conge c left join c.salarie s left join s.service b where s.id=c.salarie and b.id=:id and c.dateDebut >= :dateDebut and c.dateFin <= :dateFin",Conge.class);
			query.setParameter("id",id);
			query.setParameter("dateDebut", dateDebut);
			query.setParameter("dateFin", dateFin);
			conges=query.getResultList();
		}
		catch(Exception e){System.out.println("Error findAllFilterByServiceDate Conge");}
		em.close();
		return conges;
	}
	
	@Override
	public List<Conge> demandeAttente() {
		List<Conge> demandeAttente = new ArrayList();
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		try 
		{
			Query query= em.createQuery("from Conge c where c.etat='ATTENTE'",Conge.class);
			demandeAttente=query.getResultList();
		}
		catch(Exception e){System.out.println("Error demandeAttente Conge");}
		em.close();
		return demandeAttente;
	}

	@Override
	public List<Conge> demandeSalarie(Integer id) {
		List<Conge> conges = new ArrayList();
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		try 
		{
			Query query= em.createQuery("Select c from Conge c left join c.salarie s where s.id= :id",Conge.class);
			query.setParameter("id",id);
			conges=query.getResultList();
		}
		catch(Exception e){System.out.println("Error demandeSalarie Conge");}
		em.close();
		return conges;
	}
}
