package pl.koziolekweb.java8.lambda;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;
import pl.koziolekweb.java8.Range;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.fest.assertions.Assertions.assertThat;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class SimpleLambda {

	public static final int X = 100;
	public static final int MAX = 100000 * X;
	public static final int MORE_THAN = 10000 * X;
	public static final int EXPECTED = 90000 * X;
	private final ArrayList<Integer> range;

	public SimpleLambda() {
		range = Lists.newArrayList(new Range(1, MAX));
		Collections.shuffle(range);
	}

	@Test
	public void lambdaExample() {
		List<Integer> collect = range.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
		assertThat(collect.get(0) % 2).isEqualTo(0);
	}



}

