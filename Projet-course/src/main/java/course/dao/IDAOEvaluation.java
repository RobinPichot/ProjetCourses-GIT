package course.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import course.model.Evaluation;
import course.model.Restaurant;

public interface IDAOEvaluation extends JpaRepository<Evaluation,Integer> {

}
