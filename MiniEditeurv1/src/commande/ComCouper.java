package commande;

import receiver.ItfMoteurEditeur;

/**
 * La commande qui permet de couper
 * 
 * @see ItfCommande
 * @author Antoine FEREY
 * @version 1.0
 */
public class ComCouper implements ItfCommande {
	/**
	 * L'editeur ou on travaille
	 */
	private final ItfMoteurEditeur editeur;

	/**
	 * Constructeur de la commande couper
	 * 
	 * @param editeur
	 * @see ComCouper#editeur
	 */
	public ComCouper(ItfMoteurEditeur editeur) {
		super();
		this.editeur = editeur;

	}

	/**
	 * 
	 * @see ItfCommande#execute()
	 */
	@Override
	public void execute() {
		System.out.println("couper");
		this.editeur.couper();

	}

}
