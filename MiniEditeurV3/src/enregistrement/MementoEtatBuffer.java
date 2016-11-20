package enregistrement;
/**
 * Memento de l'etat de l'editeur pour Gestionnaire des enregistrements des actions
 * @author Antoine FEREY
 * @version 3.0
 */
public class MementoEtatBuffer implements ItfMemento {
	/**
	 * debut du curseur
	 */
	int debut;
	/**
	 * fin du curseur
	 */
	int fin;
	/**
	 * contenu du buffer
	 */
	String texte;

	

	public MementoEtatBuffer(int debut, int fin, String texte) {
		super();
		this.debut = debut;
		this.fin = fin;
		this.texte = texte;
	}
	
	public int getDebut() {
		return debut;
	}

	public int getFin() {
		return fin;
	}
	
	public String getTexte() {
		return texte;
	}

}
