package es.florida.ej3_9;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import es.florida.ejT1.ej3_7;

public class Biblioteca {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner teclado = new Scanner(System.in);
			int acumuladorNode = 0;
			Llibreria llibreria = new Llibreria(); //= new Llibreria("aisdj","asd", "2022-12-12", "asd", 2);
			ArrayList<Llibreria> llibres = new ArrayList<Llibreria>();
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = (Document) dBuilder.parse(new File("./venezuela.xml"));
			Element raiz = document.getDocumentElement();
			System.out.println("Contingut XML "+raiz.getNodeName()+":");
			NodeList nodeList = document.getElementsByTagName("llibre");
			for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					String titol = eElement.getElementsByTagName("titulo").item(0).getTextContent();
					String autor = eElement.getElementsByTagName("autor").item(0).getTextContent();
					String anyPublicacio = eElement.getElementsByTagName("anyPublicacio").item(0).getTextContent();
					String editorial = eElement.getElementsByTagName("editorial").item(0).getTextContent();
					int numPagines = Integer.parseInt(eElement.getElementsByTagName("numPagines").item(0).getTextContent());
					
					llibreria =  new Llibreria(titol, autor, anyPublicacio, editorial, numPagines);
					llibres.add(llibreria);
				}
			}
			llibreria.setLista(llibres);
			String opcion = "";
			boolean continuar = false;
			do {
				System.out.println("1. Mostrar tots els títols de la biblioteca (només el títol)");
				System.out.println("2. Mostrar informació detallada d’un llibre");
				System.out.println("3. Crear nou llibre");
				System.out.println("4. Actualitzar llibre");
				System.out.println("5. Borrar llibre");
				System.out.println("6. Tancar biblioteca");
				System.out.print("Tria opció: ");
				opcion = teclado.nextLine();
				switch (opcion){
					case "1":
						llibreria.recuperarTots();
					break;
					case "2":
						System.out.println("Quin llibre vols elegir: ");
						llibreria.recuperarTots();
						System.out.println("Continuar ");
					break;
					case "3":
						System.out.println("Llibre creat exitosamente amb l'identificador: " + llibreria.crearLlibre("aisdj","asd", "2022-12-12", "asd", 2));
					break;
					case "4":
					break;
					case "5":
					break;
					case "6":
						continuar = true;
					break;					
				}
			}while(continuar == false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
