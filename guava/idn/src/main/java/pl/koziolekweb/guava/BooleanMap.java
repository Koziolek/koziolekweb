package pl.koziolekweb.guava;

import com.google.common.base.Function;
import com.google.common.collect.Maps;

import java.util.HashMap;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
class BooleanMap<O> implements Function<Boolean, O> {

	private static final BooleanMap<String> yesNo = new BooleanMap<String>("yes", "no");
	private static final BooleanMap<String> validInvalid = new BooleanMap<String>("valid", "invalid");
	private static final BooleanMap<String> equalNotEqual = new BooleanMap<String>("equal", "not equal");

	public static final String yesNo(Boolean b) {
		return yesNo.apply(b);
	}

	public static final String validInvalid(Boolean b) {
		return validInvalid.apply(b);
	}

	public static final String equalNotEqual(Boolean b) {
		return equalNotEqual.apply(b);
	}

	private HashMap<Boolean, O> map;

	public BooleanMap(O whenTrue, O whenFalse) {
		map = Maps.newHashMap();
		map.put(Boolean.TRUE, whenTrue);
		map.put(Boolean.FALSE, whenFalse);
	}

	@Override
	public O apply(Boolean input) {
		return map.get(input);
	}
}
