package course.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;


import course.dao.IDAOCompte;
import course.dto.CompteDTO;
import course.model.Adresse;
import course.model.Client;
import course.model.Compte;
import course.model.Livreur;
import course.model.Restaurateur;
import course.model.Views;

@RestController
@RequestMapping("/comptes")
@CrossOrigin("*")
public class CompteResource {

	@Autowired
	private IDAOCompte daoCompte;
	
	
	// FIND ALL COMPTES
	
	@GetMapping("")
	@JsonView(Views.ViewCompte.class)
	public List<Compte> findAll() {
		List<Compte> comptes = daoCompte.findAll();

		return comptes;
	}
	//FIND CONNEXION
	@GetMapping("/connexion/{Login}/{mdp}")
	@JsonView(Views.ViewCompte.class)
	public Compte findByLoginAndPassword(@PathVariable String Login,@PathVariable String mdp) {
		Optional<Compte> compte = daoCompte.findByLoginAndPassword(Login,mdp);

		if (compte.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return compte.get();
	}
	
	
	
	// FIND COMPTE BY ID

	@GetMapping("/{id}")
	@JsonView(Views.ViewCompteDetail.class)
	public Compte findById(@PathVariable Integer id) {
		Optional<Compte> optCompte = daoCompte.findById(id);

		if (optCompte.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optCompte.get();
	}
	
	
	// POST COMPTE 
	
	@PostMapping("")
	@JsonView(Views.ViewCompte.class)
	public Compte create(@Valid @RequestBody Compte compte, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le compte n'a pu être créé");
		}

		compte = daoCompte.save(compte);

		return compte;
	}
	
	//UPDATE COMPTE
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewCompte.class)
	public Compte update(@PathVariable Integer id,@RequestBody CompteDTO formCompte) {
		if(formCompte.getType().equals("client")) {
			Client client = new Client();
			Adresse bidon = new Adresse();
			client.setAdresse(bidon);
			client.setNom(formCompte.getNom());
			client.setPrenom(formCompte.getPrenom());
			client.setMail(formCompte.getMail());
			client.setLogin(formCompte.getLogin());
			client.setMdp(formCompte.getMdp());
			client.getAdresse().setNumero(formCompte.getNumero());
			client.getAdresse().setRue(formCompte.getRue());
			client.getAdresse().setPostal(formCompte.getPostal());
			client.getAdresse().setVille(formCompte.getVille());

			client = daoCompte.save(client);
			
			return client;
		} 
		else if(formCompte.getType().equals("livreur")){
			Livreur livreur = new Livreur();
			
			livreur.setNom(formCompte.getNom());
			livreur.setPrenom(formCompte.getPrenom());
			livreur.setMail(formCompte.getMail());
			livreur.setLogin(formCompte.getLogin());
			livreur.setMdp(formCompte.getMdp());
			livreur.getAdresse().setNumero(formCompte.getNumero());
			livreur.getAdresse().setRue(formCompte.getRue());
			livreur.getAdresse().setPostal(formCompte.getPostal());
			livreur.getAdresse().setVille(formCompte.getVille());

			livreur = daoCompte.save(livreur);
			return livreur;
			
		}
		else {
			Restaurateur restaurateur = new Restaurateur();
			
			restaurateur.setNom(formCompte.getNom());
			restaurateur.setPrenom(formCompte.getPrenom());
			restaurateur.setMail(formCompte.getMail());
			restaurateur.setLogin(formCompte.getLogin());
			restaurateur.setMdp(formCompte.getMdp());
			restaurateur.getAdresse().setNumero(formCompte.getNumero());
			restaurateur.getAdresse().setRue(formCompte.getRue());
			restaurateur.getAdresse().setPostal(formCompte.getPostal());
			restaurateur.getAdresse().setVille(formCompte.getVille());

			restaurateur = daoCompte.save(restaurateur);
			return restaurateur;	
		}		
		}
	//DELETE COMPTE
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!daoCompte.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoCompte.deleteById(id);
	}
	
	
	@GetMapping("client/{login}")
	public Compte findByLogin(@PathVariable String login) {
		Compte compte = null;
		compte = daoCompte.findByLogin(login).get();
		return compte;
	}
}
