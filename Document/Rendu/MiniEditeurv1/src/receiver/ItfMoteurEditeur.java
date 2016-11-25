package receiver;

/**
 * 
 * Moteur ou les traitements des différentes commandes se feront
 * <b>Commande Pattern --> Receiver</b>
 * 
 * @author Antoine FEREY
 * @version 1.0
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


	


}
