package test;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;

import course.dao.IDAOCompte;
import model.Adresse;
import model.Client;

@ContextConfiguration(locations = "classpath:/application-context.xml")
public class TestSpring {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		IDAOCompte daoCompte = context.getBean(IDAOCompte.class);

		Adresse adresse = new Adresse("1","rue","Rougemont","France");
		Client client = new Client("a","b","c","d",adresse);
		
//		IDAOFiliere daoFiliere = context.getBean(IDAOFiliere.class);
//		
//		Filiere filiere = new Filiere(null, LocalDate.of(2022, Month.OCTOBER, 25), LocalDate.of(2023, Month.JANUARY, 20));
		
		try {
		client = daoCompte.save(client);
		} catch (DataAccessException dae) {
			
		}
		
		
		context.close();
	}

}