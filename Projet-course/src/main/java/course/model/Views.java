package course.model;

public class Views {
	
	public static class ViewBase {}	
	
	public static class ViewRestaurant extends ViewBase{}	

	public static class ViewCommandeWithRestaurants extends ViewCommande {}
	public static class ViewCompteDetail extends ViewCompte{}
	public static class ViewCommande extends ViewBase {}
	public static class ViewCompte extends ViewBase{}
	public static class ViewPanier extends ViewBase{}
	public static class ViewPanierDetail extends ViewPanier{}
	public static class ViewRestaurateurWithRestaurants extends ViewRestaurant {}
	public static class ViewPlatWithRestaurant extends ViewPlat {}
	public static class ViewPlat extends ViewBase{}
}
