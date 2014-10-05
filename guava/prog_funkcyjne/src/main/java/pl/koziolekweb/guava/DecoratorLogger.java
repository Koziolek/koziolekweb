package pl.koziolekweb.guava;

import com.google.common.base.Function;
import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class DecoratorLogger<I, O> extends AbstractDecorator {

	private final Logger logger;
	private Level level;
	private Stopwatch watch;

	public static <I, O> Function<I, O> info(Function<I, O> originalFunction) {
		return new DecoratorLogger<>(originalFunction, Level.INFO);
	}

	public static <I, O> Function<I, O> warning(Function<I, O> originalFunction) {
		return new DecoratorLogger<>(originalFunction, Level.WARNING);
	}

	public static <I, O> Function<I, O> serve(Function<I, O> originalFunction) {
		return new DecoratorLogger<>(originalFunction, Level.SEVERE);
	}

	private DecoratorLogger(Function<I, O> originalFunction, Level level) {
		super(originalFunction);
		this.level = level;
		this.logger = Logger.getLogger(originalFunction.getClass().getCanonicalName());
	}

	@Override
	protected void before(Object input) {
		this.watch = Stopwatch.createStarted();
	}

	@Override
	protected void after(Object input, Object output) {
		Stopwatch stop = watch.stop();
		logger.log(level, "", new Object[]{input, output, "" + stop.elapsed(TimeUnit.MILLISECONDS)});

	}
}
