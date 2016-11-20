package commande;

import enregistrement.Enregistreur;
import enregistrement.ItfMemento;
import enregistrement.MementoVide;
import receiver.ItfMoteurEditeur;

/**
 * La commande qui permet de copier
 * 
 * @see ItfCommande
 * @author Antoine FEREY
 * @version 3.0
 */
public class ComCopier implements ItfCommande {
	/**
	 * L'editeur ou on travaille
	 */
	private final ItfMoteurEditeur editeur;
	/**
	 * L'enregistreur de macro
	 */
	private final Enregistreur enregistreur;

	/**
	 * Constructeur de la commande copier
	 * 
	 * @param editeur
	 * 			@see ComCopier#editeur
	 * @param enregistreur
	 * 			@see ComCopier#enregistreur
	 */
	public ComCopier(ItfMoteurEditeur editeur, Enregistreur enregistreur) {
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
		System.out.println("copier");
		this.editeur.copier();

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
