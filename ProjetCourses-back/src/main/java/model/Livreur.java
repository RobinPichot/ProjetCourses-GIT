package model;

public class Livreur extends Compte {

	public Livreur(String nom, String prenom, String mail, String mdp, Adresse adresse) {
		super(nom, prenom, mail, mdp, adresse);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Livreur [nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", mdp=" + mdp + ", adresse=" + adresse
				+ "]";
	}
	
	

}
