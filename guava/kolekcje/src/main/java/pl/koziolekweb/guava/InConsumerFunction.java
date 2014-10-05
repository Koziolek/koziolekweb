package pl.koziolekweb.guava;

import com.google.common.base.Function;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class InConsumerFunction<I> implements Function<I, I> {

	private final Consumer<I> consumer;

	public InConsumerFunction(Consumer<I> consumer) {
		this.consumer = consumer;
	}

	@Override
	public I apply(I input) {
		consumer.consume(input);
		return input;
	}
}
