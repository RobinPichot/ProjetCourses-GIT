package course.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "Panier")
public class Panier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	private Integer id;
	
	@OneToOne
	@JsonView(Views.ViewBase.class)
	private Plat plat;
	@JsonView(Views.ViewBase.class)
	private int quantite;
	
	@ManyToOne
	@JsonView(Views.ViewBase.class)
	private Commande commande;
	
	
	
	public Panier() {
		// TODO Auto-generated constructor stub
	}

	public Panier(Plat plat, int quantite) {
		this.plat = plat;
		this.quantite = quantite;
	}

	
	
	public Panier(Integer id, Plat plat, int quantite, Commande commande) {
		this.id = id;
		this.plat = plat;
		this.quantite = quantite;
		this.commande = commande;
	}

	public Plat getPlat() {
		return plat;
	}

	public void setPlat(Plat plat) {
		this.plat = plat;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	
	

}
