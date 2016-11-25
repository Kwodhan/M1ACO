package commande;

import client.ItfIhmMoteur;
import enregistrement.Enregistreur;
import enregistrement.ItfMemento;
import enregistrement.MementoInsert;
import receiver.ItfMoteurEditeur;

/**
 * La commande qui permet d'inserer un charactere
 * 
 * @see ItfCommande
 * @author Antoine FEREY
 * @version 3.0
 */
public class ComInsertionTexte implements ItfCommande {
	/**
	 * l'editeur ou on travail
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
	 * Constructeur de la commande Insertion Texte
	 * @param editeur @see ComInsertionTexte#editeur
	 * @param enregistreur @see ComInsertionTexte#enregistreur
	 * @param ihm @see ComInsertionTexte#ihm
	 */
	public ComInsertionTexte(ItfMoteurEditeur editeur, Enregistreur enregistreur, ItfIhmMoteur ihm) {
		super();
		this.editeur = editeur;
		this.enregistreur = enregistreur;
		this.ihm = ihm;

	}

	/**
	 * Cette commande peut être enregister pour une macro
	 * 
	 * @see ItfCommande#execute()
	 */
	@Override
	public void execute() {
		System.out.println("insertion : " + this.ihm.getInput());
		this.editeur.insertionTexte(this.ihm.getInput());
		System.out.println(this.ihm.getInput());
		this.enregistreur.Ajout(this);

	}

	/**
	 * Memento qui contient le caractère à ajouter pour la macro
	 * 
	 * @see ItfCommande#getMemento()
	 */
	@Override
	public ItfMemento getMemento() {
		// TODO Auto-generated method stub
		return new MementoInsert(this.ihm.getInput());
	}
	/**
	 * 
	 * @see ItfCommande#setMemento(ItfMemento)
	 */
	@Override
	public void setMemento(ItfMemento m) {
		this.ihm.pressInsertion(((MementoInsert) m).getAjoutChar());

	}

}
