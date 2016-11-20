package test_receiver;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestBuffer.class,  TestPressePapier.class, TestSelection.class })
public class AllTests {
	 
}
