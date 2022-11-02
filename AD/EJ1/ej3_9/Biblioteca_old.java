package es.florida.ej3_9;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

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

public class Biblioteca {
	
	public static void guardarResultat(ArrayList<Llibreria> lista) throws SAXException, IOException {
		try {
			File Old_File=new File("venezuel2.txt");
		    Old_File.delete();
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = (Document) dBuilder.parse(new File("./venezuela.xml"));
			Element raiz = doc.getDocumentElement();
			NodeList nodeList = doc.getElementsByTagName("llibre");
			for (int i = 0; i < lista.size(); i++) {
				Node node = nodeList.item(i);
				Element eElement = (Element) node;
				Element llibre = doc.createElement("llibre");
				String id = String.valueOf((i+1));
				llibre.setAttribute("id",id); raiz.appendChild(llibre);
				Element titulo = doc.createElement("titulo");
				titulo.appendChild(doc.createTextNode(String.valueOf(lista.get(i).getTitol())));
				llibre.appendChild(titulo);
				Element autor = doc.createElement("autor");
				autor.appendChild(doc.createTextNode(String.valueOf(lista.get(i).getAutor())));
				llibre.appendChild(autor);
				Element any = doc.createElement("anyPublicacio");
				any.appendChild(doc.createTextNode(String.valueOf(lista.get(i).getAnyPublicacio())));
				llibre.appendChild(any);
				Element editorial = doc.createElement("editorial");
				editorial.appendChild(doc.createTextNode(String.valueOf(lista.get(i).getEditorial())));
				llibre.appendChild(editorial);
				Element pagines = doc.createElement("numPagines");
				pagines.appendChild(doc.createTextNode(String.valueOf(lista.get(i).getNumPagines())));
				llibre.appendChild(pagines);
			}
			TransformerFactory tranFactory = TransformerFactory.newInstance(); 
			Transformer aTransformer = tranFactory.newTransformer();
			aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1"); 
			aTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			try {
				FileWriter fw = new FileWriter("venezuela.xml", false); 
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
			int opcio;
			String opcion = "";
			boolean continuar = false;
			do {
				System.out.println("\n1. Mostrar tots els títols de la biblioteca (només el títol)");
				System.out.println("2. Mostrar informació detallada d’un llibre");
				System.out.println("3. Crear nou llibre");
				System.out.println("4. Actualitzar llibre");
				System.out.println("5. Borrar llibre");
				System.out.println("6. Tancar biblioteca");
				System.out.print("Tria opció: ");
				opcion = teclado.nextLine();
				switch (opcion){
					case "1":
						limpiarConsola();
						System.out.println("");
						llibreria.recuperarTots();
						continuar = continuar();
						
					break;
					case "2":
						limpiarConsola();
						System.out.println("");
						llibreria.recuperarTots();
						System.out.print("Quin llibre vols elegir: ");
						opcio = Integer.parseInt(teclado.nextLine());
						llibreria.mostrarLlibre(opcio);
						continuar = continuar();
					break;
					case "3":
						limpiarConsola();
						System.out.println("");
						System.out.println("Llibre creat exitosamente amb l'identificador: " + llibreria.crearLlibre("aisdj","asd", "2022-12-12", "asd", 2));
						guardarResultat(llibres);
						continuar = continuar();
					break;
					case "4":
						limpiarConsola();
						System.out.println("");
						llibreria.recuperarTots();
						System.out.print("Quin llibre vols actualitzar: ");
						opcio = Integer.parseInt(teclado.nextLine());
						llibreria.mostrarLlibre(opcio);
						System.out.println("");
						actualitzar(opcio);
						guardarResultat(llibres);
						continuar = continuar();
					break;
					case "5":
						limpiarConsola();
						System.out.println("");
						llibreria.recuperarTots();
						System.out.print("Quin llibre vols borrar? ");
						opcio = Integer.parseInt(teclado.nextLine());
						if(continuar() == false) {
							llibreria.borrarRegistre(opcio);
							guardarResultat(llibres);
						}
						continuar = continuar();
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
	
	public static void limpiarConsola() {  
		try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            /*No hacer nada*/
        }  
	}  
	
	public static boolean continuar() {
		Scanner teclado = new Scanner(System.in);
		System.out.print("\nContinuar? Y/N ");
		char opcion = teclado.nextLine().charAt(0);
		if(opcion == 'Y' || opcion == 'y') {
			return false;
		}else {
			return true;
		}
	}
	
	public static void actualitzar(int id) {
		id = id - 1;
		Llibreria llibreria = new Llibreria();
		Scanner teclado = new Scanner(System.in);
		System.out.print("Titol: ");
		String titol = teclado.nextLine();
		System.out.print("Autor: ");
		String autor = teclado.nextLine();
		System.out.print("Any publicació: ");
		String any = teclado.nextLine();
		System.out.print("Editorial: ");
		String edit = teclado.nextLine();
		System.out.print("Número págines: ");
		int paginas = Integer.parseInt(teclado.nextLine());
		
		llibreria.actualitzarRegistre(id, titol, autor, any, edit, paginas);
	}

}
