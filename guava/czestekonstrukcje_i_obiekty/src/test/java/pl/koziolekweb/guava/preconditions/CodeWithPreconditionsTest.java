package pl.koziolekweb.guava.preconditions;

import org.testng.annotations.Test;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class CodeWithPreconditionsTest {

	CodeWithPreconditions cwp = new CodeWithPreconditions();

	@Test(expectedExceptions = NullPointerException.class)
	public void testMethodNullParam1() throws Exception {
		cwp.method(null, 1);

	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testMethodEmptyParam1() throws Exception {
		cwp.method("", 1);
	}

	@Test
	public void testMethod2() throws Exception {
		cwp.method2("al");
	}
}
