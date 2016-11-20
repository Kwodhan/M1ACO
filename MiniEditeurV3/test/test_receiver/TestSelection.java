package test_receiver;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import receiver.Buffer;
import receiver.ErreurInsertionException;
import receiver.Selection;

/**
 * 
 * @author kwodhan
 *
 */
public class TestSelection {

	private Selection s;
	private Buffer b;

	/**
	 * debut du curseur
	 */
	int debut;
	/**
	 * fin du curseur
	 */
	int fin;
	/**
	 * longueur de l'ajout
	 */
	int longueur;
	/**
	 * max de la selection
	 */
	final int max;
	/**
	 * min de la selection
	 */
	final int min;

	public TestSelection() {

		this.min = 0;
		this.max = 5000;
	}

	@Before
	public void setUp() throws Exception {

		b = new Buffer();
		s = new Selection(b);
		longueur = MyRandom.randomInt(min, max);

		while (debut > longueur) {
			debut = MyRandom.randomInt(min, max);
		}
		while (fin > longueur) {
			fin = MyRandom.randomInt(min, max);
		}

	}

	@Test
	public void testSelectionTexte() throws ErreurInsertionException {
		for (int i = longueur; i > 0; i--) {
			this.b.AddChar(longueur - i, 'a');
		}

		s.selectionTexte(debut, fin);
		assertTrue("Debut sup a fin", s.getDebut() <= s.getFin());
		assertTrue("Debut sup a longeur buf", s.getDebut() <= b.length());
		assertTrue("fin sup a longeur buf", s.getFin() <= b.length());

	}

	@Test
	public void testIsCurseur() throws ErreurInsertionException {
		for (int i = longueur; i > 0; i--) {
			this.b.AddChar(longueur - i, 'a');
		}
		s.selectionTexte(debut, debut);
		assertTrue(s.getDebut() + " " + s.getFin() + " doit avoir la meme position pour un curseur", s.isCurseur());

	}

}
