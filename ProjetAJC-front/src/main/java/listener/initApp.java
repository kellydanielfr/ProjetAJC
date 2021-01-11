package listener;

import javax.persistence.EntityManager;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import config.Context;

public class initApp implements ServletContextListener {

  
    public initApp() {
        // TODO Auto-generated constructor stub
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
         Context.getInstance().closeEmf();
    }

    public void contextInitialized(ServletContextEvent sce)  { 

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.close();
    }
	
}
