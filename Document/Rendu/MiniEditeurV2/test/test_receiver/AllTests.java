package test_receiver;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test_enregistrement.TestEnregistrement;

@RunWith(Suite.class)
@SuiteClasses({ TestEnregistrement.class,TestEditeurSimple.class,TestEnregistrement.class })
public class AllTests {
	 
}
