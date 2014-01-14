package pl.koziolekweb.vaadin_clg;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class CustomLayoutBuilderTest {

	private static final String TEMPLATE = "package pl.koziolekweb;\n" +
			"import com.vaadin.ui.Component;\n" +
			"import com.vaadin.ui.CustomLayout;\n" +
			"public class A extends CustomLayout {\n" +
			"public static enum Locations{\n" +
			"A,B\n" +
			"}\n" +
			"private static final String NAME = \"A\";\n" +
			"public ${class_name}(){" +
			"super(NAME);\n" +
			"}\n" +
			"public void addComponent(Component c, Locations p) {\n" +
			"addComponent(c, p.name());\n" +
			"}\n" +
			"}";
}
