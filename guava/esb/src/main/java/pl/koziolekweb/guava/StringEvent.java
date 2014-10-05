package pl.koziolekweb.guava;

import java.util.UUID;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
class StringEvent implements Event<String>{

	private final String message;
	final UUID id;

	StringEvent(String message) {
		this.id = UUID.randomUUID();
		this.message = message;
	}

	@Override
	public String get() {
		return message;
	}
}
