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
//	
	@Autowired
	private IDAOPlat daoPlat;
	
	@Autowired
	private IDAORestaurant daoRestaurant;

	@Test
	void contextLoads() {
		
		//Image Restaurant
		String imagePrime ="https://cdn.sortiraparis.com/images/1001/91874/582754-photos-le-cafe-de-l-homme.jpg" ;
		String imageSamir = "https://ad962edbae8ba7b03b7f-d10007df79b5b7a4e475a291e50a08cf.ssl.cf3.rackcdn.com/2235/etude-de-marche-d-une-chocolaterie.jpg";
		String imagePhi = "https://lechic-restaurant.fr/wp-content/uploads/2022/03/lechic-atmosphere.webp";
		
		//Image Plat
		String imageSaumon = "https://www.platetrecette.fr/wp-content/uploads/2020/08/Filets-de-saumon-au-four.jpg";
		String imageBoeuf = "https://www.la-viande.fr/sites/default/files/styles/slider_recettes/public/recettes/images/roti_de_boeuf_au_hachis_dherbes_et_de_girolles.jpg?itok=g6eWdK7T";
		
		//Creation adresse
		Adresse AE = new Adresse("24", "Renato", "76045", "Poitiers");
		Adresse AE3=new Adresse("85","rue de Moitu","33000","Bordeaux");
		Adresse AE4=new Adresse("75","avenue de la garonne","33000","Bordeaux");
		Adresse AP = new Adresse("12","rue Marjori", "75045", "Paris");
		Adresse AP1 = new Adresse("20","rue Mouloutier", "75035", "Paris");
		Adresse APR = new Adresse("3","rue Semoule", "94500", "Champigny-sur-Marne");
		Adresse LaVoileBlancheAdresse= new Adresse("26","All des foulques","31200","Toulouse");
		Adresse AE5=new Adresse("45","avenue de grande bretagne","31000","Toulouse");
		Adresse AE2=new Adresse("76","rue de bourrassol","31300","Toulouse");
		Adresse EquilibreAdresse=new Adresse("10","place de la libération","31130","Toulouse");
		Adresse CroqueMichelAdresse=new Adresse("41","rue des filatiers","31000","Toulouse");
		Adresse LaCuisineAmemeAdresse=new Adresse("17","rue des couteliers","31000","Toulouse");
		Adresse AntipodeAdress=new Adresse("9","rue du pont Saint-Pierre","31300","Toulouse");
		Adresse OhLaVacheAdress=new Adresse("2","rue d'Austerlitz","31000","Toulouse");

		Adresse MichelSarran = new Adresse("10","rue de l'etoile","31000","Toulouse");
		Adresse JB = new Adresse("225","boulevard du capitol","31000","Toulouse");
		Adresse Martine =new Adresse("28","rue de l'église","31000","Toulouse");
		Adresse CyprienAdresse = new Adresse("687","avenue d'italie","31000","Toulouse");
		Adresse margueriteAdresse=new Adresse("41","rue de la poste","31200","Toulouse");
		//Creation compte
		Client CE = new Client("Benoit","Argaut", "ben", "ar_benoit@gmail.com", "123",AE2);
		Livreur LE =new Livreur("Jean","bouli","Jean","jeanbouli@gmail.com","azerty",AE);
		Restaurateur RE=new Restaurateur("Phi","Philippe","Etchebest","phiphi@gmail.com","recette",AE3);
		Livreur LE2 =new Livreur("Alexandre","Benalla","Alex","alex@gmail.com","crevette",AE4);
		Restaurateur Guy = new Restaurateur("Guy","Guy","Mabyalaht","guymm@gmail.com","alis",APR);
		Restaurateur SarrantMichel = new Restaurateur("Michel","Sarran","Michel","michel.sarrant@gmail.com","123",MichelSarran);
		Restaurateur jb = new Restaurateur("Jean-Baptiste","Vasseur","jb123","jb@gmail.com","123",JB);
		Restaurateur martine=new Restaurateur("Martine","Porte","martine","martine@gmail.com","123",Martine);
		Restaurateur Cyprien=new Restaurateur("Cyprien","Saint","cyp","cyprien@gmail.com","123",CyprienAdresse);
		Restaurateur Vache = new Restaurateur("Marguerite","Vache","meuhmeuh","marguerite@gmail.com","123",margueriteAdresse);



		
		//Creation d'un restaurant
		Restaurant chezPhiphi =new Restaurant("Chez phiphi",true,4.5,"Le restau à Phiphi",AE4, RE, imagePhi);
		Restaurant SamirChoco =new Restaurant("Samir Choco",true,4.5,"Le restau à Samir",AE5, RE, imageSamir);
		Restaurant GuyResto1 =new Restaurant("Le Prime",true,4.7,"Restaurant 3 étoiles, grande gastronimie française. Service de grande qualité, avec des menus adaptés.",AP, Guy, imagePrime);		
		Restaurant LaVoileBlanche= new Restaurant("La voile Blanche",true,4.8,"La Voile Blanche est ouverte toute l’année et en saison estivale. Venez découvrir un endroit unique et dépaysant aux portes de Toulouse",LaVoileBlancheAdresse,SarrantMichel,null);
		Restaurant CroqueMichel = new Restaurant("Croq'Michel",true,4.6,"Garder l’authenticité de ces délicieux sandwiches, mais en y rajoutant sa patte, avec une gamme aux saveurs empreintes d’ici et d’ailleurs",CroqueMichelAdresse,SarrantMichel,null);
		Restaurant LaCuisineAmeme=new Restaurant("La cuisine a mémé",true,4.4,"Une cuisine à l’ancienne, ancrée dans le terroir, une ambiance chaleureuse et intimiste qui séduit tout de suite",LaCuisineAmemeAdresse,martine,null);
		Restaurant Antipode = new Restaurant("Antipode",true,4.6,"retrouvez chaque semaine un nouveau menu frais et de saison",AntipodeAdress,Cyprien,null);
		Restaurant OhLaVache=new Restaurant("Oh La Vache",false,3.8,"Au menu, des plats traditionnels faits maison préparés avec soin et en toute simplicité à partir de produits sélectionnés tous les jours",margueriteAdresse,Vache,null);		
		Restaurant Equilibre= new Restaurant("Equilibre",false,4.2,"Une cuisine du marché, avec des produits locaux, travaillés par JB qui a eu pour exemple les plus grands chefs étoilés",EquilibreAdresse,jb,null);
		
		//Creations plats
		Plat entrecote=new Plat("entrecote",25,"entrecote/frite avec sauche poivre/roquefort/echalottes", chezPhiphi, null);
		Plat magret=new Plat("magret",20,"magret avec des patates sautées", chezPhiphi, null);		
		Plat saumon=new Plat("saumon",15,"Filet de saumon accompagné de riz", chezPhiphi, null);
		//LA VOILE BLANCHE
		
		Plat Tapas = new Plat("Tapas mixte",20,"Mixte de tapas (tartine jambon/croquettes jambons/..)",LaVoileBlanche,null);
		Plat pizza = new Plat("Pizza Signature",20,"Pizza foie gras/magret/magret séché/gésiers/persillades",LaVoileBlanche,null);
		Plat cabillaud = new Plat("Cabillaud",20,"Poisson du jour cabillaud",LaVoileBlanche,null);
		Plat tartare = new Plat("Tartare",20,"Tartare de boeuf",LaVoileBlanche,null);

		//PLAT CROQ MICHEL
		
		Plat croqSaumon = new Plat("croq'Saumon",10,"croque monsieur au saumon",CroqueMichel,null);
		Plat croqChevre = new Plat ("croq'Fromage",10,"croque monsieur au chèvre frais",CroqueMichel,null);
		Plat croqPoulet = new Plat ("croq'Poulet",10,"croque monsieur au poulet tandori",CroqueMichel,null);
		Plat croqJambon = new Plat ("croq'Jambon",10,"croque monsieur au jambon/fromage",CroqueMichel,null);
		Plat croqBleu = new Plat ("croq'Bleu",10,"croque monsieur au bleu",CroqueMichel,null);

		//PLAT La cuisine a meme
		Plat Choucroute = new Plat("Choucroute",15,"choucroute garni",LaCuisineAmeme,null);
		Plat PotAuFeu =new Plat("Pot Au Feu",10,"pot au feu, avec legumes et viande de boeuf",LaCuisineAmeme,null);
		Plat Bourguignon =new Plat("Bourguignon",20,"Bourguignon de luxe",LaCuisineAmeme,null);

		//ANTIPODE
		Plat entrecoteAntipode=new Plat("entrecote",25,"entrecote/frite avec sauche poivre/roquefort/echalottes", Antipode, null);
		Plat magretAntipode=new Plat("magret",20,"magret avec des patates sautées", Antipode, null);		
		Plat saumonAntipode=new Plat("saumon",15,"Filet de saumon accompagné de riz", Antipode, null);
		
		//OH LA VACHE
		Plat CoteAOs = new Plat("Cote a l'os",35,"Cote a l'os, vache limousine",OhLaVache,null);
		Plat BasseCote = new Plat("Basse cote",30,"Basse cote, vache charolaise",OhLaVache,null);
		Plat teteVeau = new Plat("Tete de veau",40,"Tete de veau a l'ancienne",OhLaVache,null);
		
		//EQUILIBRE
		
		Plat fondu = new Plat("Fondu Savoyarde",12,"Fondu pleine de fromage",Equilibre,null);
		Plat chevreuil = new Plat("Fondu chevreuil",12,"Fondu chevreuil avec un assortiment de sauces",Equilibre,null);
		Plat  poulet = new Plat("Poulet au four",20,"Poulet au four farci de gésier/olives",Equilibre,null);
		Plat soupe=new Plat("Soupe de légumes",10,"soupe de légumes de saison",Equilibre,null);
		
//		Plat saumon1=new Plat("Saumon",115,"Saumon mi-cuit aux épices et sauce teriyaki, salade roquette à l'huile fumée, espuma raifort", GuyResto1, "https://www.cuisineactuelle.fr/imgre/fit/http.3A.2F.2Fprd2-bone-image.2Es3-website-eu-west-1.2Eamazonaws.2Ecom.2Fcac.2F2018.2F09.2F25.2F481f16b8-83b2-4529-8f3a-2d4255c020eb.2Ejpeg/555x276/quality/80/crop-from/center/pave-de-saumon-mi-cuit-en-croute-de-sesame.jpeg");
//		Plat rouget =new Plat("Rouget",155,"Filet de Rouget juste saisi sur une purée d'artichaut à l'huile d'argan, huile de homard et jus à la vanille", GuyResto1, "https://files.meilleurduchef.com/mdc/photo/recette/filet-rouget-poivrons/filet-rouget-poivrons-640.jpg");
//		Plat bar=new Plat("Poisson Bar",95,"Filet de bar de ligne grillé, coulis de cresson, pomme de terre et émulsion de haddock fumé", GuyResto1, "https://img-3.journaldesfemmes.fr/R4i36RSvKutvdpA04-ZGjnCHK9s=/750x500/smart/2d1a29e18eec40ccb65708eb6a6a0c2f/recipe-jdf/10042991.jpg");
//		Plat Boeuf=new Plat("Boeuf",194,"Filet de bœuf poêlé au beurre cru, purée de pomme de terre à la truffe, crème aux morilles", GuyResto1, null);
//		
		Plat Boeuf=new Plat("Boeuf",194,"Filet de bœuf poêlé au beurre cru, purée de pomme de terre à la truffe, crème aux morilles", GuyResto1, imageBoeuf);
		Plat saumon1=new Plat("Saumon",115,"Saumon mi-cuit aux épices et sauce teriyaki, salade roquette à l'huile fumée, espuma raifort", GuyResto1, imageSaumon); //"https://www.cuisineactuelle.fr/imgre/fit/http.3A.2F.2Fprd2-bone-image.2Es3-website-eu-west-1.2Eamazonaws.2Ecom.2Fcac.2F2018.2F09.2F25.2F481f16b8-83b2-4529-8f3a-2d4255c020eb.2Ejpeg/555x276/quality/80/crop-from/center/pave-de-saumon-mi-cuit-en-croute-de-sesame.jpeg");
		Plat rouget =new Plat("Rouget",155,"Filet de Rouget juste saisi sur une purée d'artichaut à l'huile d'argan, huile de homard et jus à la vanille", GuyResto1,null);// "https://files.meilleurduchef.com/mdc/photo/recette/filet-rouget-poivrons/filet-rouget-poivrons-640.jpg");
		Plat bar=new Plat("Poisson Bar",95,"Filet de bar de ligne grillé, coulis de cresson, pomme de terre et émulsion de haddock fumé", GuyResto1,null); // "https://img-3.journaldesfemmes.fr/R4i36RSvKutvdpA04-ZGjnCHK9s=/750x500/smart/2d1a29e18eec40ccb65708eb6a6a0c2f/recipe-jdf/10042991.jpg");
		
		
		
//		List<Plat> platsphiphi=new ArrayList();
//		platsphiphi.add(entrecote);
//		platsphiphi.add(magret);
//		platsphiphi.add(saumon);
		
		
		
		Panier p1 = new Panier (entrecote, 2);
		Panier p2 = new Panier (saumon,2);
		
		List<Panier> pan1=new ArrayList();
		pan1.add(p1);
		
		//Creation commande
		Commande c1=new Commande(true, 1412,LocalDateTime.now(),true,pan1,CE,LE,null,null, chezPhiphi);
		Commande c2=new Commande(true, 1678,LocalDateTime.now(),true,pan1,CE,LE,null,null, SamirChoco);
		
		
		
		
		List<Commande> commo=new ArrayList();
		commo.add(c1);
		commo.add(c2);

		
		
		//Creation evaluation
		Evaluation e1=new Evaluation(4.5,"bon repas");
		Evaluation e2=new Evaluation(4.8,"Livraison rapide !");

		try {
		CE = daoCompte.save(CE);
		LE = daoCompte.save(LE);
		RE = daoCompte.save(RE);
		LE2 = daoCompte.save(LE2);
		Guy = daoCompte.save(Guy);
		SarrantMichel=daoCompte.save(SarrantMichel);
		jb=daoCompte.save(jb);
		martine=daoCompte.save(martine);
		Cyprien = daoCompte.save(Cyprien);
		Vache =daoCompte.save(Vache);
		
		
		
		chezPhiphi=daoRestaurant.save(chezPhiphi);
		SamirChoco=daoRestaurant.save(SamirChoco);
		GuyResto1=daoRestaurant.save(GuyResto1);
		LaVoileBlanche = daoRestaurant.save(LaVoileBlanche);
		CroqueMichel = daoRestaurant.save(CroqueMichel);
		LaCuisineAmeme = daoRestaurant.save(LaCuisineAmeme);
		Antipode = daoRestaurant.save(Antipode);
		OhLaVache = daoRestaurant.save(OhLaVache);
		Equilibre = daoRestaurant.save(Equilibre);
		
		
		entrecote=daoPlat.save(entrecote);
		magret=daoPlat.save(magret);
		saumon=daoPlat.save(saumon);
		Boeuf=daoPlat.save(Boeuf);
		saumon1=daoPlat.save(saumon1);
		rouget=daoPlat.save(rouget);
		bar=daoPlat.save(bar);
		Tapas = daoPlat.save(Tapas);
		pizza=daoPlat.save(pizza);
		cabillaud=daoPlat.save(cabillaud);
		tartare=daoPlat.save(tartare);
		croqSaumon=daoPlat.save(croqSaumon);
		croqChevre=daoPlat.save(croqChevre);
		croqJambon=daoPlat.save(croqJambon);
		croqBleu=daoPlat.save(croqBleu);
		Choucroute=daoPlat.save(Choucroute);
		PotAuFeu=daoPlat.save(PotAuFeu);
		Bourguignon=daoPlat.save(Bourguignon);
		entrecoteAntipode=daoPlat.save(entrecoteAntipode);
		magretAntipode=daoPlat.save(magretAntipode);
		saumonAntipode=daoPlat.save(saumonAntipode);
		CoteAOs=daoPlat.save(CoteAOs);
		BasseCote=daoPlat.save(BasseCote);
		teteVeau=daoPlat.save(teteVeau);
		fondu=daoPlat.save(fondu);
		chevreuil=daoPlat.save(chevreuil);
		poulet=daoPlat.save(poulet);
		soupe=daoPlat.save(soupe);
		
		
		c1=daoCommande.save(c1);
		c2=daoCommande.save(c2);
		
		e1 = daoEvaluation.save(e1);
		e2 = daoEvaluation.save(e2);

		
		
		} catch (DataAccessException dae) {
			
		}
	}

}
