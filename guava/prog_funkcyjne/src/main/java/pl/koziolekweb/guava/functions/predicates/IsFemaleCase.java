package pl.koziolekweb.guava.functions.predicates;

import com.google.common.base.Predicate;

import static com.google.common.base.Predicates.or;
import static pl.koziolekweb.guava.functions.predicates.IsFemaleLowerCase._IsFemaleLowerCase;
import static pl.koziolekweb.guava.functions.predicates.IsFemaleUpperCase._IsFemaleUpperCase;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 31.12.13
 * Time: 16:51
 * To change this template use File | Settings | File Templates.
 */
public class IsFemaleCase implements Predicate<Character> {

	private static final IsFemaleCase f = new IsFemaleCase();

	private Predicate<Character> or = or(_IsFemaleLowerCase(), _IsFemaleUpperCase());

	public static IsFemaleCase _IsFemaleCase() {
		return f;
	}

	public static boolean isFemaleCase(Character input) {
		return f.apply(input);
	}

	@Override
	public boolean apply(Character input) {
		return or.apply(input);
	}
}
