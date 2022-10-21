package es.florida.ejT1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ej3_8 {

private String titulo, dinerorestante;
	
	public ej3_8(String titulo, String dinerorestante) {
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
	
	public static ej3_8 agregarRegistre() {
		Scanner teclado = new Scanner(System.in);
		ej3_8 objeto;
		ArrayList<ej3_8> objetos = new ArrayList<ej3_8>();
		
		System.out.print("Titol: ");
		String titol = " " + teclado.nextLine() + " ";
		System.out.print("Diners: ");
		String diners = teclado.nextLine() + " ";
		objeto = new ej3_8(titol, diners);
		return objeto;
	}
	
	public static void guardarResultat(ArrayList<ej3_8> lista) throws SAXException, IOException {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = (Document) dBuilder.parse(new File("./venezuela.xml"));
			Element raiz = doc.getDocumentElement();
			NodeList nodeList = doc.getElementsByTagName("ciudad");
			for (int i = 0; i < lista.size(); i++) {
				Node node = nodeList.item(i);
				Element eElement = (Element) node;
				Element ciudad = doc.createElement("ciudad");
				String id = String.valueOf(eElement.getAttribute("ciudad"));
				ciudad.setAttribute("ciudad",id); raiz.appendChild(ciudad);
				Element titulo = doc.createElement("titulo");
				titulo.appendChild(doc.createTextNode(String.valueOf(lista.get(i).getTitulo())));
				ciudad.appendChild(titulo);
				Element dinero = doc.createElement("dinerorestante");
				dinero.appendChild(doc.createTextNode(String.valueOf(lista.get(i).getDinero())));
				ciudad.appendChild(dinero);
			}
			TransformerFactory tranFactory = TransformerFactory.newInstance(); 
			Transformer aTransformer = tranFactory.newTransformer();
			aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1"); 
			aTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			try {
				FileWriter fw = new FileWriter("venezuela2.xml"); 
				StreamResult result = new StreamResult(fw);
				aTransformer.transform(source, result);
				fw.close();
			} catch (IOException e) {
			e.printStackTrace();
			}
		} catch (TransformerException ex) {
			System.out.println("Error escrivint el documento");
		} catch (ParserConfigurationException ex) {
			System.out.println("Error construint el document");
		}
	}
	
	public static void crearFitxer() {
		try {
			File fichero = new File ("./venezuela2.xml");
			if (!fichero.exists()) {
    			if (fichero.createNewFile()) {
					System.out.println("fitxer creat");
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner teclado = new Scanner(System.in);
			int acumuladorNode = 0;
			ArrayList<ej3_8> objetos = new ArrayList<ej3_8>();
			ej3_8 objeto;
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
					objeto = new ej3_8(titol, diners);
					objetos.add(objeto);
				}
			}
			objetos.add(agregarRegistre());
			objetos.forEach((n) -> System.out.println(n.getTitulo() + n.getDinero()));
			guardarResultat(objetos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
