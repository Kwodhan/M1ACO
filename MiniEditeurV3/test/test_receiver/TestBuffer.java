package test_receiver;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import receiver.Buffer;
import receiver.ErreurInsertionException;

public class TestBuffer {
	final int min;
	final int max;


	int debut;
	int fin;
	int longueur;
	Buffer buffer;
	String test;

	/**
	 * 
	 * @param maxlongueur
	 *            longeur max du string dans le buffer
	 * @param min
	 *            valeur minimum du curseur
	 * @param min
	 *            valeur max du curseur
	 */
	public TestBuffer() {

		
		
		this.min = 0;
		this.max = 5000;

	}

	@Before
	public void setUp() throws Exception {
		this.buffer = new Buffer();
		
		longueur = MyRandom.randomInt(min, max);
		this.test = MyRandom.randomString(longueur);
		

		while (debut > longueur) {
			debut = MyRandom.randomInt(min, max);
		}
		while (fin > longueur) {
			fin = MyRandom.randomInt(min, max);
		}
		this.buffer.AddString(0, this.test);

	}

	@Test
	public void testAddChar() throws ErreurInsertionException {
		
		this.buffer.AddChar(this.debut, this.test.charAt(0));

		assertEquals("Pas d'ajout du char " + this.test.charAt(0) + " à la position " + this.debut, this.test.charAt(0),
				this.buffer.substring(this.debut, this.debut + 1).charAt(0));

	}

	@Test
	public void testAddString() throws ErreurInsertionException {
		
		this.buffer.AddString(this.debut, this.test);
		assertEquals("Pas d'ajout du string" + this.test + " à la position " + this.debut, this.test,
				this.buffer.substring(this.debut, this.debut + this.test.length()));
	}

	@Test
	public void testRemoveString() throws ErreurInsertionException {
		int longe1 = this.buffer.length();
		this.buffer.RemoveString(this.debut, this.fin);
		int longe2 = this.buffer.length();
		int temp = this.fin = this.debut;
	
		assertEquals("longueur avant : " + longe1 + " longueur après : " + longe2, longe1 - temp, longe2);
	}

	@Test
	public void testSubstring() throws ErreurInsertionException {
		
		assertEquals("Pas la même sous chaine de caractère",this.test.substring(this.debut, this.fin),this.buffer.substring(this.debut, this.fin));
	}

	@Test
	public void testLength() {

		assertEquals("Pas la même longueur", this.buffer.length(), this.test.length());

	}
	
	@Test(expected=ErreurInsertionException.class)
	public void testExeption() throws ErreurInsertionException {
		this.buffer = new Buffer();
		longueur = MyRandom.randomInt(min, max);
		this.test = MyRandom.randomString(longueur);

		while (debut <= longueur) {
			debut = MyRandom.randomInt(min, max);
		}
		
		this.buffer.AddString(0, this.test);
		
		this.buffer.AddString(debut, this.test);
		
		
		

	}

}
