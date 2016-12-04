package enregistrement;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import receiver.ItfMoteurEditeur;

/**
 * Gestionnaire des enregistrements des actions pour la commande Do et Undo
 * @author Antoine FEREY
 * @version 3.0
 */
public class TimeMachine implements Observer {

	/**
	 * Liste des etats dans le passé 
	 */
	private ArrayList<MementoEtatBuffer> listeavant;

	/**
	 * Liste des etats dans le futur
	 */
	private ArrayList<MementoEtatBuffer> listeapres;
	/**
	 *
	 * Editeur sur lequel on travaille
	 */
	private ItfMoteurEditeur moteur;
	/**
	 * Constructeur de la timeMachine
	 * On initialise les listes <i>listeavant</i> et <i>listeapres</i> à vide
	 * @param moteur @see TimeMachine#moteur
	 */
	public TimeMachine(ItfMoteurEditeur moteur) {
		super();
		this.moteur = moteur;
		this.listeavant = new ArrayList<MementoEtatBuffer>();
		this.listeapres = new ArrayList<MementoEtatBuffer>();

		this.listeavant.add(moteur.getMemento());

	}

	/**
	 * applique le premier memento de la liste listeapres si la liste n'est pas vide 
	 */
	public void Faire() {
		int size = this.listeapres.size();
		if (size > 0) {

			this.moteur.setMemento(this.listeapres.get(size-1));
			this.listeavant.add(this.listeapres.get(size-1));
			this.listeapres.remove(size-1);

		}
	}
	/**
	 * applique l'avant dernier memento de la liste listeavant si la liste n'est pas vide 
	 */
	public void Defaire() {
		int size = this.listeavant.size();
		if (size > 1) {

			this.listeapres.add(this.listeavant.get(size - 1));
			this.listeavant.remove(size - 1);
			this.moteur.setMemento(this.listeavant.get(size - 2));

		}

	}
	/**
	 * appelé quand il y a un changement dans le contenu du buffer pour pouvoir enregistrer l'etat du buffer dans un memento
	 */
	@Override
	public void update(Observable obs, Object obj) {
		this.listeavant.add(this.moteur.getMemento());
		this.listeapres = new ArrayList<MementoEtatBuffer>();

	}
}
