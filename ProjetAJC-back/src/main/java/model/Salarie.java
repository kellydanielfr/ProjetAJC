package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("salarie")
public class Salarie extends Compte{

	
	public Salarie() {
	}

	public Salarie(Integer id, String mail, String password, String nom, String prenom, Service service) {
		super(id, mail, password, nom, prenom,service);
	}

	public Salarie(String mail, String password, String nom, String prenom, Service service) {
		super(mail, password, nom, prenom,service);
	}
	

}
