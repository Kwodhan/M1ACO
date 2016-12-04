package commande;

import enregistrement.ItfMemento;
import enregistrement.MementoVide;
import enregistrement.TimeMachine;

/**
 * La commande qui permet de refaire
 * 
 * @see ItfCommande
 * @author Antoine FEREY
 * @version 3.0
 */
public class ComDo implements ItfCommande {
	/**
	 * Gestionnaire des enregistrements des actions
	 */
	private final TimeMachine timemachine;

	/**
	 * Constructeur de la commande Do
	 * @param timemachine
	 * @see ComDo#timemachine
	 */
	public ComDo(TimeMachine timemachine) {
		super();
		this.timemachine = timemachine;
	}

	/**
	 * 
	 * @see ItfCommande#execute()
	 */
	@Override
	public void execute() {
		System.out.println("faire");
		this.timemachine.Faire();

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
