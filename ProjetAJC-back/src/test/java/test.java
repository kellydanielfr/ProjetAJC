import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import config.Context;
import model.Conge;
import model.Manager;
import model.Salarie;
import model.Service;
import model.TypeConge;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate date1 = LocalDate.of(2015, 02, 18);
		LocalDate date2 = LocalDate.of(2015, 02, 20);
		
		Service service = new Service("service");
		service = Context.getInstance().getDaoService().save(service);
		
		Salarie salarie = new Salarie("mail@mail", "pass", "nom", "prenom", service);
		Manager manager = new Manager("mail@mail", "pass", "nom", "prenom", service );
		
		Context.getInstance().getDaoManager().save(manager);
		salarie = Context.getInstance().getDaoSalarie().save(salarie);
		
		Conge conge = new Conge(salarie, TypeConge.AJ, date1, date2, "motif");
		

		Context.getInstance().getDaoConge().save(conge);
	}

}
