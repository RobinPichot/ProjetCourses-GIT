package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	
	
	public Plat() {
		super();
	}


	public Plat(String nom, int prix, String description, boolean dispo) {
		this.nom = nom;
		this.prix = prix;
		this.description = description;
		this.dispo = dispo;
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


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Plat [id=" + id + ", nom=" + nom + ", prix=" + prix + ", description=" + description + ", dispo="
				+ dispo + "]";
	}


	
	
	
	
	
}
