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
import course.dao.IDAOPanier;
import course.model.Commande;
import course.model.Panier;
import course.model.Views;

@RestController
@RequestMapping("/commandes")
@CrossOrigin("*")
public class CommandeResource {

	@Autowired
	private IDAOCommande daoCommande;
	@Autowired
	private IDAOPanier daoPanier;
	
	@GetMapping("/panier")
	@JsonView(Views.ViewPanier.class)
	public List<Panier> findallpanier() {
		List<Panier> paniers = daoPanier.findAll();

		return paniers;
	}
	
	@GetMapping("")
	@JsonView(Views.ViewCommande.class)
	public List<Commande> findall() {
		List<Commande> commandes = daoCommande.findAll();

		return commandes;
	}
	
//FIND PANIER BY COMMANDES ID ET CLIENT ID
	@GetMapping("panier/client/{id}")
	@JsonView(Views.ViewPanier.class)
	public List<Panier> findPanierByIdCommandeByIdClient (@PathVariable Integer id ) {
		Commande commande = daoCommande
				.findCommandeByIdClient(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
		Integer idcom = commande.getId();
		List<Panier> paniers = daoPanier.findPanierByIdCommande(idcom);
		
		if (paniers.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return paniers;
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
	
	@GetMapping("/panier/{id}")
	@JsonView(Views.ViewPanier.class)
	public Panier findPanierById(@PathVariable Integer id) {
		Optional<Panier> optPanier = daoPanier.findById(id);

		if (optPanier.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return optPanier.get();
	}
	
	@GetMapping("/sansLivreur/nonLivrees")
	@JsonView(Views.ViewCommande.class)
	public List<Commande> findAllNonLivreesEtSansLivreur() {
		List<Commande> commandes = daoCommande.findAllNonLivreesEtSansLivreur();

		return commandes;
	}
	
	@GetMapping("/livreur/{id}/livree")
	@JsonView(Views.ViewCommande.class)
	public List<Commande> findLivreeByLivreur(@PathVariable Integer id) {
		List<Commande> commandes = daoCommande.findLivreeByLivreur(id);

		return commandes;
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
