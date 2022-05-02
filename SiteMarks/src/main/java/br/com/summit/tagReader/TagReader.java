package br.com.summit.tagReader;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class TagReader {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("MarkAttrList.xml");
        document.getDocumentElement().normalize();
        NodeList nodeList = (NodeList) document.getDocumentElement();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nodeItem = nodeList.item(i);

            if (nodeItem.getNodeType() == Node.ELEMENT_NODE) {
                Element itemElement = (Element) nodeItem;

                String tagName = itemElement.getTagName();
                System.out.println(tagName);

                NamedNodeMap namedNodeMap = itemElement.getAttributes();

                for (int j = 0; j < namedNodeMap.getLength(); j++) {
                    System.out.println(" " + namedNodeMap.item(j).getNodeName() + " = "
                            + namedNodeMap.item(j).getNodeValue());

                }

                NodeList childList = itemElement.getChildNodes();

                for (int j = 0; j < childList.getLength(); j++) {
                    Node childNode = childList.item(j);

                    if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element childElement = (Element) childNode;
                        NamedNodeMap childNamedNodeMap = childElement.getAttributes();

                        String childTagName = childElement.getTagName();
                        System.out.println("   " + childTagName);

                        for (int k = 0; k < childNamedNodeMap.getLength(); k++) {
                            System.out.println("      " + childElement.getNodeName() + " = "
                                    + childElement.getAttributes().item(k));

                        }
                    }
                }
            }
        }
    }
}


