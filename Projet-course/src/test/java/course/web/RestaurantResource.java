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

		@GetMapping("/{id}")
		@JsonView(Views.ViewRestaurant.class)
		public Restaurant findById(@PathVariable Integer id) {
			Optional<Restaurant> optRestaurant = daoRestaurant.findById(id);

			if (optRestaurant.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}

			return optRestaurant.get();
		}
		
//		@GetMapping("/{id}/with-stagiaires")
//		@JsonView(Views.ViewRestaurantWithStagiaires.class)
//		public Restaurant findByIdWithStagiaires(@PathVariable Integer id) {
//			Optional<Restaurant> optRestaurant = daoRestaurant.findByIdWithStagiaires(id);
//
//			if (optRestaurant.isEmpty()) {
//				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//			}
//
//			return optRestaurant.get();
//		}
//		
//		@GetMapping("/{id}/with-matieres")
//		@JsonView(Views.ViewRestaurantWithMatieres.class)
//		public Restaurant findByIdWithMatieres(@PathVariable Integer id) {
//			Optional<Restaurant> optRestaurant = daoRestaurant.findByIdWithMatieres(id);
//
//			if (optRestaurant.isEmpty()) {
//				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//			}
//
//			return optRestaurant.get();
//		}
//		
//		@GetMapping("/{id}/with-all")
//		@JsonView(Views.ViewRestaurantWithAll.class)
//		public Restaurant findByIdWithAll(@PathVariable Integer id) {
//			Optional<Restaurant> optRestaurant = daoRestaurant.findByIdWithMatieres(id);		
//
//			if (optRestaurant.isEmpty()) {
//				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//			}
//			
//			List<Stagiaire> stagiaires = daoStagiaire.findAllByRestaurant(id);
//			
//			Restaurant restaurant = optRestaurant.get();
//			restaurant.setStagiaires(stagiaires);
//
//			return restaurant;
//		}

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
	}



