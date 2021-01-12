import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import config.Context;
import model.Conge;
import model.Manager;
import model.Salarie;
import model.Service;
import model.TypeConge;

public class test {

	public static void main(String[] args) {

		/*LocalDate date1 = LocalDate.of(2015, 02, 18);
		LocalDate date2 = LocalDate.of(2015, 02, 20);
		Service service = new Service("service");
			service = Context.getInstance().getDaoService().save(service);
			
				Salarie salarie = new Salarie("salarie@mail", "pass", "nom", "prenom", service);
				Manager manager = new Manager("manager@mail", "pass", "nom", "prenom", service );
				
				Context.getInstance().getDaoManager().save(manager);
				salarie = Context.getInstance().getDaoSalarie().save(salarie);
				
				Conge conge0 = new Conge(salarie, TypeConge.AJ, date1, date2, "motif");
				Conge conge1 = new Conge(salarie, TypeConge.AJ, date1, date2, "motif");
				Conge conge2 = new Conge(salarie, TypeConge.AJ, date1, date2, "motif");
				Conge conge3 = new Conge(salarie, TypeConge.AJ, date1, date2, "motif");
				Conge conge4 = new Conge(salarie, TypeConge.AJ, date1, date2, "motif");
				Conge conge5 = new Conge(salarie, TypeConge.AJ, date1, date2, "motif");
				Conge conge6 = new Conge(salarie, TypeConge.AJ, date1, date2, "motif");
				
				
		
//		
//		LocalDate dateDebut = LocalDate.parse("2021-01-12");
//		LocalDate dateFin = LocalDate.parse("2021-01-16");
<<<<<<< Updated upstream

//		Service service = new Service("service4");
//		service = Context.getInstance().getDaoService().save(service);
//		
//		Salarie salarie = new Salarie("salarie2@mail", "pass", "nom", "prenom", service);
//		
//		salarie = Context.getInstance().getDaoSalarie().save(salarie);
//		
		List<Conge> test = Context.getInstance().getDaoConge().findAllFilterByService(1);
		System.out.println(test);
=======
//		List<Service> test = Context.getInstance().getDaoService().findAll();
//		System.out.println(test);*/

	}

}
