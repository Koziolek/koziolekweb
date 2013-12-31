package pl.koziolekweb.guava;

import com.google.common.base.Predicate;

import static com.google.common.base.Predicates.compose;
import static pl.koziolekweb.guava.functions.LastCharacter._LastCharacter;
import static pl.koziolekweb.guava.functions.predicates.IsFemaleLowerCase._IsFemaleLowerCase;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 29.12.13
 * Time: 19:28
 * To change this template use File | Settings | File Templates.
 */
public class PredicateExample {

	public static void main(String[] args) {
		Predicate<String> isFemaleLCFromString
				= compose(_IsFemaleLowerCase(), _LastCharacter());
		System.out.println(isFemaleLCFromString.apply("Ala"));
	}

}
