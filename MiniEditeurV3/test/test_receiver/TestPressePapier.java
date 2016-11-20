package test_receiver;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import receiver.PressePapier;

public class TestPressePapier {
	private PressePapier pp;
	private String test;

	public TestPressePapier() {
		
	}
	@Before
	public void setUp() throws Exception {
		
		pp = new PressePapier();
		test = MyRandom.randomString(5000);

	}
	
	

	
	@Test

	public void testSetGetPresse() {	
		pp.setPresse(test);	
		assertEquals("Le StringBuffer est incorrect", test, pp.getPresse());
		

	}

	@Test
	public void testLength() {
		pp.setPresse(test);
		assertEquals("Pas la même longueur",test.length(),pp.length());
	}

}
