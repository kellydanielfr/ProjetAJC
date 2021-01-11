package model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_compte")
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	protected String mail,password;
	protected String nom,prenom;
	@ManyToOne
	protected Service service; 
	@Version
	protected int version;
	

	public Compte() {}
	
	


	public Compte(String mail, String password, String nom, String prenom, Service service) {
		this.mail = mail;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.service=service;
	}




	public Compte(Integer id, String mail, String password, String nom, String prenom, Service service) {
		this.id = id;
		this.mail = mail;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.service=service;
	}




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}



	public int getVersion() {
		return version;
	}



	public void setVersion(int version) {
		this.version = version;
	}
	
	
	
}
