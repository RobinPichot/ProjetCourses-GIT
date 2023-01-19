package course.web;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

import course.dao.IDAOCommande;
import course.dao.IDAOCompte;
import course.dao.IDAOPanier;
import course.model.Client;
import course.model.Commande;
import course.model.Livreur;
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
	@Autowired
	
	private IDAOCompte daoCompte;
	
	
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
	
	
	//FIND COMMANDE PAS LIVREE BY ID CLIENT
	@GetMapping("/attente/paye/{id}")
	@JsonView(Views.ViewCommande.class)
	public Commande findCommandeByIdClient(@PathVariable Integer id ) {
		Optional<Commande> optCommande = daoCommande.findCommandeByIdClient(id);
		if (optCommande.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return optCommande.get();
	}
	
	
	//FIND ALL COMMANDES PAR CLIENT
		@GetMapping("/all/{id}")
		@JsonView(Views.ViewCommande.class)
		public List<Commande> findAllCommandeByIdClient(@PathVariable Integer id ) {
			List<Commande> optCommande = daoCommande.findAllCommandeByIdClient(id);


			return optCommande;
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
	
	@GetMapping("/livreur/{id}/nonLivree")
	@JsonView(Views.ViewCommande.class)
	public List<Commande> findNonLivreeByLivreur(@PathVariable Integer id) {
		List<Commande> commandes = daoCommande.findNonLivreeByLivreur(id);

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
	
	//fonction pour trouver les commandes du même restaurant
		@GetMapping("/{id}/with-restau")
		@JsonView(Views.ViewCommandeWithRestaurants.class)
		public List<Commande> findByIdWithRestaurant(@PathVariable Integer id) {
			 List<Commande> ListeCommande = daoCommande.findByIdWithRestaurant(id);
		
			if (ListeCommande.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
		
			return ListeCommande;
		}
	
		//CREATION COMMANDE NULL
		@PostMapping("{id}")
		@JsonView(Views.ViewCommande.class)
		public Commande createNull(@PathVariable Integer id) {
			Commande commande = new Commande();
			
			Client client = new Client();
			client = (Client) daoCompte.findById(id).get();
			
			commande.setClient(client);
			commande.setDate(LocalDateTime.now());
			commande = daoCommande.save(commande);
			commande.setNumeroCommande(commande.getId()*137);
			commande = daoCommande.save(commande);
			return commande;
		}
		
		
	// CREATION COMMANDE
	@PostMapping("/panier/create")
	@JsonView(Views.ViewCommande.class)
	public Commande create(@Valid @RequestBody Commande commande, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le commande n'a pu être créé");
		}
		 
		commande = daoCommande.save(commande);

		return commande;
	}
	
	//UPDATE COMPTE
	
	@PutMapping("/{id}/changer-livreur/{idLivreur}")
	@JsonView(Views.ViewCompte.class)
	public Commande update(@PathVariable Integer id,@PathVariable Integer idLivreur) {
		
		// Rechercher la commande
		Commande commande = new Commande();
		commande = daoCommande.findById(id).get();
		
		// Rechercher le compte du livreur
		Livreur livreur = new Livreur();
		livreur = (Livreur) daoCompte.findById(idLivreur).get();
		
		// Association du livreur à la commande
//		commande.getLivreur().setId(idLivreur);
//		commande.getLivreur().setNom(livreur.getNom());
//		commande.getLivreur().setPrenom(livreur.getPrenom());
//		commande.getLivreur().setMail(livreur.getMail());
//		commande.getLivreur().setLogin(livreur.getLogin());
//		commande.getLivreur().setMdp(livreur.getMdp());
//		commande.getLivreur().setAdresse(livreur.getAdresse());
		commande.setLivreur(livreur);
		
		// Sauvegarde de la commande
		commande = daoCommande.save(commande);

		return commande;
	}
	
	@PutMapping("/{id}/confirmer-livraison")
	@JsonView(Views.ViewCompte.class)
	public Commande updateStatutCommande(@PathVariable Integer id) {
		
		// Rechercher la commande
		Commande commande = new Commande();
		commande = daoCommande.findById(id).get();
		
		//Changer le booléen Livrée sur Vrai
		commande.setLivree(true);
		
		// Sauvegarde de la commande
		commande = daoCommande.save(commande);

		return commande;
	}
	
	
	//UPDATE STATUT PAYEE COMMANDE
	
	@PutMapping("panier/paye/{id}")
	@JsonView(Views.ViewCompte.class)
	public Commande updatePayee(@PathVariable Integer id) {
		
		// Rechercher la commande
		Commande commande = new Commande();
		commande = daoCommande.findCommandeByIdClient(id).get();
		
		//Changer le booléen Livrée sur Vrai
		commande.setPayee(true);
		
		// Sauvegarde de la commande
		commande = daoCommande.save(commande);

		return commande;
	}
	
	//DELETE COMMANDE
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		if (!daoCommande.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoCommande.deleteById(id);
	}
	
	
}
