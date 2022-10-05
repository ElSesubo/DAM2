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
    static File archivocopy = new File("./sus_copy.txt");
	
	public Model() {
		
	}
	
	public String mostrarContenido(File archivo) {
		String texto = "";
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
	
	public void buscarPalabra(String palabra) {
		try {
			if(palabra.isEmpty()) {
				JOptionPane.showMessageDialog(null, "El campo de texto está vacío");
			}else {
				if(archivo.exists()) {
	            	lineasTotales = 0;
	            	totalCoincidencias = 0;
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
	            vista.txfBuscar.setText("");
			}
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
	}
	
	public void reemplazarPalabra(String palabra, String reemplazo) {
		try {
			if(palabra.isEmpty() || reemplazo.isEmpty()) {
				JOptionPane.showMessageDialog(null, "El campo de texto está vacío");
			}else {
				if(archivo.exists()) {
	                crearArchivo();
	                String texto = "";
					FileWriter fw = new FileWriter(archivocopy);
					BufferedWriter bw = new BufferedWriter(fw);
					BufferedReader leerArchivo = new BufferedReader(new FileReader(archivo));
	                String lineaLeida;
	                while((lineaLeida = leerArchivo.readLine()) != null) {
	                    String[] palabras = lineaLeida.split(" ");
	                    for(int i = 0 ; i < palabras.length ; i++) {
	                        if(palabras[i].equals(palabra)) {
	                            palabras[i] = reemplazo;  
	                        }
	                        texto += palabras[i] + " ";
	                    }
	                    bw.write(texto);
	                }
	                bw.close();
	                leerArchivo.close();
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void crearArchivo() {
		File fichero = archivocopy;
		try {
		  if (fichero.createNewFile()) {
			  JOptionPane.showMessageDialog(null, "El fitxer s'ha creat correctament");
		  }else {
			  JOptionPane.showMessageDialog(null, "Fitxer sobreredactat");
		  }
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
