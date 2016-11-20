package commande;

import client.ItfIhmMoteur;
import enregistrement.ItfMemento;
import enregistrement.MementoVide;
import receiver.ItfMoteurEditeur;

/**
 * La commande qui permet de charger un fichier via un nom de fichier
 * 
 * @see ItfCommande
 * @author Antoine FEREY
 * @version 3.0
 */
public class ComChargement implements ItfCommande {
	/**
	 * Moteur de l'ihmn  
	 */
	private final ItfIhmMoteur ihm;
	/**
	 * L'editeur ou on travaille
	 */
	private final ItfMoteurEditeur editeur;
	/**
	 * Constructeur de la commande chargement
	 * 
	 * @param editeur @see ComChargement#editeur
	 * @param ihm @see ComChargement#ihm
	 */
	public ComChargement(ItfMoteurEditeur editeur, ItfIhmMoteur ihm) {
		super();
		this.editeur = editeur;

		this.ihm = ihm;
	}
	
	/**
	 * @see ItfCommande#execute()
	 */
	@Override
	public void execute() {

		this.editeur.charger(this.ihm.getFileChargement());
	
	}
	/**
	 * Memento vide car on n'enregistre pas l'action de chargement dans une macro
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
