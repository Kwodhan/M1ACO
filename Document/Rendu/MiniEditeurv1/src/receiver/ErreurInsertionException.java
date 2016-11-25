package receiver;
/**
 * Erreur levée quand l'insertion d'un caractére ou un string se fait en dehors du buffer
 * @author Antoine FEREY
 * @version 1.0
 */
public class ErreurInsertionException extends Exception {



	private static final long serialVersionUID = 1L;
	public ErreurInsertionException(int curseur,int longueurbuf){
		super("Votre curseur : "+curseur+" Dépasse la longueur du buffer :"+longueurbuf);
		
	}

}
