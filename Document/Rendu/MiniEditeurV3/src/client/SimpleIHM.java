package client;

import commande.ComChargement;
import commande.ComColler;
import commande.ComCopier;
import commande.ComCouper;
import commande.ComDebut;
import commande.ComDo;
import commande.ComInsertionTexte;
import commande.ComRejouer;
import commande.ComSauvegarder;
import commande.ComSelection;
import commande.ComStop;
import commande.ComSupprimer;
import commande.ComUndo;
import commande.ItfCommande;
import enregistrement.Enregistreur;
import receiver.EditeurSimple;
import receiver.ItfMoteurEditeur;
import timeMachine.TimeMachine;
/**
 * Classe qui contient toutes les commandes possible
 * Elle contient l'enregistreur de macro et le gestionnaire des actions
 * @author Antoine FEREY
 * @version 3.0
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
	private Enregistreur enregistreur = new Enregistreur();
	private TimeMachine timemachine = new TimeMachine(editeur);
	

	private ItfCommande sauvegarde = new ComSauvegarder(editeur,  this);
	private ItfCommande chargement = new ComChargement(editeur,  this);
	private ItfCommande selection = new ComSelection(editeur, enregistreur, this);
	private ItfCommande insertion = new ComInsertionTexte(editeur, enregistreur,this);
	
	private ItfCommande copier = new ComCopier(editeur, enregistreur);
	private ItfCommande coller = new ComColler(editeur, enregistreur);
	private ItfCommande couper = new ComCouper(editeur, enregistreur);
	private ItfCommande supprimer = new ComSupprimer(editeur, enregistreur);
	
	private ItfCommande debutMacro = new ComDebut(enregistreur);
	private ItfCommande stopMacro = new ComStop(enregistreur);
	private ItfCommande rejouerMacro = new ComRejouer(enregistreur);
	
	private ItfCommande Do = new ComDo(timemachine);
	private ItfCommande undo = new ComUndo(timemachine);
	
	public SimpleIHM() {
		this.editeur.addObserver(timemachine);
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
	public void pressDebut() {
		this.debutMacro.execute();

	}

	@Override
	public void pressRejouer() {
		this.rejouerMacro.execute();

	}

	@Override
	public void pressStop() {
		this.stopMacro.execute();

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
	public void pressDo() {
		this.Do.execute();
		
	}

	@Override
	public void pressUndo() {
		this.undo.execute();
		
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
	public String toString() {
		return this.editeur.toString();
	}
	

	

	

}
