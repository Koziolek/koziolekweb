package pl.koziolekweb.guava;

import com.google.common.base.Preconditions;
import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class HierarchyApp {

	public static void main(String[] args) {
		EventBus eb = new EventBus();
		eb.register(new IntHandler());
		eb.register(new NumberHandler());
		eb.register(new DeadLetterQueue());
		eb.post(1);
		eb.post(2L);
		eb.post("aaa");
	}
}

class IntHandler{

	@Subscribe
	public void forInt(Integer i){
		System.out.println("Integer " + i);
	}

}
class NumberHandler{

	@Subscribe
	public void forInt(Number i){
		System.out.println("Number " + i);
	}

}

class DeadLetterQueue{

	@Subscribe
	public void handle(DeadEvent de){
		System.out.println(de.getEvent());
	}
}