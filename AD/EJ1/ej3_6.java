package es.florida.ejT1;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ej3_6 {

	private String titulo, dinerorestante;
	
	public ej3_6(String titulo, String dinerorestante) {
		this.titulo = titulo;
		this.dinerorestante = dinerorestante;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDinero() {
		return this.dinerorestante;
	}
	
	public void setDinero(String dinero) {
		this.dinerorestante = dinero;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int acumuladorNode = 0;
			ArrayList<ej3_6> objetos = new ArrayList<ej3_6>();
			ej3_6 objeto;
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = (Document) dBuilder.parse(new File("./venezuela.xml"));
			Element raiz = document.getDocumentElement();
			System.out.println("Contingut XML "+raiz.getNodeName()+":");
			NodeList nodeList = document.getElementsByTagName("ciudad");
			for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					String titol = eElement.getElementsByTagName("titulo").item(0).getTextContent();
					String diners = eElement.getElementsByTagName("dinerorestante").item(0).getTextContent();
					objeto = new ej3_6(titol, diners);
					objetos.add(objeto);
				}
			}
			objetos.forEach((n) -> System.out.println(n.getTitulo() + n.getDinero()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
