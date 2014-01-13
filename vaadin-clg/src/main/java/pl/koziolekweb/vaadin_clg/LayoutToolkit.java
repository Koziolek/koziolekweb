package pl.koziolekweb.vaadin_clg;

import com.google.common.collect.Lists;
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
import java.util.ArrayList;
import java.util.Collection;

/**
 * TODO write JAVADOC!!!
 * User: koziolek
 */
public class LayoutToolkit {

	public static Document getXml(File html) throws IOException, SAXException, ParserConfigurationException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		return dBuilder.parse(html);
	}

	public static Collection<String> getAllLocations(Document xml) throws XPathExpressionException {
		XPathFactory xPathfactory = XPathFactory.newInstance();
		XPath xpath = xPathfactory.newXPath();
		XPathExpression expr = xpath.compile("//@location");
		NodeList nl = (NodeList) expr.evaluate(xml, XPathConstants.NODESET);

		ArrayList<String> locations = Lists.newArrayList();
		for(int i =0; i <nl.getLength(); i++)
			locations.add(nl.item(i).getTextContent());
		return locations;
	}
}
