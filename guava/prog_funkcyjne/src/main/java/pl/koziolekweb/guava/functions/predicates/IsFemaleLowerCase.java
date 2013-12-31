package pl.koziolekweb.guava.functions.predicates;

import com.google.common.base.Predicate;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 31.12.13
 * Time: 13:53
 * To change this template use File | Settings | File Templates.
 */
public class IsFemaleLowerCase implements Predicate<Character> {

	private static final IsFemaleLowerCase f = new IsFemaleLowerCase();

	public static IsFemaleLowerCase _IsFemaleLowerCase() {
		return f;
	}

	public static Boolean isFemaleLowerCase(Character input) {
		return f.apply(input);
	}


	@Override
	public boolean apply(Character input) {
		checkNotNull(input);
		return input.charValue() == 'a';
	}
}
