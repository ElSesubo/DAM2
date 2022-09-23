package es.florida.ejT1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ej2_5 {

	public static void muestraContenido(String archivo, Integer speed) throws FileNotFoundException, IOException, InterruptedException { 
		String cadena; 
		FileReader f = new FileReader(archivo); 
		BufferedReader b = new BufferedReader(f); 
		while((cadena = b.readLine())!=null) { 
			System.out.println(cadena); 
			Thread.sleep(speed);
		} 
		b.close(); 
	}

	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduix la ruta d'un fitxer");
		String ruta = teclado.nextLine();
		System.out.println("Introduix la velocitat de lectura: ");
		Integer speed = Integer.parseInt(teclado.nextLine());
		
		muestraContenido(ruta, speed);
	}

}
