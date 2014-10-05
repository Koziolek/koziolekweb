package pl.koziolekweb.guava;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class App {

	public static void main(String[] args) {
		FileIterable fileIterable = new FileIterable("/home/koziolek/test.csv");

		FluentIterable<String> transform = FluentIterable.from(fileIterable).transform(x -> {
			System.out.println(x);
			return x;
		});
		ImmutableList<String> strings = transform.toList();
		System.out.println(strings);
	}
}
