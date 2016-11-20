package commande;

import client.ItfIhmMoteur;
import enregistrement.Enregistreur;
import enregistrement.ItfMemento;
import enregistrement.MementoSelection;
import receiver.ItfMoteurEditeur;

/**
 * La commande qui permet la selection dans l'editeur
 * 
 * @see ItfCommande
 * @author Antoine FEREY
 * @version 3.0
 */
public class ComSelection implements ItfCommande {
	/**
	 * Editeur ou on travaille
	 */
	private final ItfMoteurEditeur editeur;
	/**
	 * Moteur de l'ihm
	 */
	private final ItfIhmMoteur ihm;
	/**
	 * L'enregistreur de macro
	 */
	private final Enregistreur enregistreur;

	/**
	 * 
	 * @param editeur
	 * 			@see ComSelection#editeur
	 * @param enregistreur
	 * 			@see ComSelection#enregistreur
	 * @param ihm
	 * 			@see ComSelection#ihm
	 */
	public ComSelection(ItfMoteurEditeur editeur, Enregistreur enregistreur, ItfIhmMoteur ihm) {
		super();
		this.ihm = ihm;
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
		System.out.println("selection : " + this.ihm.getCurseurDebut() + " -> " + this.ihm.getCurseurFin());
		this.editeur.selectionTexte(this.ihm.getCurseurDebut(), this.ihm.getCurseurFin());

		this.enregistreur.Ajout(this);

	}

	/**
	 * Memento qui contient les positions de debut et de fin à ajouter pour la
	 * macro
	 * 
	 * @see ItfCommande#getMemento()
	 */
	@Override
	public ItfMemento getMemento() {
		// TODO Auto-generated method stub
		return new MementoSelection(this.ihm.getCurseurDebut(), this.ihm.getCurseurFin());
	}

	/**
	 * 
	 * @see ItfCommande#setMemento(ItfMemento)
	 */
	@Override
	public void setMemento(ItfMemento m) {
		this.ihm.pressSelection(((MementoSelection) m).getCurseurdebut(), ((MementoSelection) m).getCurseurfin());

	}

}
