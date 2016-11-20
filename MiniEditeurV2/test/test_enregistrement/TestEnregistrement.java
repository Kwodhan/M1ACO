package test_enregistrement;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import client.SimpleIHM;
import receiver.Buffer;
import receiver.ErreurInsertionException;

public class TestEnregistrement {
	final int min;
	final int max;

	int debut;
	int fin;
	int longueur;
	String test;
	Buffer buffer;
	SimpleIHM ihm;

	public TestEnregistrement() {

		this.min = 0;
		this.max = 5000;

	}

	@Before
	public void setUp() throws Exception {
		ihm = new SimpleIHM();
		ihm.pressCharger("test1");		
	}
	
	@Test
	public void test1Macro() throws ErreurInsertionException {
		int length = this.ihm.toString().length();
		this.ihm.pressDebut();
		this.ihm.pressSelection(0, 0);
		this.ihm.pressInsertion('c');
		this.ihm.pressStop();
		for(int i=0;i<10;i++)
			this.ihm.pressRejouer();
		
		assertEquals("on oublie des choses ?",length+11, this.ihm.toString().length());
		

	}
	
	@Test
	public void test2Macro()  {
		int length = this.ihm.toString().length();
		this.ihm.pressDebut();
		this.ihm.pressSelection(0, 0);
		this.ihm.pressInsertion('c');
		this.ihm.pressDebut();
		this.ihm.pressSelection(0, 0);
		this.ihm.pressInsertion('c');
		this.ihm.pressStop();
		this.ihm.pressStop();
		for(int i=0;i<10;i++)
			this.ihm.pressRejouer();
		
		assertEquals("on oublie des choses ?",length+12, this.ihm.toString().length());
		

	}
	
	@Test
	public void test3Macro() {
		int length = this.ihm.toString().length();
		this.ihm.pressDebut();
		this.ihm.pressSelection(0, 10);
		this.ihm.pressCopier();
		this.ihm.pressSelection(10, 10);
		this.ihm.pressColler();
		this.ihm.pressStop();
		for(int i=0;i<5;i++)
			this.ihm.pressRejouer();
		
		assertEquals("on oublie des choses ?",length+6*10, this.ihm.toString().length());
		

	}
	
	@Test
	public void test4Macro() {
		int length = this.ihm.toString().length();
		this.ihm.pressDebut();
		this.ihm.pressSelection(0, 10);
		this.ihm.pressCopier();
		this.ihm.pressSelection(10, 10);
		this.ihm.pressColler();
		this.ihm.pressStop();
		for(int i=0;i<5;i++)
			this.ihm.pressRejouer();
		
		assertEquals("on oublie des choses ?",length+6*10, this.ihm.toString().length());
		

	}
	/* xs = reste du buffer
	 * $ = selection
	 * $a$xs
	 * a$xs
	 * aa$xs
	 * aaa$xs
	 * aaaa$xs
	 * aaaaa$xs
	 * aaaaaa$xs
	 */
	@Test
	public void test5Macro() {
		int length = this.ihm.toString().length();
		this.ihm.pressSelection(0, 1);
		this.ihm.pressCopier();
		
		this.ihm.pressDebut();
		
		this.ihm.pressColler();
		this.ihm.pressStop();
		for(int i=0;i<5;i++)
			this.ihm.pressRejouer();
		
		assertEquals("on oublie des choses ?",length+5, this.ihm.toString().length());
		

	}
	/*
	 * xs$
	 */
	@Test
	public void test6Macro() {
		int length = this.ihm.toString().length();
		this.ihm.pressSelection(length, length);
		this.ihm.pressDebut();
		this.ihm.pressSupprimer();
		this.ihm.pressCouper();
		this.ihm.pressStop();
		for(int i=0;i<length;i++)
			this.ihm.pressRejouer();
		
		assertEquals("on oublie des choses ?",0, this.ihm.toString().length());
		

	}
	
	/*
	 * xs$
	 */
	@Test
	public void test7Macro() {
		int length = this.ihm.toString().length();
		this.ihm.pressDebut();
		this.ihm.pressCharger("test2");
		this.ihm.pressStop();
		for(int i=0;i<length;i++)
			this.ihm.pressRejouer();
		
		assertEquals("on oublie des choses ?",0, this.ihm.toString().length());
		

	}

}
