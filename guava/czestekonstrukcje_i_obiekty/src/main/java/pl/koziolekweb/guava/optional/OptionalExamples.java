package pl.koziolekweb.guava.optional;

import com.google.common.base.Optional;
import com.google.common.collect.Maps;

import java.util.Map;

import static com.google.common.base.Optional.fromNullable;
import static com.google.common.base.Optional.of;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class OptionalExamples {

	public static final int DEFAULT_INT = -1;
	Map<Object, Object> map = Maps.newHashMap();

	public Map<Object, Object> getMap() {
		return map;
	}

	public void addToMap(Object k, Object v) {
		k = fromNullable(k).or("null");
		map.put(k, v);
	}

	public Integer forceNPE(Integer param) {
		Optional<Integer> oParam = of(param);
		return oParam.get();
	}

	public Integer supressNPE(Integer param) {
		Optional<Integer> oParam = fromNullable(param);
		return oParam.or(DEFAULT_INT);
	}

}
