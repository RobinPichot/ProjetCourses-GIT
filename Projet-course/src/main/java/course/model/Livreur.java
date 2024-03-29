package course.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("Livreur")
public class Livreur extends Compte {

	@OneToMany(mappedBy = "livreur", fetch = FetchType.LAZY)
	private List<Commande> commande;
	
	public Livreur() {
	}
	public Livreur(String login,String nom, String prenom, String mail, String mdp, Adresse adresse) {
		super(login,nom, prenom, mail, mdp, adresse);
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
