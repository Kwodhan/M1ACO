package commande;

import enregistrement.Enregistreur;
import enregistrement.ItfMemento;
import enregistrement.MementoVide;

/**
 * La commande qui permet de debuter l'enregistrement d'une macro
 * 
 * @see ItfCommande
 * @author Antoine FEREY
 * @version 3.0
 */
public class ComDebut implements ItfCommande {
	/**
	 * L'enregistreur de macro
	 */
	private final Enregistreur enregistreur;

	/**
	 * Constructeur de la commande debut
	 * 
	 * @param enregistreur
	 * @see ComDebut#enregistreur
	 */
	public ComDebut(Enregistreur enregistreur) {
		super();
		this.enregistreur = enregistreur;
	}

	/**
	 * 
	 * @see ItfCommande#execute()
	 */
	@Override
	public void execute() {
		System.out.println("debut macro");

		this.enregistreur.Debut();

	}

	/**
	 * Memento vide car on n'enregistre pas l'action de debuter une macro dans une macro
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
