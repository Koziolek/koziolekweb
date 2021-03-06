package pl.koziolekweb.vaadin.templates;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

import javax.servlet.annotation.WebServlet;

import static pl.koziolekweb.vaadin.templates.MyCustomLayout.Placeholders.BUTTON;
import static pl.koziolekweb.vaadin.templates.MyCustomLayout.Placeholders.LABEL;

@Theme("mytheme")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		final MyCustomLayout layout = new MyCustomLayout();
		setContent(layout);

		Button button = new Button("Click Me");
		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				layout.addComponent(new Label("Thank you for clicking"), LABEL);
			}
		});
		layout.addComponent(button, BUTTON);
	}

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class)
	public static class Servlet extends VaadinServlet {
	}

}
