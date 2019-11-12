import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Fenetre_menu extends JFrame implements ActionListener{
	
	//Création de chacun de nos boutons
	Button bouton1 = new Button("Ajouter Client");
	Button bouton2 = new Button("Ajouter Medicament");
	Button bouton3 = new Button("Approvisionner");
	Button bouton4 = new Button("Acheter");
	Button bouton5 = new Button("Modifier client");
	Button bouton6 = new Button("Afficher Client");
	JLabel client = new JLabel("Client");
	JLabel medoc = new JLabel("Medicament");
	
	
	public Fenetre_menu() {
		this.setTitle("Menu"); //Mettre un titre à notre fenêtre
		this.setSize(Tableau.largeur(),Tableau.hauteur()); //Régler les dimensions de notre fenetre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Sert à avoir le bandeau en haut de la fenetre avec la "croix rouge" 
		this.setLocationRelativeTo(null); //Faire apparaitre la fenetre au centre de l'écran
		
		//Tracer un "plateau" sur lequel nous pourrons placer nos éléments
		this.setLayout(new GridLayout(0,2,5,5)); // "le nombre de ligne ce fait fait automatiquement  "       "2 = nombre de colonne"       "5/5 = écart Horizontal/Vertical"
			
		/*------------------------------Paramétrage des JLables------------------------------*/
		 
		client.setFont(new Font("Arial",Font.BOLD,30));
		medoc.setFont(new Font("Arial",Font.BOLD,30));
		
		client.setPreferredSize(Tableau.dimension());
		medoc.setPreferredSize(Tableau.dimension());
		 
		 /*------------------------------Fin du paramétrage------------------------------*/
		
		
		
		/*------------------------------Paramétrage des boutons--------------------------*/
		
		//Paramétrage de la police d'écriture de chaque bouton
		Font font = Tableau.font(); //la méthode "font()" est présenete dans la classe Tableau
		bouton1.setFont(font);
		bouton2.setFont(font);
		bouton3.setFont(font);
		bouton4.setFont(font);
		bouton5.setFont(font);
		bouton6.setFont(font);
		
		
		//Permet d'interagir avec le bouton
		bouton1.addActionListener(this);
		bouton2.addActionListener(this);
		bouton3.addActionListener(this);
		bouton4.addActionListener(this);
		bouton5.addActionListener(this);
		bouton6.addActionListener(this);
		
		//Ajouter nos boutons a notre "fenetre_menu" il faut faire attention a l'ordre dans lequelle on les mets, et on rajoute des "blancs" pour faire des trous
		
		this.getContentPane().add(new JLabel("CLIENT",SwingConstants.CENTER));
		this.getContentPane().add(new JLabel("MEDICAMENT",SwingConstants.CENTER));
		
		this.getContentPane().add(bouton1);
		this.getContentPane().add(bouton2);
		
		this.getContentPane().add(bouton4);
		this.getContentPane().add(bouton3);
		
		this.getContentPane().add(bouton5);
		this.getContentPane().add(new JLabel());
		this.getContentPane().add(bouton6);
		
		
		/*-----------------------------Fin du paramétrage----------------------------------*/
		
		//Afficher notre travail ;)
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0) {
	    //Si on clique sur le bouton 1, cela sera detecter par "ActionListener", et actionnera cette "ActionPerformed"
		
		if(arg0.getSource() == bouton1)
	    	client_ajouter();
	    else if(arg0.getSource() == bouton2)
	    	medicament_ajouter();
	    else if(arg0.getSource() == bouton3)
	    	approvisionner();
	    else if(arg0.getSource() == bouton4)
	    	acheter();
	    else if(arg0.getSource() == bouton5)
	    	modifier_client();
	    else if(arg0.getSource() == bouton6)
	    	afficher_client();
	}
	/*-----------------------------Fonction pour ajouter un client ----------------------------------*/
	public static void client_ajouter() {
		Client client = new Client(null,null,null,null,null); //On créé un "client" 
		JTextField nom = new JTextField(); //On créé un JTextField, c'est le carré blanc dans lequelle l'utilisateur peut écrire
		JTextField prenom = new JTextField();
		JTextField telephone = new JTextField();
		JTextField adresse = new JTextField();
		JTextField secu = new JTextField();
		
		//On créé un objet dans lequelle on va stocker les JTextField que nous avons créé en mettant une chaine de caractere(Ex: Nom) afin de faire une sorte de titre
		Object[] message = {
		    "Nom", nom,
		    "Prenom", prenom,
		    "Téléphone" , telephone,
		    "Adresse" , adresse,
		    "Numéro de sécurité social", secu
		};
		
		//Cette fonction fait apparaitre une fenetre contenant tout ce qui est dans notre objet créé plus haut
		//Le ".OK_CANCEL_OPTION" permet de faire apparaitre les boutons ok et annulé automatiquement
		int option = JOptionPane.showConfirmDialog(null, message, "Entrez les informations", JOptionPane.OK_CANCEL_OPTION);
		
		//Si l'utilisateur appuis sur "ok", le programme va enregistrer tout ce qui a été tappé, et le stock dans notre client créé au début de cette fonction 
		if (option == JOptionPane.OK_OPTION)
		{
		    client.nom = nom.getText(); //Afin d'accéder au texte contenue dans notre JTextField, il faut passer par la méthode " .getText()"
		    client.prenom = prenom.getText();
		    client.telephone = telephone.getText();
		    client.adresse = adresse.getText();
		    client.secu = secu.getText();
		    	
		    Tableau.listClient.add(client); //Une fois que toute les informations sont enregistré dans notre client, on l'ajoute a notre tableau afin de le stocker
		}
	}

	public static void medicament_ajouter() {
		
		Medicament medicament = new Medicament(null,null,null,0,0);
		JTextField reference = new JTextField();
		JTextField libelle = new JTextField();
		JTextField description = new JTextField();
		
		JFormattedTextField quantite = new JFormattedTextField();
		JFormattedTextField prix = new JFormattedTextField();
		
		
		Object[] message = {
		    "Reference",reference,
		    "Libellé",libelle,
		    "Description",description,
		    "Quantite",quantite,
		    "Prix",prix
		};
		
		int option = JOptionPane.showConfirmDialog(null, message, "Entrez les informations", JOptionPane.OK_CANCEL_OPTION);
		
		if (option == JOptionPane.OK_OPTION)
		{
		    medicament.reference = reference.getText();
		    medicament.libelle = libelle.getText();
		    medicament.description = description.getText();
		    medicament.quantite = string_to_int(quantite.getText());
		    medicament.prix = string_to_int(prix.getText());
		    Tableau.listMedicament.add(medicament);
		}
	}

	public static void approvisionner() {
		Medicament medoc = trouver_medicament();
		
		if(medoc!=null) {
		JFormattedTextField quantite = new JFormattedTextField();
		
		Object[] message = {
				"Quelle quantité voulez vous ajouter ?", quantite
		};
		
		int option = JOptionPane.showConfirmDialog(null, message, "Entrez les informations", JOptionPane.OK_CANCEL_OPTION);
		
		if (option == JOptionPane.OK_OPTION)
		{
			medoc.quantite += string_to_int(quantite.getText());
		}
		}
	}
	
	public static void acheter() {
		Client client = trouver_client();
		if(client.secu != null) {
		
			Medicament medoc = trouver_medicament();
		
		if (medoc.libelle != null) {
		JTextField quantite = new JTextField();
		
		Object[] message = {
		    "Quantite", quantite
		};
		
		int option = JOptionPane.showConfirmDialog(null, message, "Entrez les informations", JOptionPane.OK_CANCEL_OPTION);
		
		if (option == JOptionPane.OK_OPTION)
		{
		    if (medoc.quantite - string_to_int(quantite.getText()) >= 0) {  // Cette ligne permet de vérifier si l'achat est possible
		    		medoc.quantite -= string_to_int(quantite.getText());
		    		client.achats.add("libelle: " + medoc.libelle + "                 " + "Quantite: " + quantite.getText() +" \n");
		    }
		    else
		    	JOptionPane.showConfirmDialog(null, "Quantité non suffisante", "Error", JOptionPane.ERROR_MESSAGE);
		}
		}
		}
	}
	
	public static void modifier_client() {
		Client client = trouver_client();
		if(client.secu != null) {
		
		JTextField nom = new JTextField(new String(client.nom));
		JTextField prenom = new JTextField(new String (client.prenom));
		JTextField telephone = new JTextField(new String(client.telephone));
		JTextField adresse = new JTextField(new String(client.adresse));
		JTextField secu = new JTextField(new String(client.secu));
		
		Object[] message = {
		    "Nom", nom,
		    "Prenom", prenom,
		    "Téléphone" , telephone,
		    "Adresse" , adresse,
		    "Numéro de sécurité social", secu
		};
		
		int option = JOptionPane.showConfirmDialog(null, message, "Entrez les informations", JOptionPane.OK_CANCEL_OPTION);
		
		if (option == JOptionPane.OK_OPTION)
		{
		    if(nom.getText()!="")
		    	client.nom = nom.getText();
		    if(prenom.getText()!="")
		    	client.prenom = prenom.getText();
		    if(telephone.getText()!="")
		    	client.telephone = telephone.getText();
		    if(adresse.getText()!="")
		    	client.adresse = adresse.getText();
		    if(secu.getText()!="")
		    	client.secu = secu.getText();
		    
		    Tableau.listClient.add(client);
		}
		}
	}
	
	public static void afficher_client() {
		
		Client client = trouver_client();
		if(client.secu != null) {	
			String str="";
			int i;
			
			for(i =0;i<client.achats.size();i++)
				str += client.achats.get(i);
			
			Object[] message = {
					client.nom + "  " + client.prenom,
					" ",
					" ",
					"Addresse: " + client.adresse,
					" ",
					" ",
					" ",
					" ",
					"Numéro de sécurité social: " + client.secu,
					" ",
					" ",
					" ",
					" ",
					"Liste des achats:",
					" ",
					str
			};
			
			JOptionPane.showConfirmDialog(null, message, client.nom + "  " + client.prenom, JOptionPane.OK_CANCEL_OPTION);
		}
	}

	public static Client trouver_client() {
		JTextField secu = new JTextField();
		
		Object[] message = {
		    "Numéro de sécurité sociale", secu
		};
		
		int i;
		int option = JOptionPane.showConfirmDialog(null, message, "Entrez la informations", JOptionPane.OK_CANCEL_OPTION);
		
		if (option == JOptionPane.OK_OPTION)
		{
		    for(i=0;i<Tableau.listClient.size();i++) {
		    	if (Tableau.listClient.get(i).secu.equals(secu.getText()))
		    		return Tableau.listClient.get(i);
		    }
		}
		JOptionPane.showConfirmDialog(null, "Client non trouvé", "Error", JOptionPane.ERROR_MESSAGE);
		return (null);
	}

	public static Medicament trouver_medicament() {
		JTextField libelle = new JTextField();
		
		Object[] message = {
		    "Libellé", libelle
		};
		
		int i;

		int option = JOptionPane.showConfirmDialog(null, message, "Entrez les informations", JOptionPane.OK_CANCEL_OPTION);
		
		if (option == JOptionPane.OK_OPTION)
		{
		    for(i=0;i<Tableau.listClient.size();i++) {
		    	if (Tableau.listMedicament.get(i).libelle.equals(libelle.getText()))
		    		return Tableau.listMedicament.get(i);
		    }
		}
		JOptionPane.showConfirmDialog(null, "Medicament non trouvé", "Error", JOptionPane.ERROR_MESSAGE);
		return (null);
	}

	public static int string_to_int(String str) {
		int i=0,num=0;
		while( i < str.length()) {
			num *= 10;
	        num += str.charAt(i++) - '0'; 
	    }
		return num;
		
	}
	
}
