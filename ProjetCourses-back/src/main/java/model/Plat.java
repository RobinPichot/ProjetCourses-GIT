package model;

public class Plat {

	private String nom;
	private int prix;
	private String description; 
	private boolean dispo;
	
	
	public Plat(String nom, int prix, String description, boolean dispo) {
		super();
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
	
	
	
	
}
