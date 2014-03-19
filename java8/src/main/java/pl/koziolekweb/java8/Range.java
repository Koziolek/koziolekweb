package pl.koziolekweb.java8;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class Range implements Iterator<Integer> {

	private int step;
	private int current;
	private int min;
	private int max;

	public Range(int min, int max) {
		this.min = min;
		this.max = max;
		this.step = 1;
		this.current = min - step;
	}

	@Override
	public boolean hasNext() {
		return current < max;
	}

	@Override
	public Integer next() {
		current += step;
		return current;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("Spierdalaj");
	}

	@Override
	public void forEachRemaining(Consumer<? super Integer> action) {
		throw new UnsupportedOperationException("Znajdź se murzyna");
	}
}
