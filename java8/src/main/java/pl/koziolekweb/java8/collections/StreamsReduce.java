package pl.koziolekweb.java8.collections;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;
import pl.koziolekweb.java8.Range;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class StreamsReduce {

	private final List<Integer> range;
	public static final int X = 1;
	public static final int MAX = 10 * X;


	public StreamsReduce() {
		range = Lists.newArrayList(new Range(1, MAX));
		Collections.shuffle(range);
	}

	@Test
	public void reduceExample() {
		Integer reduce = range.stream().reduce(0, (a, b) -> a + b);
		System.out.println(reduce);
	}

	@Test
	public void sortReduceExample() {
		Integer reduce = range.stream()
				.sorted()
				.reduce(1, (a, b) -> a * b);
		System.out.println(reduce);
	}

	@Test
	public void sortDistinctCount() {
		List<Integer> duplicate = range.stream().map(x -> x).collect(Collectors.toList());
		duplicate.addAll(range);
		long reduce = duplicate.stream()
				.distinct()
				.count();
		System.out.println(reduce);
	}

}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
@Repeatable(Specki.class)
@interface Specka {

}


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
@interface Specki {
	Specka[] value();
}