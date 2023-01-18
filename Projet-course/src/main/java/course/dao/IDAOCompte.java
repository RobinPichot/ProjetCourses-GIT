package course.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import course.model.Compte;


public interface IDAOCompte extends JpaRepository <Compte,Integer>{

	@Query("from Compte c where c.login = :login")
	public Optional<Compte> findByLogin(String login);
	
	@Query("from Compte c where c.login= :Login and c.mdp =:mdp")
	Optional<Compte> findByLoginAndPassword(String Login,String mdp);
	
	
}
