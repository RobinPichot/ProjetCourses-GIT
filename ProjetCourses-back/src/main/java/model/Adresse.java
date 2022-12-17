package model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
public class Adresse {

	
	private String numero;
	private String rue;
	private String postal;
	private String ville;
	
	
	public Adresse() {
		super();
	}


	public Adresse(String numero, String rue, String postal, String ville) {
		this.numero = numero;
		this.rue = rue;
		this.postal = postal;
		this.ville = ville;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}


	public String getPostal() {
		return postal;
	}


	public void setPostal(String postal) {
		this.postal = postal;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	

	@Override
	public String toString() {
		return "Adresse [numero=" + numero + ", rue=" + rue + ", postal=" + postal + ", ville=" + ville
				+ "]";
	}

	
	
	
	
}
