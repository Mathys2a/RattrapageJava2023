package application;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
/**
 * 
 * @author m.puech
 *
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			//J'utilise Platform.runLater(() car sinon ma fenetre n'affiche rien et la console n'est pas chargé
			Platform.runLater(() -> dlFihier_AfficherCategories());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static void dlFihier_AfficherCategories() {
		Categorie.chargerFichierTexte("categorie.txt");

		System.out.println("Liste des catégories :");
		for (Categorie categorie : Categorie.categories) {
			System.out.println(categorie.getS_libelle());
		}

		System.out.println("Taille de la liste : " + Categorie.categories.size());
	}
}
