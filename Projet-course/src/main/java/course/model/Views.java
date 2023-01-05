package course.model;

public class Views {
	
	public static class ViewBase {}	

	public static class ViewCommandeWithRestaurants extends ViewCommande {}
	public static class ViewCompteDetail extends ViewCompte{}
	public static class ViewCommande extends ViewBase {}
	public static class ViewCompte extends ViewBase{}
}
