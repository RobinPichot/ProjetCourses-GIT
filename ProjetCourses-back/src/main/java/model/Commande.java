package model;

import java.time.LocalDate;
import java.util.HashMap;

public class Commande {

	private boolean livree;
	private int numeroCommande;
	private LocalDate date;
	private boolean payee;
	private HashMap<Plat,Integer> panier; //????????????????




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
	@Override
	public String toString() {
		return "Commande [livree=" + livree + ", numeroCommande=" + numeroCommande + ", date=" + date + ", payee="
				+ payee + ", panier=" + panier + "]";
	}



}




