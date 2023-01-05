package course.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import course.model.Compte;

public interface IDAOCompte extends JpaRepository <Compte,Integer>{
	
}
