package commande;

import enregistrement.Enregistreur;
import enregistrement.ItfMemento;
import enregistrement.MementoVide;
import receiver.ItfMoteurEditeur;

/**
 * La commande qui permet de couper
 * 
 * @see ItfCommande
 * @author Antoine FEREY
 * @version 3.0
 */
public class ComCouper implements ItfCommande {
	/**
	 * L'editeur ou on travaille
	 */
	private final ItfMoteurEditeur editeur;
	/**
	 * L'enregistreur de macro
	 */
	private final Enregistreur enregistreur;

	/**
	 * Constructeur de la commande couper
	 * 
	 * @param editeur
	 * 			@see ComCouper#editeur
	 * @param enregistreur
	 * 			@see ComCouper#enregistreur
	 */
	public ComCouper(ItfMoteurEditeur editeur, Enregistreur enregistreur) {
		super();
		this.editeur = editeur;
		this.enregistreur = enregistreur;

	}

	/**
	 * Cette commande peut être enregister pour une macro
	 * 
	 * @see ItfCommande#execute()
	 */
	@Override
	public void execute() {
		System.out.println("couper");
		this.editeur.couper();
		this.enregistreur.Ajout(this);

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
