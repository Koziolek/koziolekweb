package pl.koziolekweb.guava.functions;

import com.google.common.base.Function;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 30.12.13
 * Time: 23:10
 * To change this template use File | Settings | File Templates.
 */
public class LastCharacter implements Function<String, Character> {

	private static final LastCharacter f = new LastCharacter();

	public static LastCharacter _LastCharacter() {
		return f;
	}

	public static Character lastCharacter(String input) {
		return f.apply(input);
	}

	@Override
	public Character apply(String input) {
		checkNotNull(input);
		checkArgument(input.length() > 0);
		return input.charAt(input.length() - 1);
	}
}
