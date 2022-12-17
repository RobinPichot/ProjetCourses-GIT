package test;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import course.dao.IDAOCompte;
import model.Adresse;
import model.Client;
import model.Commande;


public class App {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		
		IDAOCompte daoCompte = context.getBean(IDAOCompte.class);
		
		Adresse AE = new Adresse("24", "Renato", "76045", "Poitier");
		Client CE = new Client("Argaut", "Benoit", "ar_benoit@gmail.com", "ashoon45", AE);
		
		try {
		CE = daoCompte.save(CE);
		} catch (DataAccessException dae) {
			
		}
		
		
		context.close();
	}

}
