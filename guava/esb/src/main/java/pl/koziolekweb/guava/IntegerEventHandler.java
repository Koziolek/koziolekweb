package pl.koziolekweb.guava;

import com.google.common.eventbus.Subscribe;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
class IntegerEventHandler {

	@Subscribe
	public void handleEvent(IntegerEvent integerEvent) {
		System.out.println("" + (integerEvent.get() / 2));
	}
}
