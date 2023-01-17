package course.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import course.model.Compte;
import course.model.Restaurant;

public interface IDAORestaurant extends JpaRepository<Restaurant,Integer> {

@Query("from Restaurant r where r.adresse.ville= :Ville")
Optional<Restaurant> findByVille(String Ville);
}
