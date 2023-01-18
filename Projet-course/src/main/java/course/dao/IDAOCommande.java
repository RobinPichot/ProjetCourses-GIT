package course.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import course.model.Commande;
import course.model.Restaurant;

public interface IDAOCommande extends JpaRepository <Commande,Integer> {

//	@Query("select distinct c from Commande c left join fetch c.restaurant_id where c.id = :id")
//	public Optional<Commande> findByIdWithRestaurants(@Param("id") Integer id);
	
	@Query("SELECT c from Commande c where c.livreur.id = :id and c.livree=1")
	public List<Commande> findLivreeByLivreur(@Param("id") Integer idLivreur); // par annotation @Query
	
	@Query("SELECT c from Commande c where c.client.id = :id and c.livree=0")
	public Optional<Commande> findCommandeByIdClient(@Param("id") Integer id);
	
	@Query("SELECT c from Commande c where c.livree=0 and c.livreur IS NULL")
	public List<Commande> findAllNonLivreesEtSansLivreur(); // par annotation @Query
	
	
	//fonction pour trouver les restaurant qui ont un même restaurateur
	@Query("select distinct f from Commande f where f.restaurant.id = :id")
	public List<Commande> findByIdWithRestaurant(@Param("id") Integer id);
}
