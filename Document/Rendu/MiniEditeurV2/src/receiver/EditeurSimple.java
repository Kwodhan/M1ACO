package receiver;

import java.io.IOException;

/**
 * Un editeur simple
 * @see ItfMoteurEditeur
 * @author Antoine FEREY
 * @version 2.0
 *
 */
public class EditeurSimple  implements ItfMoteurEditeur {
	/**
	 * @see Buffer
	 */
	private Buffer buffer;
	/**
	 * @see PressePapier
	 */
	private PressePapier pressPapier;
	/**
	 * @see Selection
	 */
	private Selection selection;
	/**
	 * @see FluxFile
	 */
	private FluxFile fluxFile;
	/**
	 * Constructeur d'un editeur simple
	 */
	public EditeurSimple() {
		super();
		this.buffer = new Buffer();
		this.pressPapier = new PressePapier();
		this.selection = new Selection();
		this.fluxFile = new FluxFile();
	}
	/**
	 * @see ItfMoteurEditeur#copier()
	 */
	@Override
	public void copier() {

		if (!this.selection.isCurseur()) {

			try {
				this.pressPapier.setPresse(
						new String(this.buffer.substring(this.selection.getDebut(), this.selection.getFin())));
			} catch (ErreurInsertionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	/**
	 * @see ItfMoteurEditeur#insertionTexte(Character)
	 */
	@Override
	public void insertionTexte(Character c) {
		try {
			if (this.selection.isCurseur()) {
				this.buffer.AddChar(this.selection.getDebut(), c);
				this.selection.setCurseur((this.selection.getDebut() + 1),this.buffer);
			} else {
				this.buffer.RemoveString(this.selection.getDebut(), this.selection.getFin());
				this.buffer.AddChar(this.selection.getDebut(), c);
				this.selection.setCurseur((this.selection.getDebut() + 1),this.buffer);
			}
			
		} catch (ErreurInsertionException e) {

			e.printStackTrace();

		}

	}
	/**
	 * @see ItfMoteurEditeur#couper()
	 */
	@Override
	public void couper() {
		if (!this.selection.isCurseur()) {
			try {
				this.pressPapier.setPresse(
						new String(this.buffer.substring(this.selection.getDebut(), this.selection.getFin())));
				this.buffer.RemoveString(this.selection.getDebut(), this.selection.getFin());

				this.selection.setCurseur(this.selection.getDebut(),this.buffer);
				
			} catch (ErreurInsertionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	/**
	 * @see ItfMoteurEditeur#coller()
	 */
	@Override
	public void coller() {

		if (this.pressPapier.length() == 0) {

			return;
		}
		try {
			if (this.selection.isCurseur()) {
				this.buffer.AddString(this.selection.getDebut(), this.pressPapier.getPresse());
				this.selection.setCurseur((this.selection.getDebut() + this.pressPapier.length()),this.buffer);
			} else {
				this.buffer.RemoveString(this.selection.getDebut(), this.selection.getFin());
				this.buffer.AddString(this.selection.getDebut(), this.pressPapier.getPresse());
				this.selection.setCurseur((this.selection.getDebut() + this.pressPapier.length()),this.buffer);
			}
			
		} catch (ErreurInsertionException e) {

			e.printStackTrace();

		}
	}
	/**
	 * @see ItfMoteurEditeur#sauvegarder(String)
	 */
	@Override
	public void sauvegarder(String namefile) {
		try {
			this.fluxFile.BufferToFile(this.buffer, namefile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Erreur dans la sauvegarde du fichier " + namefile);
		} catch (ErreurInsertionException e) {
			// TODO Auto-generated catch block
			System.err.println("Erreur dans la sauvegarde du fichier " + namefile);
		}

	}
	/**
	 * @see ItfMoteurEditeur#charger(String)
	 */
	@Override
	public void charger(String namefile) {
		try {

			this.buffer = this.fluxFile.FileToBuffer(namefile);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ErreurInsertionException e) {
			// TODO Auto-generated catch block
			System.err.println("Erreur dans le chargement du fichier " + namefile);
		}

	}
	/**
	 * @see ItfMoteurEditeur#selectionTexte(int, int)
	 */
	@Override
	public void selectionTexte(int debut, int fin) {
		this.selection.selectionTexte(debut, fin, this.buffer);

	}

	@Override
	public String toString() {
		return this.buffer.toString();
	}	
	/**
	 * @see ItfMoteurEditeur#supprimer()
	 */
	@Override
	public void supprimer() {
		if (this.selection.getDebut() == 0 && this.selection.getFin() == 0) {
			return;
		}
		try {
			if (this.selection.isCurseur()) {
				this.buffer.RemoveString(this.selection.getDebut() - 1, this.selection.getDebut());
				this.selection.setCurseur((this.selection.getDebut() - 1),this.buffer);
			} else {

				this.buffer.RemoveString(this.selection.getDebut(), this.selection.getFin());
				this.selection.setCurseur(this.selection.getDebut(),this.buffer);
				
			}
		} catch (ErreurInsertionException e) {

			e.printStackTrace();

		}

	}


}
