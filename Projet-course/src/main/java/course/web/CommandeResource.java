package course.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import course.dao.IDAOCommande;
import course.model.Commande;
import course.model.Views;

@RestController
@RequestMapping("/commandes")
@CrossOrigin("*")
public class CommandeResource {

	@Autowired
	private IDAOCommande daoCommande;
	
	
	@GetMapping("")
	@JsonView(Views.ViewCommande.class)
	public List<Commande> findall() {
		List<Commande> commandes = daoCommande.findAll();

		return commandes;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCommande.class)
	public Commande findById(@PathVariable Integer id) {
		Optional<Commande> optCommande = daoCommande.findById(id);

		if (optCommande.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optCommande.get();
	}

//	@GetMapping("/{id}/with-matieres")
//	@JsonView(Views.ViewCommandeWithRestaurants.class)
//	public Commande findByIdWithRestaurants(@PathVariable Integer id) {
//		Optional<Commande> optCommande = daoCommande.findByIdWithRestaurants(id);
//
//		if (optCommande.isEmpty()) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//		}
//
//		return optCommande.get();
//	}
	
	
	@PostMapping("")
	@JsonView(Views.ViewCommande.class)
	public Commande create(@Valid @RequestBody Commande commande, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le commande n'a pu être créé");
		}

		commande = daoCommande.save(commande);

		return commande;
	}
}
