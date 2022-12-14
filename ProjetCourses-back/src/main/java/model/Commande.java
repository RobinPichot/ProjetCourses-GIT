package model;

import java.time.LocalDate;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private boolean livree;
	private int numeroCommande;
	private LocalDate date;
	private boolean payee;
	
	@OneToMany
	private HashMap<Plat,Integer> panier; //????????????????

	@OneToOne
	private Client client;
	
	@OneToOne
	private Livreur livreur;
	
	@OneToOne
	private Evaluation evaluationRestaurant;
	
	@OneToOne
	private Evaluation evaluationLivraison;
		
	@Enumerated(EnumType.STRING)
	@Column(name="moy_payement",nullable = false,columnDefinition = "ENUM('CB','Paypal','ApplePay','GooglePay','TicketsResto'")
	private MoyPayement moyPayement;
	
	
	public Commande() {
	}
	
	public Commande(boolean livree, int numeroCommande, LocalDate date, boolean payee, HashMap<Plat, Integer> panier) {
		this.livree = livree;
		this.numeroCommande = numeroCommande;
		this.date = date;
		this.payee = payee;
		this.panier = panier;
	}
	public boolean isLivree() {
		return livree;
	}
	public void setLivree(boolean livree) {
		this.livree = livree;
	}
	public int getNumeroCommande() {
		return numeroCommande;
	}
	public void setNumeroCommande(int numeroCommande) {
		this.numeroCommande = numeroCommande;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public boolean isPayee() {
		return payee;
	}
	public void setPayee(boolean payee) {
		this.payee = payee;
	}

	public HashMap<Plat, Integer> getPanier() {
		return panier;
	}

	public Client getClient() {
		return client;
	}

	public Livreur getLivreur() {
		return livreur;
	}

	public Evaluation getEvaluationRestaurant() {
		return evaluationRestaurant;
	}

	public Evaluation getEvaluationLivraison() {
		return evaluationLivraison;
	}

	public void setPanier(HashMap<Plat, Integer> panier) {
		this.panier = panier;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}

	public void setEvaluationRestaurant(Evaluation evaluationRestaurant) {
		this.evaluationRestaurant = evaluationRestaurant;
	}

	public void setEvaluationLivraison(Evaluation evaluationLivraison) {
		this.evaluationLivraison = evaluationLivraison;
	}

	public MoyPayement getMoyPayement() {
		return moyPayement;
	}

	public void setMoyPayement(MoyPayement moyPayement) {
		this.moyPayement = moyPayement;
	}
	

}




