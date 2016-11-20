package receiver;
/**
 * Class contenant un string lors d'une commande copier
 * 
 * 
 * @author Antoine FEREY
 * @version 1.0
 */
public class PressePapier {
	/**
	 * String du pressepapier
	 */
	private String presse;
	/**
	 * Constructeur du presse papier
	 */
	public PressePapier() {
		super();
		presse = new String();

	}

	protected String getPresse() {
		return presse;
	}

	protected void setPresse(String presse) {

		this.presse = presse;

	}

	public String toString() {

		if (this.presse.length() == 0)
			return "Presse Papier Vide";
		else
			return "Presse Papier : " + this.presse;
	}
	/**
	 * Longueur du presse papier
	 * @return
	 */
	protected int length() {
		
		return this.presse.length();
	}

}
