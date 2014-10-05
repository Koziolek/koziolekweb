package pl.koziolekweb.java8.collections;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;
import pl.koziolekweb.java8.Range;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

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

	@Test
	public void flatMapExample() throws IOException {
		String s = "Ala ma kota";
		List<String> words = asList(s.split(" +"));
		long count = words.stream()
				.flatMap((x) -> asList(x.split("")).stream().sorted())
				.count();
		System.out.println(count);
//
//		Files.readAllLines(new File("out.txt").toPath()).stream()
//				.filter(x -> !x.isEmpty())
//				.forEach(x -> System.out.println(x));

	}
}


















