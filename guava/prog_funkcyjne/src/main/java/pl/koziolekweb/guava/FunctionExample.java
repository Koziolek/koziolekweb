package pl.koziolekweb.guava;

import com.google.common.base.Function;

import static com.google.common.base.Functions.compose;
import static pl.koziolekweb.guava.functions.GetSexFromLastChar._GetSexFromLastChar;
import static pl.koziolekweb.guava.functions.LastCharacter._LastCharacter;

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
	}

	public enum Sex {
		M, F;
	}
}

