package pl.koziolekweb.guava.badthings;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;

import java.util.ArrayList;

import static com.google.common.collect.Lists.newArrayList;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class BadThingsApp {

	public static void main(String[] args) {
		ArrayList<Person> persons = newArrayList(
				new Person("Ala"),
				new Person("Ania"),
				new Person("Zenon"),
				new Person("Gustawa"));
		persons.stream()
				.map(Person::name)
				.filter(n -> n.lastIndexOf('a') == n.length() - 1)
				.forEach(System.out::println);

		System.out.println("******************");

		FluentIterable.from(persons)
				.transform(Person.fname())
				.filter(new Predicate<String>() {
					@Override
					public boolean apply(String input) {
						return input.lastIndexOf('a') == input.length() - 1;
					}
				})
				.transform(new Function<String, String>() {
					@Override
					public String apply(String input) {
						System.out.println(input);
						return input;
					}
				}).size();
	}
}


class Person {
	public static final Function<Person, String> F_NAME = new Function<Person, String>() {
		@Override
		public String apply(Person input) {
			return input.name;
		}
	};
	final String name;

	Person(String name) {
		this.name = name;
	}

	public String name() {
		return name;
	}

	public static final Function<Person, String> fname(){
		return F_NAME;
	}
}