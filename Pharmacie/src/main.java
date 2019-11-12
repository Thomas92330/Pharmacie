import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.UIManager;

public class main {
	public static void main(String[] args) {
		UIManager.put("OptionPane.minimumSize",Tableau.dimension());  //On impose une dimension pour les fenetres de type OptionPane
		UIManager.put("TextField.font", Tableau.font()); // On impose notre nouvelle police pour la zone de rentré de texte
		UIManager.put("OptionPane.messageFont",Tableau.font()); //On impose notre nouvelle police pour la zone de message
		UIManager.put("OptionPane.buttonFont", Tableau.font()); //On impose une dimension pour les boutons de nos fenetres de type OptionPane
		UIManager.put("FormattedTextField.font",Tableau.font()); // On impose une dimension pour nos zone de rentré de texte de nos fenetres Formatted text field
		UIManager.put("Label.font",Tableau.font()); // On impose une dimension pour nos zone de rentré de texte de nos fenetres Formatted text field
		UIManager.put("Label.background",Color.DARK_GRAY); // On impose une dimension pour nos zone de rentré de texte de nos fenetres Formatted text field
		UIManager.put("Label.foreground",Color.RED);
		
		Fenetre_menu fm = new Fenetre_menu(); //Créer une fenetre_menu afin de lancer noter programme
	}
	
}
