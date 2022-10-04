package es.florida.ejT1.ej2_9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Model {
	
	private Vista vista;
	
	static int lineasTotales;
    static int totalCoincidencias;
    static File archivo = new File("./sus.txt");
	
	public Model() {
		
	}
	
	public static String mostrarContenido() {
		String texto = null;
		try(FileReader fileReader = new FileReader(archivo)){
	        int caracterLeido = fileReader.read();
	        while(caracterLeido!= -1) {
	            char caracter = (char) caracterLeido;
	            caracterLeido = fileReader.read();
	            texto += caracter;
	        }
	    }catch(IOException ex){
	        System.err.println("Error al leer el archivo");
	        ex.printStackTrace();
	    }
		return texto;
	}
	
	public static void buscarPalabra(String palabra) {
		try {
            if(archivo.exists()) {
                BufferedReader leerArchivo = new BufferedReader(new FileReader(archivo));
                String lineaLeida;
                while((lineaLeida = leerArchivo.readLine()) != null) {
                    lineasTotales = lineasTotales + 1;
                    String[] palabras = lineaLeida.split(" ");
                    for(int i = 0 ; i < palabras.length ; i++) {
                        if(palabras[i].equals(palabra)) {
                            totalCoincidencias = totalCoincidencias + 1;
                        }
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "En total se encotro la palabra: " + palabra + ", " + totalCoincidencias + " Veces en el archivo");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
	}
	
	public static void reemplazarPalabra(String palabra, String reemplazo) {
		try {
			if(archivo.exists()) {
				BufferedReader leerArchivo = new BufferedReader(new FileReader(archivo));
                String lineaLeida;
                FileWriter fw = new FileWriter(archivo);
    			BufferedWriter bw = new BufferedWriter(fw);
                while((lineaLeida = leerArchivo.readLine()) != null) {
                    String[] palabras = lineaLeida.split(" ");
                    for(int i = 0 ; i < palabras.length ; i++) {
                        if(palabras[i].equals(palabra)) {
                            palabras[i] = reemplazo;
                        }
                    }
                }
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void crearArchivo() {
		File fichero = new File ("C:/Users/gaarag/Documents/DAM 2º/AD/HolaMundo/src/es/florida/ejT1/ej2_9/document_copy.txt");
		try {
			if (!fichero.exists()) {
			  if (fichero.createNewFile()) {
				  System.out.println("El fitxer s'ha creat correctament");
			  }
			  else {
				  System.out.println("Ha hagut un problema al crear el fitxer");  
			  }
			}else {
				System.out.println("El fitxer ja existeix"); 
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
