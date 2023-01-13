package course.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("Client")
public class Client extends Compte {
	
	@OneToOne(mappedBy = "client")
	private Commande commande;
	
	public Client() {
	}

	public Client(String login,String nom, String prenom, String mail, String mdp, Adresse adresse) {
		super(login,nom, prenom, mail, mdp, adresse);
		
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	

	
}
