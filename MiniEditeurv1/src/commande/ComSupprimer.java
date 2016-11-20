package commande;

import receiver.ItfMoteurEditeur;

/**
 * La commande qui permet de supprimer un charactere
 * 
 * @see ItfCommande
 * @author Antoine FEREY
 * @version 1.0
 */
public class ComSupprimer implements ItfCommande {
	/**
	 * L'editeur ou on travaille
	 */
	private final ItfMoteurEditeur editeur;

	/**
	 * La commande de supprimer
	 * 
	 * @param editeur
	 * @see ComSupprimer#editeur
	 */
	public ComSupprimer(ItfMoteurEditeur editeur) {
		super();
		this.editeur = editeur;

	}

	/**
	 * Cette commande peut être enregister pour une macro
	 * 
	 * @see ItfCommande#execute()
	 */
	@Override
	public void execute() {
		System.out.println("supprimer");
		this.editeur.supprimer();

	}

}
