package course.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Commande;

public interface IDAOCommande extends JpaRepository <Commande,Integer> {

}
