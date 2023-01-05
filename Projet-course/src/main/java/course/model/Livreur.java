package course.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("Livreur")
public class Livreur extends Compte {

	@OneToMany(mappedBy = "livreur")
	private List<Commande> commande;
	
	public Livreur() {
	}
	public Livreur(String nom, String prenom, String mail, String mdp, Adresse adresse) {
		super(nom, prenom, mail, mdp, adresse);
	}
	public List<Commande> getCommande() {
		return commande;
	}
	public void setCommande(List<Commande> commande) {
		this.commande = commande;
	}
	
	
	@Override
	public String toString() {
		return "Livreur [commande=" + commande + "]";
	}
	
	

	
	
	

}
