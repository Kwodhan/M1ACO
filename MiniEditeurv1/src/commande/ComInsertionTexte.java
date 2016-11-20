package commande;

import client.ItfIhmMoteur;
import receiver.ItfMoteurEditeur;

/**
 * La commande qui permet d'inserer un charactere
 * 
 * @see ItfCommande
 * @author Antoine FEREY
 * @version 1.0
 */
public class ComInsertionTexte implements ItfCommande {
	/**
	 * l'editeur ou on travail
	 */
	private final ItfMoteurEditeur editeur;
	/**
	 * Moteur de l'ihm
	 */
	private final ItfIhmMoteur ihm;

	/**
	 * Constructeur de la commande Insertion Texte
	 * 
	 * @param editeur
	 * 			@see ComInsertionTexte#editeur
	 * @param ihm
	 * 			@see ComInsertionTexte#ihm
	 */
	public ComInsertionTexte(ItfMoteurEditeur editeur, ItfIhmMoteur ihm) {
		super();
		this.editeur = editeur;

		this.ihm = ihm;

	}

	/**
	 * Cette commande peut être enregister pour une macro
	 * 
	 * @see ItfCommande#execute()
	 */
	@Override
	public void execute() {
		System.out.println("insertion : " + this.ihm.getInput());
		this.editeur.insertionTexte(this.ihm.getInput());

	}

}
