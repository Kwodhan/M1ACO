package receiver;
/**
 * Postionne les Curseurs pour un editeur
 * @author Antoine FEREY
 * @version 2.0
 *
 */
public class Selection {
	/**
	 * position du curseur de debut
	 */
	private int debut;
	/**
	 * position du curseur de fin
	 */
	private int fin;
	/**
	 * Constructeur de la selection
	 */
	public Selection() {
		super();


		this.debut = 0;
		this.fin = 0;
	}
	/**
	 * Gére la position du début et de la fin.
	 * Cas : 
	 * <ul>
	 * <li>les positions debut ou/et fin sont en dehors du buffer</li>
	 * <li>le début est sup à la fin</li>
	 * <li>la fin est inf au début</li>
	 * </ul>
	 * @param debut début de la selection
	 * @param fin fin de la selection
	 * @param buffer le buffer ou l'on travaille
	 */
	protected void selectionTexte(int debut, int fin,Buffer buffer) {

		if (debut > fin) {
			this.debut = fin;
			this.fin = debut;

		} else {
			this.debut = debut;
			this.fin = fin;
		}

		this.debut = this.debut > buffer.length() ? buffer.length() : this.debut;

		this.fin = this.fin > buffer.length() ? buffer.length() : this.fin;
		
		this.debut = this.debut < 0 ? 0 : this.debut;

		this.fin = this.fin < 0 ? 0 : this.fin;

	}
	/**
	 * retourne si la selection est un curseur
	 * @return
	 */
	protected boolean isCurseur() {
		return this.debut == this.fin;
	}

	protected int getDebut() {
		return debut;
	}

	protected int getFin() {
		return fin;
	}
	/**
	 * pose la selection en curseur
	 * @param curseur position du curseur
	 * @param buffer le buffer ou l'on travaille
	 */
	protected void setCurseur(int curseur,Buffer buffer) {
		this.selectionTexte(curseur,curseur,buffer);
		
	}



}
