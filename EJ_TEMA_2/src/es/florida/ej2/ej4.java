package es.florida.ej2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ej4 {
	
	public static void muestraContenido() { 
		try(FileReader fileReader = new FileReader("./resultados.txt")){
	        int caracterLeido = fileReader.read();
	        while(caracterLeido!= -1) {
	            char caracter = (char) caracterLeido;
	            System.out.print(caracter);
	            caracterLeido = fileReader.read();
	        }
	    }catch(IOException ex){
	        System.err.println("Error al leer el archivo");
	        ex.printStackTrace();
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String clase = "es.florida.ej2.ej3";
			String javaHome = System.getProperty("java.home");
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			String className = clase;
			ArrayList<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(className);
			ProcessBuilder builder = new ProcessBuilder(command);
			Process p = builder.inheritIO().start();
			muestraContenido();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
