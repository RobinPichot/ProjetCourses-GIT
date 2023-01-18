package course.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import course.model.Compte;
import course.model.Restaurant;
import course.model.Restaurateur;

public interface IDAORestaurant extends JpaRepository<Restaurant,Integer> {

@Query("from Restaurant r where r.adresse.ville= :Ville")
//fonction pour trouver les restaurant qui ont un même restaurateur
@Query("select distinct f from Restaurant f where f.restaurateur.id = :id")
public List<Restaurant> findByIdWithRestaurateur(@Param("id") Integer id);
List<Restaurant> findByVille(String Ville);
}
