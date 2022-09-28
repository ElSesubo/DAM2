package es.florida.ejT1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ej2_7 {

	public static void muestraContenido(ArrayList<String> cadenas) throws FileNotFoundException, IOException, InterruptedException { 
		String sFichero = "C:/Users/gaarag/Desktop/pepe2.txt";
		File fichero = new File(sFichero);

		if (fichero.exists()) {
			FileWriter fw = new FileWriter(sFichero);
			BufferedWriter bw = new BufferedWriter(fw);
			for(int i = 0; i < cadenas.size(); i++) {
				bw.write(cadenas.get(i) + '\n');
			}	
			bw.close();
		}else {
			System.out.println("El fitxer no existeix");
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		ArrayList<String> cadenas = new ArrayList<String>();
		Scanner teclado = new Scanner(System.in);
		String cadena;
		
		do {
			System.out.print("Introduix cadenes de text: ");
			cadena = teclado.nextLine();
			if(!cadena.equals("exit")) {
				cadenas.add(cadena);
			}
		}while(!cadena.equals("exit"));
		muestraContenido(cadenas);
		System.out.println("Process finalitzat");
	}

}
