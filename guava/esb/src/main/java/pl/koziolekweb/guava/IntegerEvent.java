package pl.koziolekweb.guava;

import java.util.UUID;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
class IntegerEvent implements Event<Integer> {

	private final Integer message;
	final UUID id;

	public IntegerEvent(Integer message) {
		this.id = UUID.randomUUID();
		this.message = message;
	}

	@Override
	public Integer get() {
		return message;
	}


}
