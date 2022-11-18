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
	
	static Scanner teclado = new Scanner(System.in);
	static Llibreria llibreria = new Llibreria();
	static ArrayList<Llibreria> llibres = new ArrayList<Llibreria>();
	
	public static void guardarResultat(ArrayList<Llibreria> lista) throws SAXException, IOException {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = (Document) dBuilder.parse(new File("./venezuela.xml"));
			Element raiz = doc.getDocumentElement();
			for (int i = 0; i < lista.size(); i++) {
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
			System.out.println(ex);
		} catch (ParserConfigurationException ex) {
			System.out.println(ex);
		}
	}

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = (Document) dBuilder.parse(new File("./venezuela.xml"));
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
					
					llibreria = new Llibreria(titol, autor, anyPublicacio, editorial, numPagines);
					llibres.add(llibreria);
				}
			}
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
						recuperarTots();
						continuar = continuar();
						
					break;
					case "2":
						limpiarConsola();
						System.out.println("");
						recuperarTots();
						System.out.print("Quin llibre vols elegir: ");
						opcio = Integer.parseInt(teclado.nextLine());
						mostrarLlibre(opcio);
						continuar = continuar();
					break;
					case "3":
						limpiarConsola();
						System.out.println("");
						crearLlibre();
						guardarResultat(llibres);
						continuar = continuar();
					break;
					case "4":
						limpiarConsola();
						System.out.println("");
						recuperarTots();
						System.out.print("Quin llibre vols actualitzar: ");
						opcio = Integer.parseInt(teclado.nextLine());
						mostrarLlibre(opcio);
						System.out.println("");
						actualitzar(opcio);
						guardarResultat(llibres);
						continuar = continuar();
					break;
					case "5":
						limpiarConsola();
						System.out.println("");
						recuperarTots();
						System.out.print("Quin llibre vols borrar? ");
						opcio = Integer.parseInt(teclado.nextLine());
						if(continuar() == false) {
							borrarRegistre(opcio);
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
		
		actualitzarRegistre(id, titol, autor, any, edit, paginas);
	}

	public static void crearLlibre() {
		System.out.print("Nom del llibre: ");
		String nom = teclado.nextLine();
		System.out.print("Autor del llibre: ");
		String aut = teclado.nextLine();
		System.out.print("Any del llibre: ");
		String any = teclado.nextLine();
		System.out.print("Editorial del llibre: ");
		String ed = teclado.nextLine();
		System.out.print("Págines del llibre: ");
		int pag = Integer.parseInt(teclado.nextLine());
		
		
		System.out.println("Llibre creat exitosamente amb l'identificador: " + crearLlibreAtri(nom,aut,any,ed,pag));
	}
	
	public static int crearLlibreAtri(String tit, String aut, String any, String edit, int num) {
		Llibreria libro = new Llibreria(tit, aut, any, edit, num);
		llibres.add(libro);
		return Llibreria.getIdentificador();
	}
	
	public static void mostrarLlibre(int id) {
		id = id - 1;
		System.out.println("\nTitol: " + llibres.get(id).getTitol() + "\n" + "Autor: " + llibres.get(id).getAutor() + "\n" + "Any publicació: " + llibres.get(id).getAnyPublicacio() 
				+ "\n" + "Editorial: " + llibres.get(id).getEditorial() + "\n" + "Numero Págines: " + llibres.get(id).getNumPagines());	
	}
	

	public static void borrarRegistre(int id) {
		id = id - 1;
		llibres.remove(id);
		System.out.println("Llibre eliminat");
	}
	
	public static void actualitzarRegistre(int id, String tit, String aut, String any, String edit, int num) {
		Llibreria libroAct = new Llibreria(tit, aut, any, edit, num);
		llibres.set(id, libroAct);
		System.out.println("Llibre actualitzat");
	}
	
	public static void recuperarTots() {
		for(int i = 0; i < llibres.size(); i++) {
			llibres.get(i);
			System.out.println((i+1) + ". " + llibres.get(i).getTitol());
		}
	}
}
