package course.web;

import java.lang.reflect.Field;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import course.dao.IDAOPlat;
import course.dao.IDAOPlat;
import course.model.Commande;
import course.model.Plat;
import course.model.Views;


@RestController
@RequestMapping("/plats")
@CrossOrigin("*")
public class PlatResource {
	
	@Autowired
	private IDAOPlat daoPlat;
	
	@GetMapping("")
	@JsonView(Views.ViewBase.class)
	public List<Plat> findAll() {
		List<Plat> plats = daoPlat.findAll();

		return plats;
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewBase.class)
	public Plat findById(@PathVariable Integer id) {
		Optional<Plat> optPlat = daoPlat.findById(id);

		if (optPlat.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optPlat.get();
	}

//	@GetMapping("/{id}/dto")
//	public PlatDTO findDTOById(@PathVariable Integer id) {
//		final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//
//		Optional<Plat> optPlat = daoPlat.findById(id);
//
//		if (optPlat.isEmpty()) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//		}
//
//		Plat plat = optPlat.get();
//
//		PlatDTO platDTO = new PlatDTO();
//
//		platDTO.setIdentifiant(plat.getId());
//		platDTO.setNom(plat.getNom());
//		platDTO.setPrenom(plat.getPrenom());
//		platDTO.setEmail(plat.getEmail());
//		platDTO.setIdFiliere(plat.getFiliere().getId());
//		platDTO.setNomFiliere(plat.getFiliere().getLibelle());
//		platDTO.setDebutFiliere(plat.getFiliere().getDebut());
//		platDTO.setFinFiliere(plat.getFiliere().getFin());
//		platDTO.setDebutFiliereString(dtf.format(plat.getFiliere().getDebut()));
//		platDTO.setFinFiliereString(dtf.format(plat.getFiliere().getFin()));
//
//		return platDTO;
//	}

	@PostMapping("")
	@JsonView(Views.ViewBase.class)
	public Plat create(@Valid @RequestBody Plat plat, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le plat n'a pu être créée");
		}

		plat = daoPlat.save(plat);

		return plat;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewBase.class)
	public Plat update(@PathVariable Integer id, @RequestBody Plat plat) {
		if (id != plat.getId() || !daoPlat.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		plat = daoPlat.save(plat);

		return plat;
	}

//	@PatchMapping("/{id}")
//	@JsonView(Views.ViewPlat.class)
//	public Plat partialUpdate(@PathVariable Integer id, @RequestBody Map<String, Object> fields) {
//		Optional<Plat> optPlat = daoPlat.findById(id);
//
//		if (optPlat.isEmpty()) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//		}
//
//		final Plat plat = optPlat.get();

//		if(fields.containsKey("nom")) {
//			plat.setNom((String) fields.get("nom"));
//		}
//		
//		if(fields.containsKey("prenom")) {
//			plat.setPrenom((String) fields.get("prenom"));
//		}
//
//		if(fields.containsKey("email")) {
//			plat.setEmail((String) fields.get("email"));
//		}
//
//		fields.forEach((key, value) -> {
//			Field field = ReflectionUtils.findField(Plat.class, key);
//			if (field == null) {
//				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Propriété : " + key + "non trouvée");
//			}
//			ReflectionUtils.makeAccessible(field);
//			ReflectionUtils.setField(field, plat, value);
//		});
//
//		return daoPlat.save(plat);
//	}
	
	//fonction pour trouver les plats du même restaurant
			@GetMapping("/{id}/with-restau")
			@JsonView(Views.ViewPlatWithRestaurant.class)
			public List<Plat> findByIdWithRestaurant(@PathVariable Integer id) {
				 List<Plat> ListePlat = daoPlat.findByIdWithRestaurant(id);
			
				
			
				return ListePlat;
			}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!daoPlat.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoPlat.deleteById(id);
	}
	
	

}
