package pl.koziolekweb.guava.functions;

import com.google.common.base.Function;
import pl.koziolekweb.guava.FunctionExample;

import static com.google.common.base.Functions.compose;
import static pl.koziolekweb.guava.FunctionExample.Sex;
import static pl.koziolekweb.guava.functions.GetSexFromLastChar._GetSexFromLastChar;
import static pl.koziolekweb.guava.functions.LastCharacter._LastCharacter;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 31.12.13
 * Time: 17:11
 * To change this template use File | Settings | File Templates.
 */
public class GetSexFromName implements Function<String, Sex> {

	private static final GetSexFromName f = new GetSexFromName();

	private final Function<String,Sex> compose;

	private GetSexFromName() {
		compose = compose(_GetSexFromLastChar(), _LastCharacter());
	}

	public static GetSexFromName _GetSexFromName() {
		return f;
	}

	public static Sex getSexFromName(String input) {
		return f.apply(input);
	}


	@Override
	public Sex apply(String input) {
		return compose.apply(input);
	}
}
