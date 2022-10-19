package es.florida.ejT1;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class ej3_2 {

	public static void main(String[] args) {
		
		try {
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document document = (Document) dBuilder.parse(new File("./venezuela.xml"));
				Element raiz = document.getDocumentElement();
				System.out.println("Contingut XML "+raiz.getNodeName()+":");
				NodeList nodeList = document.getElementsByTagName("ciudad");
				for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				System.out.println("");
					if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					System.out.println("ID banc: " + eElement.getAttribute("ciudad"));
					System.out.println("Titol : " + eElement.getElementsByTagName("titulo").item(0).getTextContent());
					System.out.println("Diners restants : " + eElement.getElementsByTagName("dinerorestante").item(0).getTextContent());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}
