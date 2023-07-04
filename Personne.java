package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 * 
 * @author m.puech
 * @para String s_nom, s_annee, s_categorie;
 */
public class Personne {

	
	private String s_nom, s_annee, s_categorie;

	public Personne(String s_nom, String s_annee, String s_categorie) {
		this.s_nom = s_nom;
		this.s_annee = s_annee;
		this.s_categorie = s_categorie;
	}

	@Override
	public String toString() {
		return "Personne [s_nom=" + s_nom + ", s_annee=" + s_annee + ", s_categorie=" + s_categorie + "]";
	}
	
	public static ObservableList<Personne> personne = FXCollections.observableArrayList();

	
}
