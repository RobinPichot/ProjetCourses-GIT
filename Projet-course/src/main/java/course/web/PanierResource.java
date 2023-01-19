package course.web;

import java.time.LocalDateTime;
import java.util.List;

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
import course.dao.IDAOPlat;
import course.model.Client;
import course.model.Commande;
import course.model.Panier;
import course.model.Plat;
import course.model.Views;

@RestController
@RequestMapping("/paniers")
@CrossOrigin("*")
public class PanierResource {
	
	@Autowired
	private IDAOPanier daoPanier ;
	@Autowired	
	private IDAOCommande daoCommande;
	@Autowired	
	private IDAOPlat daoPlat;
	//FIND ALL PANIER
	@GetMapping("")
	@JsonView(Views.ViewPanier.class)
	public List<Panier> findallpanier() {
		List<Panier> paniers = daoPanier.findAll();
		return paniers;
	}
	
	
//	@PostMapping("/create")
//	@JsonView(Views.ViewBase.class)
//	public Panier create(@Valid @RequestBody Panier panier, BindingResult result) {
//		if (result.hasErrors()) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le panier n'a pu être créée");
//		}
//
//		panier = daoPanier.save(panier);
//
//		return panier;
//	}
//	
	@PostMapping("/create/{idCom}/{idPlat}/{qte}")
	@JsonView(Views.ViewCommande.class)
	public Panier create(@PathVariable Integer idCom,@PathVariable Integer idPlat,@PathVariable Integer qte) {
		Panier panier = new Panier();
		Commande commande = new Commande();
		Plat plat = new Plat();
		commande = daoCommande.findById(idCom).get();
		plat = daoPlat.findById(idPlat).get();
		panier.setCommande(commande);
		panier.setPlat(plat);
		panier.setQuantite(qte);
		panier = daoPanier.save(panier);
		
		return panier;
	}
}
