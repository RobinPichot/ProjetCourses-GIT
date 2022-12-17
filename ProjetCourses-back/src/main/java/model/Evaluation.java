package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Evaluation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer note; 
	private String description;
	
	@OneToOne(mappedBy = "evaluationRestaurant")
	private Commande commande;
	
	@OneToOne(mappedBy = "evaluationLivraison")
	private Commande commandeR;
	
	public Evaluation() {
	}
	public Evaluation(int note, String description) {
		this.note = note;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Evaluation [id=" + id + ", note=" + note + ", description=" + description + ", commande=" + commande
				+ ", commandeR=" + commandeR + "]";
	}

	
	
	
}
