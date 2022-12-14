package model;

import javax.persistence.Entity;

@Entity
public class Evaluation {

	private int note; 
	private String description;
	
	public Evaluation() {
	}
	public Evaluation(int note, String description) {
		this.note = note;
		this.description = description;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	
}
