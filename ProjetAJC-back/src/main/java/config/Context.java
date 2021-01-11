package config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Context {

	private static Context _instance;
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("conges");
	
	//Factory
//	private IDAOCompte daoCompte=new DAOCompte();
//	private IDAOEmploye daoEmploye=new DAOEmploye();
//	private IDAOAdmin daoAdmin=new DAOAdmin();
//	private IDAOPC daoPC=new DAOPC();
	
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
}
