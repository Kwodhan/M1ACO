package commande;

import client.ItfIhmMoteur;
import enregistrement.ItfMemento;
import enregistrement.MementoVide;
import receiver.ItfMoteurEditeur;
/**
 * La commande qui permet de sauvegarder un fichier via un nom de fichier
 * 
 * @see ItfCommande
 * @author Antoine FEREY
 * @version 3.0
 */
public class ComSauvegarder implements ItfCommande {
	/**
	 * Moteur de l'ihm
	 */
	private final ItfIhmMoteur ihm;
	/**
	 * L'editeur ou on travaille 
	 */
	private final ItfMoteurEditeur editeur;
	/**
	 * L'enregistreur de macro
	 */
	
	/**
	 * Constructeur de la commande de sauvegarder
	 * @param editeur @see ComSauvegarder#editeur
	 * @param ihm	@see ComSauvegarder#ihm
	 */
	public ComSauvegarder(ItfMoteurEditeur editeur,ItfIhmMoteur ihm) {
		super();
		this.editeur = editeur;
		
		this.ihm=ihm;
	}
	@Override
	public void execute() {
		this.editeur.sauvegarder(this.ihm.getFileSauvegarde());

	}
	/**
	 * @see ItfCommande#execute()
	 */
	@Override
	public ItfMemento getMemento() {
		// TODO Auto-generated method stub
		return new MementoVide();
	}
	
	/**
	 * Cette fonction  ne sera jamais appelée
	 */
	@Override
	public void setMemento(ItfMemento m) {
		// TODO Auto-generated method stub

	}

}
