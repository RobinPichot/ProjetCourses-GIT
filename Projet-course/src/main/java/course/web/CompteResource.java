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
import course.model.Compte;
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
	public Compte update(@PathVariable Integer id, @RequestBody Compte compte) {
		if (id != compte.getId() || !daoCompte.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		compte = daoCompte.save(compte);

		return compte;
	}

	//DELETE COMPTE
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!daoCompte.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoCompte.deleteById(id);
	}
	
}
