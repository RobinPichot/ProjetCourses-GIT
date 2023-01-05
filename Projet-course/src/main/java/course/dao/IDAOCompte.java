package course.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import course.model.Compte;
import course.model.Restaurant;

public interface IDAOCompte extends JpaRepository <Compte,Integer>{

}
