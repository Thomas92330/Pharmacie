import java.util.ArrayList;

public class Client {
	
	//Attributs
	String nom,prenom,adresse,telephone,secu;
	ArrayList<String> achats = new ArrayList<String>();
	
	//Constructeur
	public Client (String nom,String prenom,String telephone,String secu,String adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.adresse = adresse;
		this.secu = secu;
	}
	
}
