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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Commande")
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Boolean livree;
	private Integer numeroCommande;
	private LocalDate date;
	private Boolean payee;
	
//    @OneToMany(mappedBy="commande")
//	private HashMap<Plat,Integer> panier; //????????????????

	@OneToOne
	@JoinColumn(name="id_client")
	private Client client;
//	
	@ManyToOne
	@JoinColumn(name="livreur")
	private Livreur livreur;
//	
	@OneToOne
	@JoinColumn(name="id_eval_restaurant")
	private Evaluation evaluationRestaurant;
	
	@OneToOne
	@JoinColumn(name="id_eval_livraison")
	private Evaluation evaluationLivraison;
//		
	@Enumerated(EnumType.STRING)
	@Column(name="moy_payement",nullable = false,columnDefinition = "ENUM('CB','Paypal','ApplePay','GooglePay','TicketsResto')")
	private MoyPayement moyPayement;
	
	
	public Commande() {
	}


	public Commande(  Integer numeroCommande, LocalDate date, Boolean payee, Client client,
			Livreur livreur, Evaluation evaluationRestaurant, Evaluation evaluationLivraison, MoyPayement moyPayement,Boolean livree) {
		
		this.livree = livree;
		this.numeroCommande = numeroCommande;
		this.date = date;
		this.payee = payee;
		this.client = client;
		this.livreur = livreur;
		this.evaluationRestaurant = evaluationRestaurant;
		this.evaluationLivraison = evaluationLivraison;
		this.moyPayement = moyPayement;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Boolean getLivree() {
		return livree;
	}


	public void setLivree(Boolean livree) {
		this.livree = livree;
	}


//	public Integer getNumeroCommande() {
//		return numeroCommande;
//	}
//
//
//	public void setNumeroCommande(Integer numeroCommande) {
//		this.numeroCommande = numeroCommande;
//	}
//
//
//	public LocalDate getDate() {
//		return date;
//	}
//
//
//	public void setDate(LocalDate date) {
//		this.date = date;
//	}
//
//
//	public Boolean getPayee() {
//		return payee;
//	}
//
//
//	public void setPayee(Boolean payee) {
//		this.payee = payee;
//	}
//
//
//	public Client getClient() {
//		return client;
//	}
//
//
//	public void setClient(Client client) {
//		this.client = client;
//	}
//
//
//	public Livreur getLivreur() {
//		return livreur;
//	}
//
//
//	public void setLivreur(Livreur livreur) {
//		this.livreur = livreur;
//	}
//
//
//	public Evaluation getEvaluationRestaurant() {
//		return evaluationRestaurant;
//	}
//
//
//	public void setEvaluationRestaurant(Evaluation evaluationRestaurant) {
//		this.evaluationRestaurant = evaluationRestaurant;
//	}
//
//
//	public Evaluation getEvaluationLivraison() {
//		return evaluationLivraison;
//	}
//
//
//	public void setEvaluationLivraison(Evaluation evaluationLivraison) {
//		this.evaluationLivraison = evaluationLivraison;
//	}
//
//
//	public MoyPayement getMoyPayement() {
//		return moyPayement;
//	}
//
//
//	public void setMoyPayement(MoyPayement moyPayement) {
//		this.moyPayement = moyPayement;
//	}
//
//
//	@Override
//	public String toString() {
//		return "Commande [id=" + id + ", livree=" + livree + ", numeroCommande=" + numeroCommande + ", date=" + date
//				+ ", payee=" + payee + ", client=" + client + ", livreur=" + livreur + ", evaluationRestaurant="
//				+ evaluationRestaurant + ", evaluationLivraison=" + evaluationLivraison + ", moyPayement=" + moyPayement
//				+ "]";
//	}
	
	
	
	
	
}




