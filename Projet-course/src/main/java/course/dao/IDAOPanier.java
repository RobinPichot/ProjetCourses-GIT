package course.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import course.model.Panier;

public interface IDAOPanier extends JpaRepository <Panier,Integer> {

	@Query("SELECT p from Panier p where p.commande.id = :id")
	public List<Panier> findPanierByIdCommande(@Param("id") Integer id);
}
