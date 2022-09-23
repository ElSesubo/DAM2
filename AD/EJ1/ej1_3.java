package es.florida.ejT1;

import java.io.File;

public class ej1_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File fichero = new File(args[0]);
		
		System.out.println("Nombre del archivo: " + fichero.getName());
		System.out.println("Ruta: " + fichero.getPath());
		System.out.println("Ruta absoluta: " + fichero.getAbsolutePath());
		System.out.println("Se puede leer: " + fichero.canRead());
		System.out.println("Se puede escribir: : " + fichero.canWrite());
		System.out.println("Tamaño: " + fichero.length());
		System.out.println("Existe: " + fichero.exists());
	}

}
