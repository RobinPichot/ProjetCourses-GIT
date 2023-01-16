package course.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;


@Entity
@Table(name="Comptes")
@JsonTypeInfo(include = As.PROPERTY, use = JsonTypeInfo.Id.NAME,property = "classType")
@Inheritance(strategy =InheritanceType.SINGLE_TABLE)
public abstract class Compte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	protected Integer id;
	@JsonView(Views.ViewBase.class)
	protected String login;
	@JsonView(Views.ViewBase.class)
	protected String nom;
	@JsonView(Views.ViewBase.class)
	protected String prenom;
	@JsonView(Views.ViewBase.class)
	protected String mail;
	@JsonView(Views.ViewBase.class)
	protected String mdp;
	
	@Embedded
	@JsonView(Views.ViewBase.class)
	protected Adresse adresse;
	
	public Compte() {
	}
	public Compte(String login,String nom, String prenom, String mail, String mdp, Adresse adresse) {
		this.login=login;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.mdp = mdp;
		this.adresse = adresse;
	}


	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getMdp() {
		return mdp;
	}


	public void setMdp(String mdp) {
		this.mdp = mdp;
	}


	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Compte [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", mdp=" + mdp
				+ ", adresse=" + adresse + "]";
	}
	
	
	
	
	
	
	

}
