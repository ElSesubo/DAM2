package es.florida.ej2;

import java.io.File;
import java.util.ArrayList;

public class ej2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
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
			Process p = builder.inheritIO().start();
		}catch(Exception e) {
			System.out.println(e);
		}
	
	}

}
