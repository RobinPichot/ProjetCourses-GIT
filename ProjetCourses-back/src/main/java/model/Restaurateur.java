package model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Restaurateur")
public class Restaurateur extends Compte{
	
	

	public Restaurateur(String nom, String prenom, String mail, String mdp, Adresse adresse) {
		super(nom, prenom, mail, mdp, adresse);
		// TODO Auto-generated constructor stub
	}
	
	

}
