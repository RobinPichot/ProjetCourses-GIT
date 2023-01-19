package course.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="Plats")
public class Plat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	private Integer id;
	@JsonView(Views.ViewBase.class)
	private String nom;
	@JsonView(Views.ViewBase.class)
	private int prix;
	@JsonView(Views.ViewBase.class)
	private String description; 
	
	@JoinColumn(name = "house_id")
	@JsonView(Views.ViewPlatWithRestaurant.class)
	@ManyToOne
	private Restaurant restaurant;
	
	@OneToMany (mappedBy = "plat")
	private List<Panier> paniers;
	
	@Column(nullable=true)
	@JsonView(Views.ViewBase.class)
	private String imageP;
	
	
//	@ManyToOne
//	@JoinColumn(name="id_commande", nullable=false)
//    private Commande commande;
	
	public Plat() {
	}

public Plat(String nom, int prix, String description, Restaurant restaurant, String imageP) {
	this.nom = nom;
	this.prix = prix;
	this.description = description;
	this.restaurant= restaurant;
	this.imageP = imageP;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public int getPrix() {
	return prix;
}

public void setPrix(int prix) {
	this.prix = prix;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}


public String getImageP() {
	return imageP;
}

public void setImageP(String imageP) {
	this.imageP = imageP;
}

public Panier getPanier() {
	return panier;
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
