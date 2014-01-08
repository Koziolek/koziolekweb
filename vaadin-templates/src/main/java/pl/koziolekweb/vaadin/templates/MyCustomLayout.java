package pl.koziolekweb.vaadin.templates;

import com.vaadin.ui.Component;
import com.vaadin.ui.CustomLayout;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class MyCustomLayout extends CustomLayout {

	private final static String NAME = "MyCustomLayout";

	public MyCustomLayout() {
		super(NAME);
	}

	public void addComponent(Component c, Placeholders p) {
		addComponent(c, p.placeholder);
	}

	public static enum Placeholders {
		BUTTON("button"),
		LABEL("label");
		private final String placeholder;

		Placeholders(String label) {
			this.placeholder = label;
		}
	}
}
