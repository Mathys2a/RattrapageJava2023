package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * 
 * @author m.puech
 * @param int i_ageMini; int  i_ageMaxi; String s_libelle;
 */

public class Categorie {

	// Variables
	 private int i_ageMini;
	 private int  i_ageMaxi;
	 private String s_libelle;
	 
	//Constructeur de la classe
	public Categorie(int i_ageMini, int i_ageMaxi, String s_libelle) {
		this.i_ageMini = i_ageMini;
		this.i_ageMaxi = i_ageMaxi;
		this.s_libelle = s_libelle;
	}
	
	public String getS_libelle() {
		return s_libelle;
	}
	
	//Méthode pour savoir si l'âge correspond
	public boolean correspond (int i_age) {
		if(i_age >= this.i_ageMaxi && i_age <= this.i_ageMini) {return true;}else {return false;}
	}
	
	public static ArrayList<Categorie> categories = new ArrayList<>();
	
	//Methode permettant de trouver la categorie en fonction de l'âge
	public static String getCategorie(int anneeNaissance) {
        LocalDateTime ldt = LocalDateTime.now();
        int anneeCourante = ldt.getYear();
        int age = anneeCourante - anneeNaissance;
        
        for (Categorie categorie : categories) {
            if (categorie.correspond(age)) {
                return categorie.s_libelle;
            }
        }
        
        throw new IllegalArgumentException("Aucune catégorie correspondante trouvée pour l'âge spécifié.");
    }
	
	//Méthode pour charger le fichier categorie.txt
	public static void chargerFichierTexte(String nomFichier) {
        try (BufferedReader br = new BufferedReader(new FileReader("data/" + "categorie.txt"))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] elements = ligne.split(" ");
                if (elements.length == 3) {
                    int ageMini = Integer.parseInt(elements[0].trim());
                    int ageMaxi = Integer.parseInt(elements[1].trim());
                    String libelle = elements[2].trim();
                    categories.add(new Categorie(ageMini, ageMaxi, libelle));
                }
            }
        //Gestion exception en rapport avec le fichier
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
