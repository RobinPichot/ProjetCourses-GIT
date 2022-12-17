package model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Restaurateur")
public class Restaurateur extends Compte{
	
	public Restaurateur() {
		// TODO Auto-generated constructor stub
	}

	public Restaurateur(String nom, String prenom, String mail, String mdp, Adresse adresse) {
		super(nom, prenom, mail, mdp, adresse);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Restaurateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", mdp=" + mdp
				+ ", adresse=" + adresse + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom() + ", getMail()="
				+ getMail() + ", getMdp()=" + getMdp() + ", getAdresse()=" + getAdresse() + ", getId()=" + getId()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
	
	

}
