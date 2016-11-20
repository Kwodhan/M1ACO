package client;

/**
 * <b>Commande Pattern --> Invoker</b>
 * 
 * @author Antoine FEREY
 * @version 2.0
 */
public interface ItfIhmMoteur {
	/**
	 * Information de l'ihm. 
	 * @return Le charactere tapé par l'utilisateur
	 */
	Character getInput();
	/**
	 * Information de l'ihm
	 * @return la position du curseur de début
	 */
	Integer getCurseurDebut();
	/**
	 * Information de l'ihm
	 * @return la position du curseur de fin
	 */
	Integer getCurseurFin();
	/**
	 * Information de l'ihm
	 * @return le nom du fichier à sauvegarde
	 */
	String getFileSauvegarde();
	/**
	 * Information de l'ihm
	 * @return le nom du fichier à charger
	 */
	String getFileChargement();
	/**
	 * L'action de sauvegarde par l'utilisateur
	 * @param namefile nom du fichier à sauvegarder
	 */
	void pressSauvegarder(String namefile);
	/**
	 * L'action de charger par l'utilisateur
	 * @param namefile nom du fichier à charger
	 */
	void pressCharger(String namefile);
	/**
	 * L'action de copier par l'utilisateur
	 */
	void pressCopier();
	/**
	 * L'action de coller par l'utilisateur
	 */
	void pressColler();
	/**
	 * L'action de couper par l'utilisateur
	 */
	void pressCouper();
	/**
	 * L'action de supprimer par l'utilisateur
	 */
	void pressSupprimer();
	/**
	 * L'action de selection par l'utilisateur
	 * @param debut position du curseur de debut
	 * @param fin position du curseur de fin
	 */
	void pressSelection(int debut,int fin);
	/**
	 * L'action d'insertion par l'utilisateur
	 * @param c Character à inserer
	 */
	void pressInsertion(Character c);
	/**
	 * L'action de debut de macro par l'utilisateur
	 */
	void pressDebut();
	/**
	 * L'action de rejouer macro par l'utilisateur
	 */
	void pressRejouer();
	/**
	 * L'action de stoper macro par l'utilisateur
	 */
	void pressStop();
	/**
	 * L'action de refaire par l'utilisateur
	 */
	void afficher();

}
