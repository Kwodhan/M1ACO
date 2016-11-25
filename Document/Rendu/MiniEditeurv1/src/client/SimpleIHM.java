package client;

import commande.ComChargement;
import commande.ComColler;
import commande.ComCopier;
import commande.ComCouper;
import commande.ComInsertionTexte;
import commande.ComSauvegarder;
import commande.ComSelection;
import commande.ComSupprimer;
import commande.ItfCommande;
import receiver.EditeurSimple;
import receiver.ItfMoteurEditeur;
/**
 * Classe qui contient toutes les commandes possible
 * @author Antoine FEREY
 * @version 1.0
 *
 */
public class SimpleIHM implements ItfIhmMoteur {
	/**
	 * Début du curseur
	 */
	int debut;
	/**
	 * Fin du curseur
	 */
	int fin;
	/**
	 * character saisie par l'utilisateur
	 */
	Character entreeclavier;
	/**
	 * Nom du fichier à charger
	 */
	String filecharge;
	/**
	 * Nom du fichier à sauvegarder
	 */
	String filesauve;

	private ItfMoteurEditeur editeur = new EditeurSimple();

	

	private ItfCommande sauvegarde = new ComSauvegarder(editeur,  this);
	private ItfCommande chargement = new ComChargement(editeur,  this);
	private ItfCommande selection = new ComSelection(editeur, this);
	private ItfCommande insertion = new ComInsertionTexte(editeur,this);
	
	private ItfCommande copier = new ComCopier(editeur);
	private ItfCommande coller = new ComColler(editeur);
	private ItfCommande couper = new ComCouper(editeur);
	private ItfCommande supprimer = new ComSupprimer(editeur);
	


	
	public SimpleIHM() {
	}
	@Override
	public void pressCopier() {
		// TODO Auto-generated method stub
		this.copier.execute();

	}

	@Override
	public void pressColler() {
		this.coller.execute();
		// TODO Auto-generated method stub

	}
	
	@Override
	public void pressCouper() {
		couper.execute();
		
	}

	@Override
	public void pressSelection(int debut, int fin) {
		this.debut = debut;
		this.fin = fin;
		this.selection.execute();

	}

	@Override
	public void pressInsertion(Character c) {
		this.entreeclavier = c;
		this.insertion.execute();

	}
	

	@Override
	public void pressSauvegarder(String namefile) {
		this.filesauve = namefile;
		this.sauvegarde.execute();

	}

	@Override
	public void pressCharger(String namefile) {
		this.filecharge = namefile;
		this.chargement.execute();

	}
	
	@Override
	public void pressSupprimer() {
		this.supprimer.execute();
		
	}

	@Override
	public Character getInput() {
		// TODO Auto-generated method stub
		return entreeclavier;
	}

	@Override
	public Integer getCurseurDebut() {
		// TODO Auto-generated method stub
		return debut;
	}

	@Override
	public Integer getCurseurFin() {
		// TODO Auto-generated method stub
		return fin;
	}

	@Override
	public String getFileSauvegarde() {
		// TODO Auto-generated method stub
		return this.filesauve;
	}

	@Override
	public String getFileChargement() {
		// TODO Auto-generated method stub
		return this.filecharge;
	}
	
	
	public void afficher() {
		System.out.println("### BOF ###");
		System.out.println(this.editeur);
		System.out.println("### EOF ###");
	}

	

	

	

}
