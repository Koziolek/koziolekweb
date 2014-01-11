package pl.koziolekweb.vaadin_clg;

import java.io.File;
import java.io.FilenameFilter;

/**
 * This class is helper for analyze and build file paths and packages in file system.
 * User: koziolek
 */
public class PackageToolkit {


	public boolean isMavenProject() {
		File cd = new File(".");
		File[] files = cd.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return "pom.xml".equals(name);
			}
		});
		return files.length == 1;
	}
}
