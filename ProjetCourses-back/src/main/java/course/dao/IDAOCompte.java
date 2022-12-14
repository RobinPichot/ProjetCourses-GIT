package course.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Compte;
import model.Restaurant;

public interface IDAOCompte extends JpaRepository <Compte,Integer>{

}
