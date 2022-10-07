package es.florida.ej2;

import java.io.File;
import java.util.ArrayList;

public class ej7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File directorioSumador = new File("C:/Users/gaarag/Documents/DAM 2º/PSP/EJ_TEMA_2");
			File fichResultado = new File("./resultado.txt");
			String clase = "es.florida.ej2.ej1";
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
			builder.directory(directorioSumador);
			builder.redirectOutput(fichResultado).start();
			Process p = builder.inheritIO().start();
		}catch(Exception e) {
			System.out.println(e);
		}
	
	}

}
