package pl.koziolekweb.vaadin.templates.mytheme   ;

import com.vaadin.ui.Component;
import com.vaadin.ui.CustomLayout;

public class MyCustomLayout extends CustomLayout {
	private static final String NAME = "MyCustomLayout";

	public MyCustomLayout() {
		super(NAME);
	}

	public void addComponent(Component c, Locations p) {
		addComponent(c, p.name());
	}

	public static enum Locations {
		button, label
	}
}