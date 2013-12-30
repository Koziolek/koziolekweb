package pl.koziolekweb.guava.functions;

import com.google.common.base.Function;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 30.12.13
 * Time: 21:14
 * To change this template use File | Settings | File Templates.
 */
public class ToUpperCase implements Function<String, String> {

	private static ToUpperCase function = new ToUpperCase();

	public static ToUpperCase _ToUpperCase(){
		return function;
	}

	public static String toUpperCase(String input) {
		return function.apply(input);
	}

	@Override
	public String apply(String input) {
		if (input == null)
			return null;
		return input.toUpperCase();
	}

}
