package commande;

import receiver.ItfMoteurEditeur;

/**
 * La commande qui permet de copier
 * 
 * @see ItfCommande
 * @author Antoine FEREY
 * @version 1.0
 */
public class ComCopier implements ItfCommande {
	/**
	 * L'editeur ou on travaille
	 */
	private final ItfMoteurEditeur editeur;

	/**
	 * Constructeur de la commande copier
	 * 
	 * @param editeur
	 * 			@see ComCopier#editeur
	 */
	public ComCopier(ItfMoteurEditeur editeur) {
		super();
		this.editeur = editeur;
	

	}

	/**
	 * 
	 * @see ItfCommande#execute()
	 */
	@Override
	public void execute() {
		System.out.println("copier");
		this.editeur.copier();

		

	}

	

}
