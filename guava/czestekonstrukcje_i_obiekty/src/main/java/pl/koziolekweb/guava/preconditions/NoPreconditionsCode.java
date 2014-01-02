package pl.koziolekweb.guava.preconditions;

/**
 * User: koziolek
 */
public class NoPreconditionsCode {

	public void method(String param1, Integer param2) {
		if (param1 == null)
			throw new NullPointerException("Param1 can not be null");
		if (param2 == null)
			throw new NullPointerException("Param2 can not be null");
		if (param1.isEmpty())
			throw new IllegalArgumentException("Param 1 can not be empty");
		if (param2 > 0)
			throw new IllegalArgumentException("Param 2 can not be <=0");

		// rest of code
	}
}
