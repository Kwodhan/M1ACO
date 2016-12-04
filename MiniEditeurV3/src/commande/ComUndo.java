package commande;

import enregistrement.ItfMemento;
import enregistrement.MementoVide;
import enregistrement.TimeMachine;

/**
 * La commande qui permet de defaire
 * 
 * @see ItfCommande
 * @author Antoine FEREY
 * @version 3.0
 */
public class ComUndo implements ItfCommande {
	/**
	 * Gestionnaire des enregistrements des actions
	 */
	TimeMachine timemachine;

	/**
	 * Constructeur de la commande undo
	 * 
	 * @param timemachine
	 * @see ComUndo#timemachine
	 */
	public ComUndo(TimeMachine timemachine) {
		super();
		this.timemachine = timemachine;

	}

	/**
	 * 
	 * @see ItfCommande#execute()
	 */
	@Override
	public void execute() {
		System.out.println("Defaire");

		this.timemachine.Defaire();

	}

	/**
	 * Memento vide car aucune donnée à enregistrer
	 * 
	 * @see ItfCommande#getMemento()
	 */
	@Override
	public ItfMemento getMemento() {
		// TODO Auto-generated method stub
		return new MementoVide();
	}

	/**
	 * @see ItfCommande#setMemento(ItfMemento)
	 */
	@Override
	public void setMemento(ItfMemento m) {
		this.execute();

	}

}
