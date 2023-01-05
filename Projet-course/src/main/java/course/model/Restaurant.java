package course.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="restaurant")
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nom_du_restaurant",nullable=false)
	private String nom;
	
	@Column(name="etat", nullable=false)
	private boolean ouvert;
	
	@Column(nullable=true)
	private double notation;
	
	private String descriptionRestaurant;
	
	@OneToMany(mappedBy="restaurant")
	private List<Plat> menu;
	
	public Restaurant() {}
	
	public Restaurant(String nom, boolean ouvert,String descriptionRestaurant, double notation, List<Plat> menu) {
		this.nom = nom;
		this.ouvert = ouvert;
		this.descriptionRestaurant = descriptionRestaurant;
		this.notation = notation;
		this.menu = menu;
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
	
	

	



}
