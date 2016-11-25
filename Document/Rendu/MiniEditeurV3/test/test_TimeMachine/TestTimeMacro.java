package test_TimeMachine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import client.SimpleIHM;
import receiver.Buffer;
/*
 * Rappel : Les macros ne sont pas enregistrer dans la timeMachine
 * 			Les undo et do ne sont pas enregistrer dans les macros
 */
public class TestTimeMacro {
	final int min;
	final int max;

	int debut;
	int fin;
	int longueur;
	String test;
	Buffer buffer;
	SimpleIHM ihm;

	public TestTimeMacro() {

		this.min = 0;
		this.max = 5000;

	}

	@Before
	public void setUp()  {
		ihm = new SimpleIHM();
		
	}
	@Test
	public void test1TimeMacro() {
		int length = this.ihm.toString().length();
		
		this.ihm.pressDebut();
		this.ihm.pressInsertion('a');
		this.ihm.pressUndo();
		this.ihm.pressStop();
		
		assertEquals("on oublie des choses ?",length, this.ihm.toString().length());
		
		this.ihm.pressRejouer();
		
		assertEquals("on oublie des choses ?",length+1, this.ihm.toString().length());
	}
	
	@Test
	public void test2TimeMacro() {
		
		this.ihm.pressDebut();
		this.ihm.pressInsertion('a'); 	// 1
		this.ihm.pressUndo();			// 0
		this.ihm.pressInsertion('b');	// 1
		this.ihm.pressUndo();			// 0
		this.ihm.pressDo();				// 1
		this.ihm.pressStop();
		
		assertEquals("on oublie des choses ?",1, this.ihm.toString().length());
		
		this.ihm.pressRejouer();
		
		assertEquals("on oublie des choses ?",3, this.ihm.toString().length());
	}
	
	@Test
	public void test3TimeMacro() {
		
		this.ihm.pressDebut();
		this.ihm.pressInsertion('a'); 	
		this.ihm.pressStop();
		
		assertEquals("on oublie des choses ?",1, this.ihm.toString().length());
		this.ihm.pressUndo();
		assertEquals("on oublie des choses ?",0, this.ihm.toString().length());
		this.ihm.pressRejouer();
		assertEquals("on oublie des choses ?",1, this.ihm.toString().length());
		this.ihm.pressRejouer();
		assertEquals("on oublie des choses ?",2, this.ihm.toString().length());
		this.ihm.pressRejouer();
		assertEquals("on oublie des choses ?",3, this.ihm.toString().length());
	}

}
