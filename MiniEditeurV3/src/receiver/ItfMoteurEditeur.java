package receiver;

import java.util.Observer;

import enregistrement.MementoEtatBuffer;
/**
 * 
 * Moteur ou les traitements des différentes commandes se feront
 * <b>Commande Pattern --> Receiver</b>
 * <b>Memento Pattern --> Originator</b>
 * <b>Observer Pattern --> Subject</b>
 * 
 * @author Antoine FEREY
 * @version 2.0
 */
public interface ItfMoteurEditeur {
	
	/**
	 * traitement de la commande copier
	 */
	public void copier();
	/**
	 * traitement de la commande coller
	 */
	public void coller();
	/**
	 * traitement de la commande couper
	 */
	public void couper();
	/**
	 * traitement de la commande supprimer
	 */
	public void supprimer();
	/**
	 * traitement de la commande insertion texte
	 * @param c caractère à inserer
	 */
	public void insertionTexte(Character c);
	/**
	 * traitement de la commande selection texte
	 * @param debut position du curseur de debut
	 * @param fin position du curseur de fin
	 */
	public void selectionTexte(int debut, int fin);
	/**
	 * traitement de la commande sauvegarder
	 * @param namefile nom du fichier à sauvegarder
	 */
	public void sauvegarder(String namefile);
	/**
	 * traitement de la commande charger
	 * @param namefile nom du fichier à charger
	 */
	public void charger(String namefile);

	public String toString();
	/**
	 * retourne un memento de l'etat courant
	 * @return
	 */
	public MementoEtatBuffer getMemento();
	/**
	 * applique le memento à l'editeur
	 * @param m @see MementoEtat
	 */
	public void setMemento(MementoEtatBuffer m);
	/**
	 * Permet d'ajouter la TimeMachine comme observer lors d'un changement du buffer
	 * @param o
	 */
	public void addObserver(Observer o);

	


}
