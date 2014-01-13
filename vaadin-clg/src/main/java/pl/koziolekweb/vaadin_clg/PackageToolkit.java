package pl.koziolekweb.vaadin_clg;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import static pl.koziolekweb.vaadin_clg.PomToolkit.getMainPackage;
import static pl.koziolekweb.vaadin_clg.PomToolkit.getMainPackageName;
import static pl.koziolekweb.vaadin_clg.PomToolkit.getPom;
import static pl.koziolekweb.vaadin_clg.PomToolkit.getPomXml;

/**
 * This class is helper for analyze and build file paths and packages in file system.
 * User: koziolek
 */
public class PackageToolkit {

	public static boolean isMavenProject() {
		File cd = new File(".");
		File[] files = cd.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return "pom.xml".equals(name);
			}
		});
		return files.length == 1;
	}

	public static File getThemesDirectory() {
		return new File("./src/main/webapp/VAADIN/themes");
	}

	public static Collection<File> getThemesList(File themesDir) {
		File[] files = themesDir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathName) {
				// all dirs are themes
				return pathName.isDirectory();
			}
		});
		return Arrays.asList(files);
	}

	public static File getLayoutsDirectory(File theme) {
		File[] files = theme.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return "layouts".equals(name);
			}
		});
		if (files.length > 0)
			return files[0];
		return null;
	}

	public static Collection<File> getLayoutsList(File layoutDir) {
		File[] files = layoutDir.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith("html");
			}
		});
		return Arrays.asList(files);
	}

	public static File getThemePackage(final String themeName) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		File mainPackage = getMainPackage(getPomXml(getPom()));
		File[] themeDir = mainPackage.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.equals(themeName.replaceAll("-", "_"));
			}
		});
		if (themeDir.length == 1)
			return themeDir[0];
		File themeDirNew = new File(mainPackage.getAbsolutePath() + "/" + themeName.replaceAll("-", "_"));
		themeDirNew.mkdirs();
		return themeDirNew;
	}

	public static String getThemePackageName(final String themeName) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		return getMainPackageName(getPomXml(getPom())) + "." + themeName;
	}
}
