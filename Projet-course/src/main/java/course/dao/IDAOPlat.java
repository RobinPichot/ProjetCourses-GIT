package course.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import course.model.Plat;


public interface IDAOPlat extends JpaRepository<Plat,Integer> {

	//fonction pour trouver les restaurant qui ont un même restaurateur
	@Query("select distinct f from Plat f where f.restaurant.id = :id")
	public List<Plat> findByIdWithRestaurant(@Param("id") Integer id);
}
