package course.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Evaluation;
import model.Restaurant;

public interface IDAOEvaluation extends JpaRepository<Evaluation,Integer> {

}
