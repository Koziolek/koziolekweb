package pl.koziolekweb.vaadin_clg;

import org.fest.assertions.Assertions;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class CustomLayoutBuilderTest {

	public static final String PACKAGE = "pl.koziolekweb";
	public static final String LAYOUT = "A";
	public static final String LOCATIONS = "A,B";
	private static final String TEMPLATE = "package " +
			PACKAGE +
			";\n" +
			"import com.vaadin.ui.Component;\n" +
			"import com.vaadin.ui.CustomLayout;\n" +
			"public class " +
			LAYOUT +
			" extends CustomLayout {\n" +
			"public static enum Locations{\n" +
			LOCATIONS +
			"\n" +
			"}\n" +
			"private static final String NAME = \"" +
			LAYOUT +
			"\";\n" +
			"public " +
			LAYOUT +
			"(){" +
			"super(NAME);\n" +
			"}\n" +
			"public void addComponent(Component c, Locations p) {\n" +
			"addComponent(c, p.name());\n" +
			"}\n" +
			"}";


	@Test
	public void testBuildValidClass() throws Exception {
		assertThat(CustomLayoutBuilder.init().setPackageName(PACKAGE)
				.setLayoutName(LAYOUT)
				.setLocations(LOCATIONS).build()).isEqualTo(TEMPLATE);
	}

	@Test(expectedExceptions = IllegalStateException.class)
	public void testBuildNoDataClass() throws Exception {
		CustomLayoutBuilder.init().build();
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testBuildNullPackage() throws Exception {
		CustomLayoutBuilder.init().setPackageName(null).build();
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testBuildEmptyPackage() throws Exception {
		CustomLayoutBuilder.init().setPackageName("").build();
	}


}
