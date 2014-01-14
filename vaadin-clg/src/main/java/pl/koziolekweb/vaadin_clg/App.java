package pl.koziolekweb.vaadin_clg;

import com.google.common.base.Joiner;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;
import static pl.koziolekweb.vaadin_clg.LayoutToolkit.getAllLocations;
import static pl.koziolekweb.vaadin_clg.LayoutToolkit.getXml;
import static pl.koziolekweb.vaadin_clg.PackageToolkit.getLayoutsDirectory;
import static pl.koziolekweb.vaadin_clg.PackageToolkit.getLayoutsList;
import static pl.koziolekweb.vaadin_clg.PackageToolkit.getThemePackage;
import static pl.koziolekweb.vaadin_clg.PackageToolkit.getThemePackageName;
import static pl.koziolekweb.vaadin_clg.PackageToolkit.getThemesDirectory;
import static pl.koziolekweb.vaadin_clg.PackageToolkit.getThemesList;
import static pl.koziolekweb.vaadin_clg.PackageToolkit.isMavenProject;

/**
 * Hello world!
 */
public class App {


	public static void main(String[] args) throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
		if (!isMavenProject()) {
			System.out.println("Cannot find pom.xml or you have many poms here. I'm out");
			System.exit(1);
		}
		new App().runApp();

	}

	public void runApp() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		File themesDirectory = getThemesDirectory();
		if (!themesDirectory.exists()) {
			System.out.printf("Cannot find %s. I'm out\n", themesDirectory.getPath());
			System.exit(1);
		}
		Collection<File> themesList = getThemesList(themesDirectory);
		for (final File theme : themesList) {
			System.out.printf("Theme %s.\n", theme.getPath());
			File layoutsDirectory = getLayoutsDirectory(theme);
			System.out.printf("Layout dir is %s.\n", layoutsDirectory.getPath());
			Collection<File> layoutsList = getLayoutsList(layoutsDirectory);
			if (layoutsList.size() == 0)
				continue;
			for (File layout : layoutsList) {
				System.out.printf("Layout %s.\n", layout.getPath());

				final String layoutName = layout.getName().replaceAll(".html", "");
				final String locations = Joiner.on(",").join(getAllLocations(getXml(layout)));
				final File themePackage = getThemePackage(theme.getName());
				final String themePackageName = getThemePackageName(theme.getName());
				File javaFile = new File(themePackage.getCanonicalPath() + "/" + layoutName + ".java");
				System.out.printf("Layout.java %s.\n", javaFile.getPath());
				if (!javaFile.exists()) {
					javaFile.createNewFile();
				}
				FileWriter fileWriter = new FileWriter(javaFile);
				fileWriter.write(CustomLayoutBuilder.init()
						.setPackageName(themePackageName.replaceAll("/", "."))
						.setLayoutName(layoutName)
						.setLocations(locations)
						.build()
				);
				fileWriter.flush();
				fileWriter.close();
			}
		}
	}

}
