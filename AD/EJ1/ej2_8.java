package es.florida.ejT1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class ej2_8 {

	public static void muestraContenido(ArrayList<String> cadenas, LocalDate nom) { 
		File fichero = new File ("C:/Users/gaarag/Desktop/" + nom + ".txt");
		try {
			if (!fichero.exists()) {
			  if (fichero.createNewFile()) {
				  System.out.println("El fitxer s'ha creat correctament");
				  FileWriter fw = new FileWriter(fichero);
					BufferedWriter bw = new BufferedWriter(fw);
					for(int i = 0; i < cadenas.size(); i++) {
						bw.write(cadenas.get(i) + '\n');
					}	
					bw.close();
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

	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		ArrayList<String> cadenas = new ArrayList<String>();
		LocalDate fecha = LocalDate.now();
		Scanner teclado = new Scanner(System.in);
		String cadena;
		
		do {
			System.out.print("Introduix cadenes de text: ");
			cadena = teclado.nextLine();
			if(!cadena.equals("exit")) {
				cadenas.add(cadena);
			}
		}while(!cadena.equals("exit"));
		muestraContenido(cadenas, fecha);
		System.out.println("Process finalitzat");
	}

}
