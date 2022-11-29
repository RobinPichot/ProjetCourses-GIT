package model;

public class Evaluation {

	private int note; 
	private String description;
	
	public Evaluation(int note, String description) {
		super();
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

	@Override
	public String toString() {
		return "Evaluation [note=" + note + ", description=" + description + "]";
	}
	
	
}
