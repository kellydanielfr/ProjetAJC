package config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IDAOCompte;
import dao.IDAOConge;
import dao.IDAOManager;
import dao.IDAOSalarie;
import dao.IDAOService;
import dao.jpa.DAOCompte;
import dao.jpa.DAOConge;
import dao.jpa.DAOManager;
import dao.jpa.DAOSalarie;
import dao.jpa.DAOService;

public class Context {

	private static Context _instance;
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("conges");
	
	//Factory
	private IDAOCompte daoCompte=new DAOCompte();
	private IDAOSalarie daoSalarie=new DAOSalarie();
	private IDAOManager daoManager=new DAOManager();
	private IDAOConge daoConge=new DAOConge();
	private IDAOService daoService =new DAOService();
	
	private Context() {}
	
	public static Context getInstance()
	{
		if(_instance==null) 
		{
			_instance=new Context();
		}
		return _instance;
	}
	public EntityManagerFactory getEmf() {
		return emf;
	}
	
	public void closeEmf() 
	{
		emf.close();
	}

	public IDAOCompte getDaoCompte() {
		return daoCompte;
	}

	public void setDaoCompte(IDAOCompte daoCompte) {
		this.daoCompte = daoCompte;
	}

	public IDAOSalarie getDaoSalarie() {
		return daoSalarie;
	}

	public void setDaoSalarie(IDAOSalarie daoSalarie) {
		this.daoSalarie = daoSalarie;
	}

	public IDAOManager getDaoManager() {
		return daoManager;
	}

	public void setDaoManager(IDAOManager daoManager) {
		this.daoManager = daoManager;
	}

	public IDAOConge getDaoConge() {
		return daoConge;
	}

	public void setDaoConge(IDAOConge daoConge) {
		this.daoConge = daoConge;
	}

	public IDAOService getDaoService() {
		return daoService;
	}

	public void setDaoService(IDAOService daoService) {
		this.daoService = daoService;
	}

}
