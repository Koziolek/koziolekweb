package pl.koziolekweb.guava.functions;

import com.google.common.base.Function;
import pl.koziolekweb.guava.FunctionExample;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Functions.compose;
import static com.google.common.base.Functions.forMap;
import static com.google.common.base.Functions.forPredicate;
import static com.google.common.base.Preconditions.checkNotNull;
import static pl.koziolekweb.guava.FunctionExample.Sex;
import static pl.koziolekweb.guava.functions.predicates.IsFemaleCase._IsFemaleCase;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 30.12.13
 * Time: 23:06
 * To change this template use File | Settings | File Templates.
 */
public class GetSexFromLastChar implements Function<Character, Sex> {

	private static final GetSexFromLastChar f = new GetSexFromLastChar();
	private final Map<Boolean,Sex> trueFalseMap;
	private final Function<Character,Sex> compose;

	private GetSexFromLastChar() {
		trueFalseMap = new HashMap<Boolean, Sex>();
		trueFalseMap.put(Boolean.TRUE, Sex.F);
		trueFalseMap.put(Boolean.FALSE, Sex.M);
		compose = compose(forMap(trueFalseMap),
				forPredicate(
						_IsFemaleCase()
				)
		);
	}

	public static GetSexFromLastChar _GetSexFromLastChar() {
		return f;
	}

	public static Sex getSexFromLastChar(Character input) {
		return f.apply(input);
	}

	@Override
	public Sex apply(Character input) {
		checkNotNull(input);
		return compose.apply(input);
	}
}
