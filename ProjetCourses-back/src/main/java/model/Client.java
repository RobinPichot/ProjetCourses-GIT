package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("Client")
public class Client extends Compte {

	public Client(String nom, String prenom, String mail, String mdp, Adresse adresse) {
		super(nom, prenom, mail, mdp, adresse);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", mdp=" + mdp + ", adresse=" + adresse
				+ "]";
	}

	
}
