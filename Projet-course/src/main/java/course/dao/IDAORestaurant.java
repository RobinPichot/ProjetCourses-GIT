package course.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import course.model.Restaurant;

public interface IDAORestaurant extends JpaRepository<Restaurant,Integer> {

}
