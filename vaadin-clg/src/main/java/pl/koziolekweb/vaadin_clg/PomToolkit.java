package pl.koziolekweb.vaadin_clg;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class PomToolkit {

	public static File getPom() {
		return new File("pom.xml");
	}

	public static Document getPomXml(File pom) throws IOException, SAXException, ParserConfigurationException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		return dBuilder.parse(pom);
	}

	public static File getMainPackage(Document pomXml) throws XPathExpressionException {
		XPathFactory xPathfactory = XPathFactory.newInstance();
		XPath xpath = xPathfactory.newXPath();
		XPathExpression expr = xpath.compile("/project/groupId");
		NodeList nl = (NodeList) expr.evaluate(pomXml, XPathConstants.NODESET);
		Node groupId = nl.item(0);
		String textContent = groupId.getTextContent();
		String noDash = textContent.replaceAll("-", "_");
		return new File("./src/main/java/" +
				noDash.replaceAll("\\.", "/"));
	}

	public static String getMainPackageName(Document pomXml) throws XPathExpressionException {
		XPathFactory xPathfactory = XPathFactory.newInstance();
		XPath xpath = xPathfactory.newXPath();
		XPathExpression expr = xpath.compile("/project/groupId");
		NodeList nl = (NodeList) expr.evaluate(pomXml, XPathConstants.NODESET);
		Node groupId = nl.item(0);
		String textContent = groupId.getTextContent();
		String noDash = textContent.replaceAll("-", "_");
		return noDash.replaceAll("\\.", "/");
	}
}
