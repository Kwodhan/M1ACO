package enregistrement;

import java.util.ArrayList;

import commande.ItfCommande;

/**
 * enregistre la macro
 * <b>Memento Pattern --> CareTaker</b>
 * @author Antoine FEREY
 * @version 3.0
 */
public class Enregistreur {
	/**
	 * suite de commande lier avec listmemento
	 */
	private ArrayList<ItfCommande> listcommande;
	/**
	 * suite de memento lier avec listcommande
	 */
	private ArrayList<ItfMemento> listmemento;
	/**
	 * savoir si l'enregistreur est activer
	 */
	private boolean rec;
	/**
	 * Constructeur de l'enregistreur
	 * initialise les listes des commandes
	 * initialise les listes des mementos
	 */
	public Enregistreur() {
		super();

		listcommande = new ArrayList<ItfCommande>();
		listmemento = new ArrayList<ItfMemento>();
		this.rec = false;
	}

	/**
	 * on réinitialise la liste des commandes enregistrer puis on met rec à on
	 */
	public void Debut() {

		listcommande = new ArrayList<ItfCommande>();
		listmemento = new ArrayList<ItfMemento>();
		this.rec = true;
	}

	/**
	 * On ajoute une commande à listeCom
	 * 
	 * @param commande
	 *            à ajouter
	 */
	public void Ajout(ItfCommande commande) {
		if (this.rec) {
			this.listcommande.add(commande);
			this.listmemento.add(commande.getMemento());

		}

	}

	/**
	 * arrete l'enregistrement. met rec à off
	 */
	public void Stop() {
		this.rec = false;
	}

	/**
	 * Rejout la listeCom de commande
	 */
	public void Rejouer() {
		if (!this.rec) {
			for (int i = 0; i < this.listcommande.size(); i++) {

				ItfCommande key = this.listcommande.get(i);

				ItfMemento value = this.listmemento.get(i);
				key.setMemento(value);

			}
		}
	}
}
