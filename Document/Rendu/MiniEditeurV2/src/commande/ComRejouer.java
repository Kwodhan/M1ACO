package commande;

import enregistrement.Enregistreur;
import enregistrement.ItfMemento;
import enregistrement.MementoVide;
/**
 * La commande qui permet de rejouer une macro
 * 
 * @see ItfCommande
 * @author Antoine FEREY
 * @version 2.0
 */
public class ComRejouer implements ItfCommande {
	/**
	 * Enregistreur de macro
	 */
	private final Enregistreur enregistreur;
	/**
	 * Constructeur de la commande rejouer
	 * @param enregistreur @see ComRejouer#enregistreur
	 */
	public ComRejouer(Enregistreur enregistreur) {
		super();
		this.enregistreur = enregistreur;
	}
	/**
	 * 
	 * @see ItfCommande#getMemento()
	 */
	@Override
	public void execute() {
		System.out.println("rejouer macro");
		this.enregistreur.Rejouer();

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
