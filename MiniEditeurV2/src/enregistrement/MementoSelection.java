package enregistrement;
/**
 * Memento pour la selection 
 * @author Antoine FEREY
 * @version 2.0
 */
public class MementoSelection implements ItfMemento {
	/**
	 * curseur de début
	 */
	final int curseurdebut;
	/**
	 * curseur de fin
	 */
	final int curseurfin;
	public MementoSelection(int curseurdebut, int curseurfin) {
		super();
		this.curseurdebut = curseurdebut;
		this.curseurfin = curseurfin;
	}
	public int getCurseurdebut() {
		return curseurdebut;
	}
	public int getCurseurfin() {
		return curseurfin;
	}
	

	
}
