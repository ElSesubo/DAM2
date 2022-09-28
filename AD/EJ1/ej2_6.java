package es.florida.ejT1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ej2_6 {

	public static void muestraContenido(String archivo) throws FileNotFoundException, IOException, InterruptedException { 
		String sFichero = "C:/Users/gaarag/Desktop/pepe2.txt";
		File fichero = new File(sFichero);

		if (fichero.exists()) {
			FileWriter fw = new FileWriter(sFichero);
			BufferedWriter bw = new BufferedWriter(fw);
			String cadena; 
			FileReader f = new FileReader(archivo); 
			BufferedReader b = new BufferedReader(f); 
			while((cadena = b.readLine())!=null) { 
				bw.write(cadena + '\n'); 
			} 
			b.close();
			bw.close();
		}else {
			System.out.println("El fitxer no existeix");
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduix la ruta d'un fitxer");
		String ruta = teclado.nextLine();
		
		muestraContenido(ruta);
	}

}
