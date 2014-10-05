package pl.koziolekweb.guava;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public abstract class AbstractDecorator<I, O> implements Function<I, O> {

	protected final Function<I, O> originalFunction;

	protected AbstractDecorator(Function<I, O> originalFunction) {
		checkNotNull(originalFunction);
		this.originalFunction = originalFunction;
	}

	protected abstract void before(I input);

	protected abstract void after(I input, O output);

	@Override
	public O apply(I input) {
		before(input);
		O output = originalFunction.apply(input);
		after(input, output);
		return output;
	}
}
