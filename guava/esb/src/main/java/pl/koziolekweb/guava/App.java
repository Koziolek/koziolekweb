package pl.koziolekweb.guava;

import com.google.common.eventbus.EventBus;

public class App {

	public static void main(String[] args) {
		EventBus eb = new EventBus();
		eb.register(new StringEventHandler());
		eb.register(new IntegerEventHandler());
		eb.post(new StringEvent("Hello World!"));
		eb.post(new IntegerEvent(42));
	}
}


