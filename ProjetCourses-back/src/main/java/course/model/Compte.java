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

@Entity
@Table(name="Comptes")
@Inheritance(strategy =InheritanceType.SINGLE_TABLE)
public abstract class Compte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	protected String nom;
	protected String prenom;
	protected String mail;
	protected String mdp;
	
	@Embedded
	protected Adresse adresse;
	
	public Compte() {
		// TODO Auto-generated constructor stub
	}
	public Compte(String nom, String prenom, String mail, String mdp, Adresse adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.mdp = mdp;
		this.adresse = adresse;
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
