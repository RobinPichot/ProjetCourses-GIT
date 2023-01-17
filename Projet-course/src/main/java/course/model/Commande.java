package course.model;

import java.time.LocalDateTime;
import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "Commande")
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	private Integer id;
	
	@JsonView(Views.ViewBase.class)
	private Boolean livree;
	@JsonView(Views.ViewBase.class)
	private Integer numeroCommande;
	@JsonView(Views.ViewBase.class)
	private LocalDateTime date;
	@JsonView(Views.ViewBase.class)
	private Boolean payee;
	
	@OneToMany(mappedBy = "commande")
	private List<Panier> paniers; //????????????????

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
	
	@JoinColumn(name = "restaurant")
	@ManyToOne
	private Restaurant restaurant;
	
	public Commande() {
	}


	public Commande( Boolean livree, Integer numeroCommande, LocalDateTime date, Boolean payee,
			List<Panier> paniers, Client client, Livreur livreur, Evaluation evaluationRestaurant,
			Evaluation evaluationLivraison, MoyPayement moyPayement, Restaurant restaurant) {
		super();
		
		this.livree = livree;
		this.numeroCommande = numeroCommande;
		this.date = date;
		this.payee = payee;
		this.paniers = paniers;
		this.client = client;
		this.livreur = livreur;
		this.evaluationRestaurant = evaluationRestaurant;
		this.evaluationLivraison = evaluationLivraison;
		this.moyPayement = moyPayement;
		this.restaurant = restaurant;
	}





	public Integer getId() {
		return id;
	}


	public Boolean getLivree() {
		return livree;
	}


	public Integer getNumeroCommande() {
		return numeroCommande;
	}


	public LocalDateTime getDate() {
		return date;
	}


	public Boolean getPayee() {
		return payee;
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


	public MoyPayement getMoyPayement() {
		return moyPayement;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void setLivree(Boolean livree) {
		this.livree = livree;
	}


	public void setNumeroCommande(Integer numeroCommande) {
		this.numeroCommande = numeroCommande;
	}


	public void setDate(LocalDateTime date) {
		this.date = date;
	}


	public void setPayee(Boolean payee) {
		this.payee = payee;
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


	public void setMoyPayement(MoyPayement moyPayement) {
		this.moyPayement = moyPayement;
	}


	public List<Panier> getPaniers() {
		return paniers;
	}


	public void setPaniers(List<Panier> paniers) {
		this.paniers = paniers;
	}


	public Restaurant getRestaurant() {
		return restaurant;
	}


	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}



	
	
}




