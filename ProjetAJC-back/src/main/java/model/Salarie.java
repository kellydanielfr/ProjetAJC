package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("salarie")
public class Salarie extends Compte{

	public Salarie() {
	}
	
	public Salarie(String login, String password, String mail) {
		super(login,password,mail);
	}
	
	public Salarie(Integer id,String login, String password, String mail) {
		super(id,login,password,mail);
	}
}
