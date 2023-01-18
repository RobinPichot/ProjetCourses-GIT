//package course.web;
//
//import java.lang.reflect.Field;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.util.ReflectionUtils;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.server.ResponseStatusException;
//
//import com.fasterxml.jackson.annotation.JsonView;
//
//import course.dao.IDAOEvaluation;
//import course.dao.IDAOEvaluation;
//import course.model.Evaluation;
//import course.model.Views;
//
//
//@RestController
//@RequestMapping("/evaluations")
//@CrossOrigin("*")
//public class EvaluationResource {
//	
//	@Autowired
//	private IDAOEvaluation daoEvaluation;
//	
//	@GetMapping("")
//	@JsonView(Views.ViewBase.class)
//	public List<Evaluation> findAll() {
//		List<Evaluation> evaluations = daoEvaluation.findAll();
//
//		return evaluations;
//	}
//	
//	@GetMapping("/{id}")
//	@JsonView(Views.ViewBase.class)
//	public Evaluation findById(@PathVariable Integer id) {
//		Optional<Evaluation> optEvaluation = daoEvaluation.findById(id);
//
//		if (optEvaluation.isEmpty()) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//		}
//
//		return optEvaluation.get();
//	}
//
////	@GetMapping("/{id}/dto")
////	public EvaluationDTO findDTOById(@PathVariable Integer id) {
////		final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
////
////		Optional<Evaluation> optEvaluation = daoEvaluation.findById(id);
////
////		if (optEvaluation.isEmpty()) {
////			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
////		}
////
////		Evaluation evaluation = optEvaluation.get();
////
////		EvaluationDTO evaluationDTO = new EvaluationDTO();
////
////		evaluationDTO.setIdentifiant(evaluation.getId());
////		evaluationDTO.setNom(evaluation.getNom());
////		evaluationDTO.setPrenom(evaluation.getPrenom());
////		evaluationDTO.setEmail(evaluation.getEmail());
////		evaluationDTO.setIdFiliere(evaluation.getFiliere().getId());
////		evaluationDTO.setNomFiliere(evaluation.getFiliere().getLibelle());
////		evaluationDTO.setDebutFiliere(evaluation.getFiliere().getDebut());
////		evaluationDTO.setFinFiliere(evaluation.getFiliere().getFin());
////		evaluationDTO.setDebutFiliereString(dtf.format(evaluation.getFiliere().getDebut()));
////		evaluationDTO.setFinFiliereString(dtf.format(evaluation.getFiliere().getFin()));
////
////		return evaluationDTO;
////	}
//
//	@PostMapping("")
//	@JsonView(Views.ViewBase.class)
//	public Evaluation create(@Valid @RequestBody Evaluation evaluation, BindingResult result) {
//		if (result.hasErrors()) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "L'évaluation n'a pu être créée");
//		}
//
//		evaluation = daoEvaluation.save(evaluation);
//
//		return evaluation;
//	}
//
//	@PutMapping("/{id}")
//	@JsonView(Views.ViewBase.class)
//	public Evaluation update(@PathVariable Integer id, @RequestBody Evaluation evaluation) {
//		if (id != evaluation.getId() || !daoEvaluation.existsById(id)) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//		}
//
//		evaluation = daoEvaluation.save(evaluation);
//
//		return evaluation;
//	}
//
////	@PatchMapping("/{id}")
////	@JsonView(Views.ViewEvaluation.class)
////	public Evaluation partialUpdate(@PathVariable Integer id, @RequestBody Map<String, Object> fields) {
////		Optional<Evaluation> optEvaluation = daoEvaluation.findById(id);
////
////		if (optEvaluation.isEmpty()) {
////			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
////		}
////
////		final Evaluation evaluation = optEvaluation.get();
//
////		if(fields.containsKey("nom")) {
////			evaluation.setNom((String) fields.get("nom"));
////		}
////		
////		if(fields.containsKey("prenom")) {
////			evaluation.setPrenom((String) fields.get("prenom"));
////		}
////
////		if(fields.containsKey("email")) {
////			evaluation.setEmail((String) fields.get("email"));
////		}
////
////		fields.forEach((key, value) -> {
////			Field field = ReflectionUtils.findField(Evaluation.class, key);
////			if (field == null) {
////				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Propriété : " + key + "non trouvée");
////			}
////			ReflectionUtils.makeAccessible(field);
////			ReflectionUtils.setField(field, evaluation, value);
////		});
////
////		return daoEvaluation.save(evaluation);
////	}
//
//	@DeleteMapping("/{id}")
//	public void delete(@PathVariable Integer id) {
//		if (!daoEvaluation.existsById(id)) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//		}
//
//		daoEvaluation.deleteById(id);
//	}
//	
//	
//
//}
