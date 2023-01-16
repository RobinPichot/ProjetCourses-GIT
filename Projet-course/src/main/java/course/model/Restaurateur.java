package course.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Restaurateur")
public class Restaurateur extends Compte{
	
	public Restaurateur() {
	}

	public Restaurateur(String login,String nom, String prenom, String mail, String mdp, Adresse adresse) {
		super(login,nom, prenom, mail, mdp, adresse);
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
