package test_receiver;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import receiver.Buffer;
import receiver.EditeurSimple;
import receiver.ErreurInsertionException;

public class TestEditeurSimple {
	final int min;
	final int max;

	int debut;
	int fin;
	int longueur;
	String test;
	Buffer buffer;
	EditeurSimple edtsimple;
	public TestEditeurSimple() {

		this.min = 0;
		this.max = 5000;

	}

	@Before
	public void setUp() throws Exception {
		edtsimple = new EditeurSimple();
		debut = MyRandom.randomInt(min, max);
		this.edtsimple.charger("test1");


	}
	@Test
	public void test1Lecture() throws ErreurInsertionException {
		int init = this.edtsimple.toString().length();
		assertEquals("manque des choses",init,6844);

	}
	
	
	
	/*@Test(expected=FileNotFoundException.class)
	public void test2Charger() throws ErreurInsertionException {
		this.edtsimple.charger("dljqldjsqldij");
		

	}*/
	@Test
	public void test1Sauvegarder()  {
		this.edtsimple.sauvegarder("test2");
		File toto = new File("sauvegarde/test2.txt");
		assert(toto.exists());
			

	}

	@Test
	public void test1InsertionTexte() {
		int init = this.edtsimple.toString().length();
		char c = MyRandom.randomChar();
		this.edtsimple.selectionTexte(0, 0);
		this.edtsimple.insertionTexte(c);
		
		assertEquals("pas insérer",init+1,this.edtsimple.toString().length());
		assertEquals("pas le bon emplacement ou le bon char",this.edtsimple.toString().substring(0, 1).charAt(0),c);
	}
	@Test
	public void test2InsertionTexte()  {

		int init = this.edtsimple.toString().length();
		char c = MyRandom.randomChar();
		this.edtsimple.selectionTexte(debut, debut);
		this.edtsimple.insertionTexte(c);
		
		assertEquals("pas insérer",init+1,this.edtsimple.toString().length());
		assertEquals("pas le bon emplacement ou le bon char",this.edtsimple.toString().substring(debut, debut+1).charAt(0),c);
	}
	@Test
	public void test3InsertionTexte(){

		int init = this.edtsimple.toString().length();
		char c = MyRandom.randomChar();
		this.edtsimple.selectionTexte(15, 25);
		this.edtsimple.insertionTexte(c);
		
		assertEquals("pas insérer",init-10+1,this.edtsimple.toString().length());
		assertEquals("pas le bon emplacement ou le bon char",this.edtsimple.toString().substring(15, 16).charAt(0),c);
	}
	@Test
	public void test1CopierColler() {
		int init = this.edtsimple.toString().length();
		this.edtsimple.selectionTexte(0, 15);
		this.edtsimple.copier();
		this.edtsimple.selectionTexte(0, 15);
		this.edtsimple.coller();
		assertEquals("pourquoi ça à changer",init,this.edtsimple.toString().length());
	}
	
	@Test
	public void test2CopierColler() {
		int init = this.edtsimple.toString().length();
		this.edtsimple.selectionTexte(0, 0);
		this.edtsimple.copier();
		this.edtsimple.selectionTexte(0, 15);
		this.edtsimple.coller();
		assertEquals("pourquoi ça à changer",init,this.edtsimple.toString().length());
	}
	
	@Test
	public void test3CopierColler() {
		int init = this.edtsimple.toString().length();
		this.edtsimple.selectionTexte(0, 15);
		this.edtsimple.copier();
		this.edtsimple.selectionTexte(15, 15);
		this.edtsimple.coller();
		assertEquals("pourquoi ça à changer",init+15,this.edtsimple.toString().length());
	}
	
	@Test
	public void test1CouperColler() {
		int init = this.edtsimple.toString().length();
		this.edtsimple.selectionTexte(0, 15);
		this.edtsimple.couper();
		this.edtsimple.selectionTexte(0, 15);
		this.edtsimple.coller();
		assertEquals("pourquoi ça à changer",init-15,this.edtsimple.toString().length());
	}
	
	@Test
	public void test2CouperColler() {
		int init = this.edtsimple.toString().length();
		this.edtsimple.selectionTexte(0, 0);
		this.edtsimple.couper();
		this.edtsimple.selectionTexte(0, 15);
		this.edtsimple.coller();
		assertEquals("pourquoi ça à changer",init,this.edtsimple.toString().length());
	}
	
	@Test
	public void test3CouperColler() {
		int init = this.edtsimple.toString().length();
		this.edtsimple.selectionTexte(0, 15);
		this.edtsimple.couper();
		this.edtsimple.selectionTexte(15, 15);
		this.edtsimple.coller();
		assertEquals("pourquoi ça à changer",init,this.edtsimple.toString().length());
	}
	
	@Test
	public void test1Supprimer() {
		int init = this.edtsimple.toString().length();
		this.edtsimple.selectionTexte(0, 15);
		this.edtsimple.supprimer();;

		assertEquals("pourquoi ça à changer",init-15,this.edtsimple.toString().length());
	}
	
	@Test
	public void test2Supprimer() {
		int init = this.edtsimple.toString().length();
		this.edtsimple.selectionTexte(15, 15);
		this.edtsimple.supprimer();;

		assertEquals("pourquoi ça à changer",init-1,this.edtsimple.toString().length());
	}
	
	@Test
	public void test3Supprimer() {
		int init = this.edtsimple.toString().length();
		this.edtsimple.selectionTexte(0, 0);
		this.edtsimple.supprimer();;

		assertEquals("pourquoi ça à changer",init,this.edtsimple.toString().length());
	}
	
	@Test
	public void test4Supprimer() {
		int init = this.edtsimple.toString().length();
		this.edtsimple.selectionTexte(14, 15);
		this.edtsimple.supprimer();;
		assertEquals("pourquoi ça à changer",init-1,this.edtsimple.toString().length());
	}


}
