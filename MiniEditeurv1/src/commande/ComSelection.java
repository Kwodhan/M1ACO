package commande;

import client.ItfIhmMoteur;
import receiver.ItfMoteurEditeur;

/**
 * La commande qui permet la selection dans l'editeur
 * 
 * @see ItfCommande
 * @author Antoine FEREY
 * @version 1.0
 */
public class ComSelection implements ItfCommande {
	/**
	 * Editeur ou on travaille
	 */
	private final ItfMoteurEditeur editeur;
	/**
	 * Moteur de l'ihm
	 */
	private final ItfIhmMoteur ihm;

	/**
	 * 
	 * @param editeur
	 * @see ComSelection#editeur
	 * @param ihm
	 * @see ComSelection#ihm
	 */
	public ComSelection(ItfMoteurEditeur editeur, ItfIhmMoteur ihm) {
		super();
		this.ihm = ihm;
		this.editeur = editeur;

	}

	/**
	 * 
	 * @see ItfCommande#execute()
	 */
	@Override
	public void execute() {
		System.out.println("selection : " + this.ihm.getCurseurDebut() + " -> " + this.ihm.getCurseurFin());
		this.editeur.selectionTexte(this.ihm.getCurseurDebut(), this.ihm.getCurseurFin());

	}

}
