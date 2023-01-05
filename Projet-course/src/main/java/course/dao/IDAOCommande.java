package course.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import course.model.Commande;

public interface IDAOCommande extends JpaRepository <Commande,Integer> {

}
