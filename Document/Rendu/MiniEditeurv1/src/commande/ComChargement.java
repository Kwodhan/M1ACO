package commande;

import client.ItfIhmMoteur;
import receiver.ItfMoteurEditeur;

/**
 * La commande qui permet de charger un fichier via un nom de fichier
 * 
 * @see ItfCommande
 * @author Antoine FEREY
 * @version 1.0
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


}
