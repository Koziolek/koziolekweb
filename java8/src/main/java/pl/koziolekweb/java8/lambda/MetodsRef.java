package pl.koziolekweb.java8.lambda;

import com.google.common.collect.Lists;
import org.testng.annotations.BeforeTest;
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
public class MetodsRef {

	private List<Human> humans;

	public static final int X = 100;
	public static final int MAX = 100000 * X;
	private final ArrayList<Integer> range;

	public MetodsRef() {
		range = Lists.newArrayList(new Range(1, MAX));
		Collections.shuffle(range);
	}


	@BeforeTest
	public void setup() {
		humans = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			humans.add(new Man());
		}
		for (int i = 0; i < 50; i++)
			humans.add(new Woman());

		Collections.shuffle(humans);
	}

	@Test
	public void ref() {
        Human human = humans.get(0);
        assertThat(
                humans.stream()
                        .filter(human::isM)
                        .count()
        )
				.isEqualTo(50);

	}

	@Test
	public void refConst() {
		assertThat(
				humans.stream()
						.filter(Human::isMan)
						.count()
		)
				.isEqualTo(50);

	}

	public static boolean isEvenStatic(Integer x) {
//		if(x == 15633) throw new NullPointerException();
		return x % 2 == 0;
	}

	public boolean isEvenNonStatic(Integer x) {
		return x % 2 == 0;
	}


	@Test
	public void lambdaStaticMathodRef() {
		List<Integer> collect = range.stream().filter(MetodsRef::isEvenStatic).collect(Collectors.toList());
		assertThat(collect.get(0) % 2).isEqualTo(0);
	}

	@Test
	public void lambdaNonStaticMathodRef() {
		List<Integer> collect = range.stream().filter(this::isEvenNonStatic).collect(Collectors.toList());
		assertThat(collect.get(0) % 2).isEqualTo(0);
	}
}


class Human {

	private Sex sex;

	Human(Sex sex) {
		this.sex = sex;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public boolean isMan() {
		return sex == Sex.M;
	}
	public boolean isM(Human h) {
		return sex == Sex.M;
	}

    public static  boolean ISM(Human h){return h.isMan();}
}

class Man extends Human {
	Man() {
		super(Sex.M);
	}
}

class Woman extends Human {
	Woman() {
		super(Sex.F);
	}
}

enum Sex {
	F, M
}