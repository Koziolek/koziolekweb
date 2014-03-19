package pl.koziolekweb.java8.collections;

import com.google.common.collect.Lists;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pl.koziolekweb.java8.Range;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class ArraysParallelSort {

	public static final int MAX = 10000;
	private List<Integer> range;
	private Integer[] array;

	public ArraysParallelSort() {
		range = Lists.newArrayList(new Range(1, MAX));
		Collections.shuffle(range);
	}

	@Test
	public void apiSort() {
		array = range.toArray(new Integer[range.size() - 1]);
		Arrays.sort(array);
	}

	@Test
	public void apiParallelSort() {
		array = range.toArray(new Integer[range.size() - 1]);
		Arrays.parallelSort(array);
	}

}
