package pl.koziolekweb.vaadin_clg;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
class CustomLayoutBuilder {

	private static final String TEMPLATE = "package ${package};\n" +
			"import com.vaadin.ui.Component;\n" +
			"import com.vaadin.ui.CustomLayout;\n" +
			"public class ${class_name} extends CustomLayout {\n" +
			"public static enum Locations{\n" +
			"${locations}\n" +
			"}\n" +
			"private static final String NAME = \"${class_name}\";\n" +
			"public ${class_name}(){" +
			"super(NAME);\n" +
			"}\n" +
			"public void addComponent(Component c, Locations p) {\n" +
			"addComponent(c, p.name());\n" +
			"}\n" +
			"}";
	private String packageName;
	private String layoutName;
	private String locations;

	private CustomLayoutBuilder() {
	}

	public static CustomLayoutBuilder init() {
		return new CustomLayoutBuilder();
	}

	public CustomLayoutBuilder setPackageName(String packageName) {
		checkNotNull(packageName);
		checkArgument(!packageName.isEmpty());
		this.packageName = packageName;
		return this;
	}

	public CustomLayoutBuilder setLayoutName(String layoutName) {
		checkNotNull(layoutName);
		checkArgument(!layoutName.isEmpty());
		this.layoutName = layoutName;
		return this;
	}

	public CustomLayoutBuilder setLocations(String locations) {
		checkNotNull(locations);
		checkArgument(!locations.isEmpty());
		this.locations = locations;
		return this;
	}

	public String build() {
		checkState(packageName != null && layoutName != null && locations != null);
		return TEMPLATE
				.replaceAll("\\$\\{package}", packageName.replaceAll("/", "."))
				.replaceAll("\\$\\{class_name}", layoutName)
				.replaceAll("\\$\\{locations}", locations)   ;

	}
}
