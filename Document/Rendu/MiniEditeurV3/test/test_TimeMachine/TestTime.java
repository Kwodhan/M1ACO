package test_TimeMachine;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import client.SimpleIHM;
import receiver.Buffer;

public class TestTime {

	final int min;
	final int max;

	int debut;
	int fin;
	int longueur;
	String test;
	Buffer buffer;
	SimpleIHM ihm;

	public TestTime() {

		this.min = 0;
		this.max = 5000;

	}

	@Before
	public void setUp()  {
		ihm = new SimpleIHM();
		ihm.pressCharger("test1");		
	}
	
	@Test
	public void test1UnDo() {
		int length = this.ihm.toString().length();
		this.ihm.pressUndo();
		
		assertEquals("on oublie des choses ?",0, this.ihm.toString().length());
		this.ihm.pressDo();
		assertEquals("on oublie des choses ?",length, this.ihm.toString().length());
	}
	
	@Test
	public void test2UnDo()  {
		int length = this.ihm.toString().length();
		this.ihm.pressInsertion('a');
		this.ihm.pressInsertion('b');
		this.ihm.pressInsertion('c');
		this.ihm.pressInsertion('d');
		this.ihm.pressInsertion('e');
		
		this.ihm.pressUndo();
		this.ihm.pressUndo();
		this.ihm.pressUndo();
		this.ihm.pressUndo();
		this.ihm.pressUndo();
		
		assertEquals("on oublie des choses ?",length, this.ihm.toString().length());
	}
	@Test
	public void test3UnDo()  {
		int length = this.ihm.toString().length();
		this.ihm.pressCharger("test3");
		int length2 = this.ihm.toString().length();
		this.ihm.pressUndo();
		assertEquals("on oublie des choses ?",length, this.ihm.toString().length());
		this.ihm.pressUndo();
		assertEquals("on oublie des choses ?",0, this.ihm.toString().length());
		this.ihm.pressDo();
		assertEquals("on oublie des choses ?",length, this.ihm.toString().length());
		this.ihm.pressDo();
		assertEquals("on oublie des choses ?",length2, this.ihm.toString().length());
	}
	@Test
	public void test4UnDo() {
		int length = this.ihm.toString().length();
		this.ihm.pressInsertion('a'); 	// changement : 1

		this.ihm.pressSelection(12, 0);
		this.ihm.pressCouper();			// changement : 2

		this.ihm.pressSelection(100, 100);
		this.ihm.pressSupprimer();		// changement : 3

		this.ihm.pressSelection(0, 100);
		this.ihm.pressSupprimer();		// changement : 4

		this.ihm.pressColler();			// changement : 5

		this.ihm.pressColler();			// changement : 6

		
		int length2 = this.ihm.toString().length();
		this.ihm.pressUndo();
		this.ihm.pressUndo();
		this.ihm.pressUndo();
		this.ihm.pressUndo();
		this.ihm.pressUndo();
		this.ihm.pressUndo();
		assertEquals("on oublie des choses ?",length, this.ihm.toString().length());
		
		this.ihm.pressDo();
		this.ihm.pressDo();
		this.ihm.pressDo();
		this.ihm.pressDo();
		this.ihm.pressDo();
		this.ihm.pressDo();
		
		assertEquals("on oublie des choses ?",length2, this.ihm.toString().length());
	}
	
	@Test
	public void test5UnDo()  {
		int length = this.ihm.toString().length();
		this.ihm.pressInsertion('a'); 	// changement : 1

		this.ihm.pressSelection(0, 0);
		this.ihm.pressCouper();			// changement : 1 // c'est un curseur dons pas de changement

		this.ihm.pressSelection(100, 100);
		this.ihm.pressSupprimer();		// changement : 2

		this.ihm.pressSelection(0, 100);
		this.ihm.pressSupprimer();		// changement : 3

		this.ihm.pressColler();			// changement : 3 // rien dans le curseur

		this.ihm.pressColler();			// changement : 3 // rien dans le curseur

		
			
		this.ihm.pressUndo();
		this.ihm.pressUndo();
		this.ihm.pressUndo();
		
		assertEquals("on oublie des choses ?",length, this.ihm.toString().length());
	}
	
	@Test
	public void test6UnDo()  {
		int length = this.ihm.toString().length();

		
		this.ihm.pressUndo();
		this.ihm.pressUndo();
		this.ihm.pressUndo();	
		this.ihm.pressUndo();
		this.ihm.pressUndo();
		this.ihm.pressUndo();
		
		
		assertEquals("on oublie des choses ?",0, this.ihm.toString().length());
		this.ihm.pressDo();
		assertEquals("on oublie des choses ?",length, this.ihm.toString().length());
		this.ihm.pressDo();
		this.ihm.pressDo();
		this.ihm.pressDo();
		this.ihm.pressDo();
		this.ihm.pressDo();
		this.ihm.pressDo();
		this.ihm.pressDo();
		assertEquals("on oublie des choses ?",length, this.ihm.toString().length());
	}
	

	@Test
	public void test7UnDo()  {
		int length = this.ihm.toString().length();
		this.ihm.pressInsertion('a'); 	// changement : 1

		this.ihm.pressSelection(12, 0);
		this.ihm.pressCouper();			// changement : 2

		this.ihm.pressSelection(100, 100);
		this.ihm.pressSupprimer();		// changement : 3

		this.ihm.pressSelection(0, 100);
		this.ihm.pressSupprimer();		// changement : 4

		this.ihm.pressColler();			// changement : 5

		this.ihm.pressColler();			// changement : 6
		
		this.ihm.pressSelection(34, 57);
		this.ihm.pressCopier();			// changement : 6
		
		this.ihm.pressSelection(56, 56);
		this.ihm.pressInsertion('a');	// changement : 7
		this.ihm.pressInsertion('b');	// changement : 8
		this.ihm.pressInsertion('a');	// changement : 9
		this.ihm.pressInsertion('b');	// changement : 10
		this.ihm.pressSupprimer();		// changement : 11
		int length2 = this.ihm.toString().length();
		for(int i =0;i<11;i++)
			this.ihm.pressUndo();
		assertEquals("on oublie des choses ?",length, this.ihm.toString().length());
		
		for(int i =0;i<11;i++)
			this.ihm.pressDo();
		
		assertEquals("on oublie des choses ?",length2, this.ihm.toString().length());
	}
	
	

}
