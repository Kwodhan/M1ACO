package enregistrement;
/**
 * Memento pour l'insertion d'un caractère
 * @author Antoine FEREY
 * @version 3.0
 */
public class MementoInsert implements ItfMemento {
	/**
	 * caractère à sauvegarder
	 */
	private final Character ajoutChar;

	public MementoInsert(Character ajout) {
		super();
		this.ajoutChar = ajout;
	}

	public Character getAjoutChar() {
		return ajoutChar;
	}
}
