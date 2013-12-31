package pl.koziolekweb.guava;

import com.google.common.base.Function;

import static com.google.common.base.Functions.compose;
import static com.google.common.base.Functions.forPredicate;
import static pl.koziolekweb.guava.functions.GetSexFromLastChar._GetSexFromLastChar;
import static pl.koziolekweb.guava.functions.LastCharacter._LastCharacter;
import static pl.koziolekweb.guava.functions.predicates.IsFemaleLowerCase._IsFemaleLowerCase;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 29.12.13
 * Time: 19:29
 * To change this template use File | Settings | File Templates.
 */
public class FunctionExample {

	public static void main(String[] args) {
		Function<String, Sex> sexFromString =
				compose(_GetSexFromLastChar(),
						_LastCharacter());
		System.out.println(sexFromString.apply("Ala"));
		Function<Character, Boolean> isFemaleFromChar = forPredicate(_IsFemaleLowerCase());
		Function<String, Boolean> isFemaleFormString = compose(isFemaleFromChar, _LastCharacter());
		System.out.println(isFemaleFormString.apply("Ala"));




	}

	public enum Sex {
		M, F;
	}
}

