package test_receiver;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestMain {

	@Test
	public void test() {
		boolean good = true;

		for (int i = 0; i < 10; i++) {
			Result result = JUnitCore.runClasses(AllTests.class);
			for (Failure fail : result.getFailures()) {
				System.out.println(fail.toString());
				good=false;
			}

		}
		
		if (good) {
			System.out.println("All tests finished successfully");
		} else {
			System.out.println("fails");
		}
	}

}
