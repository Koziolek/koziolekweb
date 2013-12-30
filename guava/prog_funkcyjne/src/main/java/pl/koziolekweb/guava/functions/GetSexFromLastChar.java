package pl.koziolekweb.guava.functions;

import com.google.common.base.Function;

import static com.google.common.base.Preconditions.checkNotNull;
import static pl.koziolekweb.guava.FunctionExample.Sex;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 30.12.13
 * Time: 23:06
 * To change this template use File | Settings | File Templates.
 */
public class GetSexFromLastChar implements Function<Character, Sex> {

	private static final GetSexFromLastChar f = new GetSexFromLastChar();

	public static GetSexFromLastChar _GetSexFromLastChar() {
		return f;
	}

	public static Sex getSexFromLastChar(Character input) {
		return f.apply(input);
	}

	@Override
	public Sex apply(Character input) {
		checkNotNull(input);
		return input.compareTo('a') == 0 ? Sex.F : Sex.M;
	}
}
