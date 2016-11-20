package test_receiver;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import receiver.Buffer;
import receiver.EditeurSimple;
import receiver.ErreurInsertionException;
import receiver.ItfMoteurEditeur;

public class TestEditeurSimple {
	final int min;
	final int max;

	int debut;
	int fin;
	int longueur;
	ItfMoteurEditeur moteur;
	String test;
	Buffer buffer;
	public TestEditeurSimple() {

		this.min = 0;
		this.max = 5000;

	}

	@Before
	public void setUp() throws Exception {
		/*buffer = new Buffer();

		longueur = MyRandom.randomInt(min, max);
		this.test = MyRandom.randomString(longueur);

		buffer.AddString(0, this.test);
		moteur = new EditeurSimple();
		moteur.setBuffer(buffer);
		debut = MyRandom.randomInt(min, max);

		fin = MyRandom.randomInt(min, max);*/

	}

	@Test
	public void testCopier() {
		this.moteur.selectionTexte(debut, fin);
		this.moteur.copier();
		//assertEquals("pas le bon string copier",this.buffer.substring(debut, fin),);
	}

	@Test
	public void testInsertionTexte() throws ErreurInsertionException {
		int init = this.buffer.length();
		char c = MyRandom.randomChar();
		this.moteur.selectionTexte(0, 0);
		this.moteur.insertionTexte(c);
		
		assertEquals("pas insérer",init+1,this.buffer.length());
		assertEquals("pas le bon emplacement ou le bon char",this.buffer.substring(0, 1).charAt(0),c);
	}

	@Test
	public void testColler() {
		/*this.moteur.selectionTexte(debut, fin);
		this.moteur.copier();
		this.moteur.selectionTexte(My, fin);
		this.moteur.coller();*/
	}

	@Test
	public void testSelectionTexte() {
		this.moteur.selectionTexte(debut,fin);
	}

}
