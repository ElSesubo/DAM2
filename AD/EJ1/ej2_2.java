package es.florida.ejT1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ej2_2 {

	public static void muestraContenido(String archivo, Integer speed) throws InterruptedException { 
		try(FileReader fileReader = new FileReader(archivo)){
	        int caracterLeido = fileReader.read();
	        while(caracterLeido!= -1) {
	            char caracter = (char) caracterLeido;
	            System.out.print(caracter);
	            caracterLeido = fileReader.read();
	            Thread.sleep(speed);
	        }
	    }catch(IOException ex){
	        System.err.println("Erorr al leer el archivo");
	        ex.printStackTrace();
	    }
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduix la ruta d'un fitxer");
		String ruta = teclado.nextLine();
		System.out.println("Introduix la velocitat de escritura: ");
		Integer speed = Integer.parseInt(teclado.nextLine());
		
		muestraContenido(ruta, speed);
	}

}
