package pl.koziolekweb.vaadin_clg;

import org.fest.assertions.Assertions;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.StringReader;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class PomToolkitTest {

	@Test
	public void testGetPom() throws Exception {
		Assertions.assertThat(PomToolkit.getPom()).exists();
	}

	@Test
	public void testGetPomXml() throws Exception {
		Assertions.assertThat(PomToolkit.getPomXml(new File("pom.xml"))).isNotNull();
	}

	@Test
	public void testGetMainPackage() throws Exception {
		String pom = "<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
				"         xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n" +
				"    <modelVersion>4.0.0</modelVersion>\n" +
				"    <groupId>pl.koziolekweb.vaadin-clg</groupId>\n" +
				"    <artifactId>vaadin-clg</artifactId>\n" +
				"    <version>1.0-SNAPSHOT</version>\n" +
				"    <packaging>jar</packaging></project>";

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(pom));
		Document pomXml = builder.parse(is);

		Assertions.assertThat(PomToolkit.getMainPackage(pomXml)).exists();
	}
}
