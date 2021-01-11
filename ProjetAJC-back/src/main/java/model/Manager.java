package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("manager")

public class Manager extends Compte {

	public Manager(String login, String password, String mail) {
		super(login,password,mail);
	}

	public Manager() {

	}
}
