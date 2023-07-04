package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public interface interfaceUser {

	public static void start(Stage primaryStage) {

		Label l_Nom = new Label("Nom ");
		TextField tF_Nom = new TextField();
		Label l_Annee = new Label("Année de naissance ");
		TextField tF_Annee = new TextField();
		Label l_Categorie = new Label("Catégorie ");
		TextField tF_Categorie = new TextField();
		
		Button b_Ajouter = new Button("Enregistrer");
		ListView<String> lV_Personnes = new ListView<>();
		
		GridPane grid = new GridPane();		
		grid.addRow(0, l_Nom, tF_Nom);
		grid.addRow(1, l_Annee, tF_Annee);
		grid.addRow(2, l_Categorie, tF_Categorie);
		grid.add(b_Ajouter, 0, 2, 2, 2);
		grid.add(lV_Personnes, 0, 2, 2, 1);
		
	}

}
