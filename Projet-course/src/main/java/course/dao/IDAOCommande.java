package course.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import course.model.Commande;

public interface IDAOCommande extends JpaRepository <Commande,Integer> {

	@Query("select distinct c from Commande c left join fetch c.restaurants where c.id = :id")
	public Optional<Commande> findByIdWithRestaurants(@Param("id") Integer id);
}
