package test_receiver;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test_TimeMachine.TestTime;
import test_TimeMachine.TestTimeMacro;
import test_enregistrement.TestEnregistrement;

@RunWith(Suite.class)
@SuiteClasses({TestTime.class,TestTimeMacro.class,TestEnregistrement.class, TestEditeurSimple.class,TestEnregistrement.class })
public class AllTests {
	 
}
