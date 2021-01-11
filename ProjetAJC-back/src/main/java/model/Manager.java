package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("manager")

public class Manager extends Compte {



	public Manager(Integer id, String mail, String password, String nom, String prenom, Service service) {
		super(id, mail, password, nom, prenom, service);
		// TODO Auto-generated constructor stub
	}

	public Manager(String mail, String password, String nom, String prenom, Service service) {
		super(mail, password, nom, prenom, service);
		// TODO Auto-generated constructor stub
	}

	public Manager() {

	}
}
