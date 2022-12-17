package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="matiere")
public class Plat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private int prix;
	private String description; 
	private boolean dispo;
	
	@JoinColumn(name = "house_id")
	@ManyToOne
	private Restaurant restaurant;
	
//	@ManyToOne
//	@JoinColumn(name="id_commande", nullable=false)
//    private Commande commande;
	
	public Plat() {
	}

public Plat(Integer id, String nom, int prix, String description, boolean dispo, Restaurant restaurant) {
	super();
	this.id = id;
	this.nom = nom;
	this.prix = prix;
	this.description = description;
	this.dispo = dispo;
	this.restaurant = restaurant;
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

public boolean isDispo() {
	return dispo;
}

public void setDispo(boolean dispo) {
	this.dispo = dispo;
}

public Restaurant getRestaurant() {
	return restaurant;
}

public void setRestaurant(Restaurant restaurant) {
	this.restaurant = restaurant;
}

@Override
public String toString() {
	return "Plat [id=" + id + ", nom=" + nom + ", prix=" + prix + ", description=" + description + ", dispo=" + dispo
			+ ", restaurant=" + restaurant + "]";
}


	
}
