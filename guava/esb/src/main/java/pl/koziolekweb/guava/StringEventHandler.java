package pl.koziolekweb.guava;

import com.google.common.eventbus.Subscribe;

import static java.lang.String.format;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
class StringEventHandler {

	private static final String MSG = "Message \n%s\n with id \n%s";

	@Subscribe
	public void handleEvent(StringEvent stringEvent) {
		System.out.println(format(MSG, stringEvent.get(), stringEvent.id.toString()));
	}
}
