package commande;

import enregistrement.Enregistreur;
import enregistrement.ItfMemento;
import enregistrement.MementoVide;

/**
 * La commande qui permet de stoper l'enregistrement une macro
 * 
 * @see ItfCommande
 * @author Antoine FEREY
 * @version 2.0
 */
public class ComStop implements ItfCommande {
	/**
	 * L'enregistreur de macro
	 */
	private final Enregistreur enregistreur;

	/**
	 * La commande de stop
	 * 
	 * @param enregistreur
	 */
	public ComStop(Enregistreur enregistreur) {
		super();
		this.enregistreur = enregistreur;
	}

	/**
	 * 
	 * @see ItfCommande#getMemento()
	 */
	@Override
	public void execute() {
		System.out.println("Stop macro");
		this.enregistreur.Stop();

	}

	/**
	 * Memento vide car on n'enregistre pas l'action de debuter une macro dans
	 * une macro
	 */
	@Override
	public ItfMemento getMemento() {
		// TODO Auto-generated method stub
		return new MementoVide();
	}

	/**
	 * Cette fonction ne sera jamais appelée
	 */
	@Override
	public void setMemento(ItfMemento m) {
		// TODO Auto-generated method stub

	}

}
