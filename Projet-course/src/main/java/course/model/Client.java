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
		// TODO Auto-generated constructor stub
	}

	public Client(String nom, String prenom, String mail, String mdp, Adresse adresse) {
		super(nom, prenom, mail, mdp, adresse);
		
		// TODO Auto-generated constructor stub
	}
//
	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}
//
//	@Override
//	public String toString() {
//		return "Client [commande=" + commande + ", id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail
//				+ ", mdp=" + mdp + ", adresse=" + adresse + "]";
//	}

	

	
}
