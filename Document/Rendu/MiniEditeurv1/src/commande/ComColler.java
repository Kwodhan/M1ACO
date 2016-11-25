package commande;

import receiver.ItfMoteurEditeur;

/**
 * La commande qui permet de coller
 * 
 * @see ItfCommande
 * @author Antoine FEREY
 * @version 1.0
 */
public class ComColler implements ItfCommande {
	/**
	 * L'editeur ou on travaille
	 */
	private final ItfMoteurEditeur editeur;

	/**
	 * Constructeur de la commande chargement
	 * 
	 * @param editeur @see ComColler#editeur
	 */
	public ComColler(ItfMoteurEditeur editeur) {
		super();
		this.editeur = editeur;

	}

	/**
	 * 
	 * @see ItfCommande#execute()
	 */
	@Override
	public void execute() {
		System.out.println("coller");
		this.editeur.coller();


		
	}



}
