package model;

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
	
	@Column(name="etat", nullable=false)
	private boolean ouvert;
	
	@Column(nullable=false)
	private double notation;
	
	@OneToMany(mappedBy="restaurant")
	private List<Plat> menu;
	
	public Restaurant() {}
	
	public Restaurant(boolean ouvert, double notation, List<Plat> menu) {
		this.ouvert = ouvert;
		this.notation = notation;
		this.menu = menu;
	}

	

	public Restaurant(Integer id, boolean ouvert, double notation, List<Plat> menu) {
		this.id = id;
		this.ouvert = ouvert;
		this.notation = notation;
		this.menu = menu;
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

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", ouvert=" + ouvert + ", notation=" + notation + ", menu=" + menu + "]";
	}


	
	
	



}
