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

import course.dao.IDAORestaurant;
import course.model.Compte;
import course.model.Restaurant;
import course.model.Views;




@RestController
@RequestMapping("/restaurants")
@CrossOrigin("*")
public class RestaurantResource {
	

		@Autowired
		private IDAORestaurant daoRestaurant;
		
//		@Autowired
//		private IDAOStagiaire daoStagiaire;

		@GetMapping("")
		@JsonView(Views.ViewRestaurant.class)
		public List<Restaurant> findAll() {
			List<Restaurant> restaurants = daoRestaurant.findAll();

			return restaurants;
		}
		//FIND RESTAURANT (PAR VILLE)
		@GetMapping("/recherche/{Ville}")
		@JsonView(Views.ViewRestaurant.class)
		public Restaurant findByVille(@PathVariable String Ville) {
			Optional<Restaurant> restaurant = daoRestaurant.findByVille(Ville);

			if (restaurant.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
			
			return restaurant.get();
		}

		@GetMapping("/{id}")
		@JsonView(Views.ViewRestaurant.class)
		public Restaurant findById(@PathVariable Integer id) {
			Optional<Restaurant> optRestaurant = daoRestaurant.findById(id);

			if (optRestaurant.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}

			return optRestaurant.get();
		}
	

		@PostMapping("")
		@JsonView(Views.ViewRestaurant.class)
		public Restaurant create(@Valid @RequestBody Restaurant restaurant, BindingResult result) {
			if (result.hasErrors()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le restaurant n'a pu être créé");
			}

			restaurant = daoRestaurant.save(restaurant);

			return restaurant;
		}

		@PutMapping("/{id}")
		@JsonView(Views.ViewRestaurant.class)
		public Restaurant update(@PathVariable Integer id, @RequestBody Restaurant restaurant) {
			if (id != restaurant.getId() || !daoRestaurant.existsById(id)) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}

			restaurant = daoRestaurant.save(restaurant);

			return restaurant;
		}

		@DeleteMapping("/{id}")
		public void delete(@PathVariable Integer id) {
			if (!daoRestaurant.existsById(id)) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}

			daoRestaurant.deleteById(id);
		}
	


	//fonction pour trouver les restaurant qui ont un même restaurateur
	@GetMapping("/{id}/with-restaurants")
	@JsonView(Views.ViewRestaurateurWithRestaurants.class)
	public List<Restaurant> findByIdWithRestaurateur(@PathVariable Integer id) {
		 List<Restaurant> ListeRestaurant = daoRestaurant.findByIdWithRestaurateur(id);
	
		if (ListeRestaurant.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	
		return ListeRestaurant;
	}
	
	}
