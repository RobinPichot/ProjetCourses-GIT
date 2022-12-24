package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import course.dao.IDAOCommande;
import course.dao.IDAOCompte;
import course.dao.IDAOEvaluation;
import course.dao.IDAOPlat;
import course.dao.IDAORestaurant;
import model.Adresse;
import model.Client;
import model.Commande;
import model.Evaluation;
import model.Livreur;
import model.MoyPayement;
import model.Plat;
import model.Restaurant;
import model.Restaurateur;


public class App {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		
		IDAOCompte daoCompte = context.getBean(IDAOCompte.class);
		IDAOCommande daoCommande =context.getBean(IDAOCommande.class);
		IDAOEvaluation daoEvaluation=context.getBean(IDAOEvaluation.class);
		IDAOPlat daoPlat=context.getBean(IDAOPlat.class);
		IDAORestaurant daoRestaurant = context.getBean(IDAORestaurant.class);
		
		
		//Creation adresse
		Adresse AE = new Adresse("24", "Renato", "76045", "Poitier");
		Adresse AE2=new Adresse("76","rue de bourrassol","31300","Toulouse");
		Adresse AE3=new Adresse("85","rue de Moitu","33000","Bordeau");
		
		//Creation compte
		Client CE = new Client("Argaut", "Benoit", "ar_benoit@gmail.com", "ashoon45", AE);
		Livreur LE =new Livreur("Jean","bouli","jeanbouli@gmail.com","azerty",AE2);
		Restaurateur RE=new Restaurateur("Philippe","Etchebest","phiphi@gmail.com","recette",AE3);
		
		//Creations plats
		Plat entrecote=new Plat("entrecote",25,"entrecote/frite avec sauche poivre/roquefort/echalottes",true);
		Plat magret=new Plat("magret",20,"magret avec des patates sautées",true);		
		Plat saumon=new Plat("saumon",15,"Filet de saumon accompagné de riz",true);		

		//Creation d'un restaurant
		List<Plat> platsphiphi=new ArrayList();
		platsphiphi.add(entrecote);
		platsphiphi.add(magret);
		platsphiphi.add(saumon);
		
		
		Restaurant chezPhiphi=new Restaurant("Chez phiphi",true,4.5,platsphiphi);
		
		//Creation commande
		Commande c1=new Commande(1551,LocalDate.now(),true,CE,LE,null,null,MoyPayement.valueOf("CB"),false);
		
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
		
		
		context.close();
	}

}
