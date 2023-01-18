package course.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="restaurant")
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	private Integer id;
	
	@Column(name="nom_du_restaurant",nullable=false)
	@JsonView(Views.ViewBase.class)
	private String nom;
	
	@Column(name="etat", nullable=false)
	@JsonView(Views.ViewBase.class)
	private boolean ouvert;
	
	@Column(nullable=true)
	@JsonView(Views.ViewBase.class)
	private double notation;
	
	@JsonView(Views.ViewBase.class)
	private String descriptionRestaurant;
	
	@JsonView(Views.ViewBase.class)
	private Adresse adresse;
	
	@OneToMany(mappedBy="restaurant")
	private List<Plat> menu;
	
	@Column( nullable=false)
	@OneToMany(mappedBy="restaurant")
	private List<Commande> commandes;
	
	@ManyToOne
	private Restaurateur restaurateur;
	
	



	public Restaurant() {}
	
	


	public Restaurant(String nom, boolean ouvert, double notation, String descriptionRestaurant,
		 Adresse adresse, Restaurateur restaurateur) {
		super();
		
		this.nom = nom;
		this.ouvert = ouvert;
		this.notation = notation;
		this.descriptionRestaurant = descriptionRestaurant;
		this.adresse=adresse;
		this.restaurateur=restaurateur;
	}


	public Adresse getAdresse() {
		return adresse;
	}




	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isOuvert() {
		return ouvert;
	}


	public void setOuvert(boolean ouvert) {
		this.ouvert = ouvert;
	}


	public double getNotation() {
		return notation;
	}


	public void setNotation(double notation) {
		this.notation = notation;
	}


	public List<Plat> getMenu() {
		return menu;
	}


	public void setMenu(List<Plat> menu) {
		this.menu = menu;
	}

	public String getDescriptionRestaurant() {
		return descriptionRestaurant;
	}

	public void setDescriptionRestaurant(String descriptionRestaurant) {
		this.descriptionRestaurant = descriptionRestaurant;
	}


	public List<Commande> getCommandes() {
		return commandes;
	}



	public Restaurateur getRestaurateur() {
		return restaurateur;
	}




	public void setRestaurateur(Restaurateur restaurateur) {
		this.restaurateur = restaurateur;
	}




	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	
	

	



}
