package course.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("Client")
public class Client extends Compte {
	
	@OneToMany(mappedBy = "client")
	private List<Commande> commandes;
	
	public Client() {
	}

	public Client(String login,String nom, String prenom, String mail, String mdp, Adresse adresse) {
		super(login,nom, prenom, mail, mdp, adresse);
		
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	
	

	
}
