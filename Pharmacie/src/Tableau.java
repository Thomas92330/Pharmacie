import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

public class Tableau {
	
	//Nos Tableaux dynamiques ou l'ont stock nos clients et medocs
	public static ArrayList <Client> listClient = new ArrayList<Client>();
	public static ArrayList <Medicament> listMedicament = new ArrayList<Medicament>();
	
	
	//Définition de nos constantes relatives
	static Dimension dimension() {
		Dimension dimension_absolue = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		Dimension dimension = new Dimension((int)dimension_absolue.getWidth()/2,(int)dimension_absolue.getHeight()/2);
		return dimension;
	}
	
	static Dimension dimension_client() {
		Dimension dimension_absolue = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		Dimension dimension = new Dimension((int)dimension_absolue.getWidth()/6,(int)dimension_absolue.getHeight()/4);
		return dimension;
	}
	
	static int hauteur() {
		int hauteur = (int)dimension().getHeight();
		return hauteur;
	}
	
	static int largeur() {
		 int largeur = (int)dimension().getWidth();
		 return largeur;
	}
	
	
	static Font font() {
		Font font = new Font("Arial",Font.PLAIN,30);
		return font;
	}
}


