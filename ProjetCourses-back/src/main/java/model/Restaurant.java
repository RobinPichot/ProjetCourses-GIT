package model;

import java.util.List;

public class Restaurant {

	private boolean ouvert;
	private double notation;
	private List<Plat> menu;
	
	
	public Restaurant(boolean ouvert, double notation, List<Plat> menu) {
		this.ouvert = ouvert;
		this.notation = notation;
		this.menu = menu;
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


	@Override
	public String toString() {
		return "Restaurant [ouvert=" + ouvert + ", notation=" + notation + ", menu=" + menu + "]";
	}
	
	



}
