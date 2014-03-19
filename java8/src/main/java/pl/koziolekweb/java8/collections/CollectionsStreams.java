package pl.koziolekweb.java8.collections;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.testng.annotations.Test;
import pl.koziolekweb.java8.Range;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.fest.assertions.Assertions.assertThat;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class CollectionsStreams {


	public static final int X = 100;
	public static final int MAX = 100000 * X;
	public static final int MORE_THAN = 10000 * X;
	public static final int EXPECTED = 90000 * X;
	private final ArrayList<Integer> range;

	public CollectionsStreams() {
		range = Lists.newArrayList(new Range(1, MAX));
		Collections.shuffle(range);
	}

	@Test
	public void simpleTransformStream() {
		List<Integer> over10000 = range.stream().filter((x) -> x > MORE_THAN).collect(Collectors.toList());
		assertThat(over10000).hasSize(EXPECTED);
	}

	@Test
	public void simpleTransformParallelStream() {
		List<Integer> over10000 = range.parallelStream().filter((x) -> x > MORE_THAN).collect(Collectors.toList());
		assertThat(over10000).hasSize(EXPECTED);
	}

	@Test
	public void simpleTransformGuava() {
		Collection<Integer> over10000 = Collections2.filter(range, (x) -> x > MORE_THAN);
		assertThat(over10000).hasSize(EXPECTED);
	}

	@Test
	public void simpleTransformStreamNPE() {
		List<Integer> over10000 = range.stream().filter((x) -> {
			if (x == 3) throw new NullPointerException();
			return x > MORE_THAN;
		}).collect(Collectors.toList());
		assertThat(over10000).hasSize(EXPECTED);
	}

	@Test
	public void simpleTransformGuavaNPE() {
		Collection<Integer> over10000 = Collections2.filter(range, (x) -> {
			if (x == 3) throw new NullPointerException();
			return x > MORE_THAN;
		});
		assertThat(over10000).hasSize(EXPECTED);
	}
}
