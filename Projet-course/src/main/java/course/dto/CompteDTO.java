package course.dto;

public class CompteDTO {

	
	private Integer id;
	private String nom;
	private String prenom;
	private String mail;
	private String login;
	private String mdp;
	private String numero;
	private String rue;
	private String postal;
	private String ville;
	private String type;
	
	public CompteDTO() {
	}
	
	
	
	public CompteDTO(String nom, String prenom, String mail, String login, String mdp, String numero, String rue,
			String postal, String ville, String type) {
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.login = login;
		this.mdp = mdp;
		this.numero = numero;
		this.rue = rue;
		this.postal = postal;
		this.ville = ville;
		this.type = type;
	}



	public CompteDTO(Integer id, String nom, String prenom, String mail, String login, String mdp, String numero,
			String rue, String postal, String ville, String type) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.login = login;
		this.mdp = mdp;
		this.numero = numero;
		this.rue = rue;
		this.postal = postal;
		this.ville = ville;
		this.type = type;
	}



	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

}

