package course;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;

import course.dao.IDAOCommande;
import course.dao.IDAOCompte;
import course.dao.IDAOEvaluation;
import course.dao.IDAOPlat;
import course.dao.IDAORestaurant;
import course.model.Adresse;
import course.model.Client;
import course.model.Commande;
import course.model.Evaluation;
import course.model.Livreur;
import course.model.MoyPayement;
import course.model.Panier;
import course.model.Plat;
import course.model.Restaurant;
import course.model.Restaurateur;

@SpringBootTest
class ProjetCourseApplicationTests {
	
	@Autowired
	private IDAOCommande daoCommande;
	
	@Autowired
	private IDAOCompte daoCompte;
	
	@Autowired
	private IDAOEvaluation daoEvaluation;
	
	@Autowired
	private IDAOPlat daoPlat;
	
	@Autowired
	private IDAORestaurant daoRestaurant;

	@Test
	void contextLoads() {
		
		//Creation adresse
		Adresse AE = new Adresse("24", "Renato", "76045", "Poitiers");
		Adresse AE2=new Adresse("76","rue de bourrassol","31300","Toulouse");
		Adresse AE3=new Adresse("85","rue de Moitu","33000","Bordeaux");
		
		//Creation compte
		Client CE = new Client("Benoit","Argaut", "Benoit", "ar_benoit@gmail.com", "ashoon45", AE);
		Livreur LE =new Livreur("Jean","bouli","Jean","jeanbouli@gmail.com","azerty",AE2);
		Restaurateur RE=new Restaurateur("Phi","Philippe","Etchebest","phiphi@gmail.com","recette",AE3);
		
		//Creations plats
		Plat entrecote=new Plat("entrecote",25,"entrecote/frite avec sauche poivre/roquefort/echalottes");
		Plat magret=new Plat("magret",20,"magret avec des patates sautées");		
		Plat saumon=new Plat("saumon",15,"Filet de saumon accompagné de riz");		

		//Creation d'un restaurant
		List<Plat> platsphiphi=new ArrayList();
		platsphiphi.add(entrecote);
		platsphiphi.add(magret);
		platsphiphi.add(saumon);
		
		Restaurant chezPhiphi=new Restaurant("Chez phiphi",true,4.5,"Le restau a phiphi",platsphiphi);
		
		Panier p1 = new Panier (saumon, 2);
		
		List<Panier> pan1=new ArrayList();
		pan1.add(p1);
		
		Commande c1=new Commande(true, 1551,LocalDateTime.now(),true,pan1,CE,LE,null,null,MoyPayement.valueOf("CB"), chezPhiphi);
		
		
		List<Commande> commo=new ArrayList();
		commo.add(c1);
		
		
		
		//Creation commande
		
		
		//Creation evaluation
		Evaluation e1=new Evaluation(4.5,"bon repas");
		Evaluation e2=new Evaluation(4.8,"Livraison rapide !");

		try {
		CE = daoCompte.save(CE);
		LE = daoCompte.save(LE);
		RE = daoCompte.save(RE);
		
		entrecote=daoPlat.save(entrecote);
		magret=daoPlat.save(magret);
		saumon=daoPlat.save(saumon);
		
		chezPhiphi=daoRestaurant.save(chezPhiphi);
		
		c1=daoCommande.save(c1);
		
		e1 = daoEvaluation.save(e1);
		e2 = daoEvaluation.save(e2);

		
		
		} catch (DataAccessException dae) {
			
		}
	}

}
