package receiver;

/**
 * Buffer de caractère
 * 
 * @author Antoine FEREY
 * @version 2.0
 */
public class Buffer {
	/**
	 * Liste de caractères 
	 */
	private StringBuffer buffer;
	/**
	 * Constructeur du Buffer
	 */
	public Buffer() {
		super();
		this.buffer = new StringBuffer("");
	}

	/**
	 * Ajoute un char à un emplacement du buffer
	 * 
	 * @param debut
	 *            Emplacement ou ajouter
	 * @param charac
	 *            Char à ajouter
	 */

	protected void AddChar(int debut, Character charac) throws ErreurInsertionException {
		if (debut <= this.buffer.length()) {
			this.buffer.insert(debut, charac);
		} else {
			throw new ErreurInsertionException(debut, this.length());
		}
	}

	/**
	 * Ajoute un string à un emplacement du buffer
	 * 
	 * @param debut
	 *            Emplacement ou ajouter
	 * @param string
	 *            à ajouter
	 */

	protected void AddString(int debut, String string) throws ErreurInsertionException {
		if (debut <= this.length()) {
			this.buffer.insert(debut, string);
		} else {
			throw new ErreurInsertionException(debut, this.length());
		}
	}

	/**
	 * Enleve un string à un emplacement du buffer
	 * 
	 * @param debut
	 *            Emplacement du debut de la suppression
	 * @param fin
	 *            Emplacement du fin de la suppression
	 */

	protected void RemoveString(int debut, int fin) throws ErreurInsertionException {
		if (debut <= this.length() && fin <= this.length()) {
			this.buffer.delete(debut, fin);
		} else {
			throw new ErreurInsertionException(debut, this.length());
		}
	}

	/**
	 * Retourne un string sur un emplacement donnée
	 * 
	 * @param debut
	 *            Emplacement du debut de la selection
	 * @param fin
	 *            Emplacement du fin de la selection
	 * @return un String 
	 */
	// protected
	protected String substring(int debut, int fin) throws ErreurInsertionException {
		if (debut <= this.length() && fin <= this.length()) {
			return this.buffer.substring(debut, fin);
		} else {
			throw new ErreurInsertionException(debut, this.length());
		}

	}

	/**
	 * Retourne un caractère sur un emplacement
	 * 
	 * @param index
	 *            Emplacement du caractère dans le buffer

	 * @return un caractère
	 */
	// protected
	protected Character charAt(int index) throws ErreurInsertionException {
		if (index <= this.length()) {
			return this.buffer.charAt(index);
		} else {
			throw new ErreurInsertionException(index, this.length());
		}

	}
	
	
	/**
	 * Longueur du buffer
	 * 
	 * @return
	 */
	protected int length() {

		return this.buffer.length();
	}

	public String toString() {
		return this.buffer.toString();
	}

}
