package commande;

import enregistrement.ItfMemento;

/**
 * Interface pour les commandes
 * <b>Commande Pattern --> Commande</b>
 * <b>Memento Pattern --> Originator</b>
 * @author Antoine FEREY
 * @version 3.0
 */
public interface ItfCommande {
	/**
	 * execute la commande
	 */
	public void execute();
	/**
	 * permet de savoir les informations à sauvegarder pour une macro
	 * @return un memento qui contient les informations à sauvegarder
	 */
	public ItfMemento getMemento();
	/**
	 * applique le memento à la commande puis execute la commande
	 * @param m Le memento à appliquer
	 */
	public void setMemento(ItfMemento m);
}
