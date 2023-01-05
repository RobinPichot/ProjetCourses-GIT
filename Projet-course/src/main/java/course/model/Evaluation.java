package course.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Evaluation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewBase.class)
	private Integer id;
	
	@JsonView(Views.ViewBase.class)
	private double note; 
	
	@JsonView(Views.ViewBase.class)
	private String description;
	
	@OneToOne(mappedBy = "evaluationRestaurant")
	@JsonView(Views.ViewBase.class)
	private Commande commande;
	
	@OneToOne(mappedBy = "evaluationLivraison")
	@JsonView(Views.ViewBase.class)
	private Commande commandeR;
	
	public Evaluation() {
	}
	public Evaluation(double note, String description) {
		this.note = note;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getNote() {
		return note;
	}

	public void setNote(double note) {
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
