package pl.koziolekweb.guava.ordering;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Arrays.copyOfRange;
import static java.util.Arrays.toString;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class OrderingExamples {

	public static void main(String[] args) {
		Ordering<Name> forName = Ordering.natural();
		// not complie - Mongy is not Comparable
		Ordering<Object> forMongy = Ordering.allEqual();

		Ordering<String> wyrazy =  Ordering.natural();
		List<String> nub = Lists.newArrayList("1", "3", "2");
		ImmutableList<String> numb2 = wyrazy.immutableSortedCopy(nub);
		nub.remove(1);
		System.out.println(numb2.size());

	}


}

class Name implements Comparable<Name> {

	public final String value;

	Name(String value) {
		this.value = value;
	}

	@Override
	public int compareTo(Name o) {
		return value.compareTo(o.value);
	}
}

class Mongy {

	public final String value;

	Mongy(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Mongy{" +
				"value='" + value + '\'' +
				'}';
	}
}