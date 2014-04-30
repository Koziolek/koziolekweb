package pl.koziolekweb.java8.collections;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.fest.assertions.Assertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pl.koziolekweb.java8.Range;

import java.util.*;
import java.util.stream.Collectors;

import static com.google.common.base.Predicates.and;
import static org.fest.assertions.Assertions.assertThat;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
@Test()
@Listeners(StatsListener.class)
public class CollectionsStreams {

	public static final int X = 1000;
	public static final int MAX = 100000 * X;
	public static final int MORE_THAN = 10000 * X;
    public static final int IC = 5;
    private final ArrayList<Integer> range;
	private final Predicate<Integer> predicateGt = (x) -> x > MORE_THAN;
	private final Predicate<Integer> predicateMod = (x) -> x % 3 == 0;
	private final Predicate<Integer> predicate = and(predicateGt, predicateMod);

	public CollectionsStreams() {
		range = Lists.newArrayList(new Range(1, MAX));
		Collections.shuffle(range);
	}

	@Test(invocationCount = IC)
	public void simpleLoop() throws Exception {
		List<Integer> filtered = new LinkedList<>();
		for (int i = 0; i < range.size(); i++) {
			Integer x = range.get(i);
			if (x > MORE_THAN && x % 3 == 0)
				filtered.add(x);
		}
	}

	@Test(invocationCount = IC)
	public void simpleLoopArrayList() throws Exception {
		List<Integer> filtered = new ArrayList<>();
		for (int i = 0; i < range.size(); i++) {
			Integer x = range.get(i);
			if (x > MORE_THAN && x % 3 == 0)
				filtered.add(x);
		}
	}

	@Test(invocationCount = IC)
	public void simpleLoopSizedArrayList() throws Exception {
		List<Integer> filtered = new ArrayList<>(MAX);
		for (int i = 0; i < range.size(); i++) {
			Integer x = range.get(i);
			if (x > MORE_THAN && x % 3 == 0)
				filtered.add(x);
		}
	}

	@Test(invocationCount = IC)
	public void simpleTransformStream() {
		List<Integer> over10000 = range.stream()
				.filter((x) -> x > MORE_THAN)
				.filter(x -> x % 3 == 0)
				.collect(Collectors.toList());
	}

	@Test(invocationCount = IC)
	public void simpleTransformParallelStream() {
		List<Integer> over10000 = range.parallelStream()
				.filter((x) -> x > MORE_THAN)
				.filter(x -> x % 3 == 0)
				.collect(Collectors.toList());
	}

	@Test(invocationCount = IC)
	public void simpleTransformGuava() {
		Collection<Integer> over10000 = Collections2
				.filter(range, predicate);
		over10000.size();
	}




}


