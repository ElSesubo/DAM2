package es.florida.ej2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ej3 {
	
	public static void muestraContenido(int num) {
		try {
			String sFichero = "./resultados.txt";
			File fichero = new File(sFichero);

			if (fichero.exists()) {
				FileWriter fw = new FileWriter(sFichero, true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(num + "\n");	
				bw.close();
			}else {
				System.out.println("El fitxer no existeix");
			}
		}catch(IOException e) {
			System.out.println(e);
		}
	}
	
	public static int sumar(int num1, int num2) {
		int resultado = 0;
		for(int i = num1; i <= num2; i++) {
			resultado += i;
		}
		return resultado;
	}

	public static void main(String[] args) {
		int num1 = (int) (Math.random()*25+1);
		int num2 = (int) (Math.random()*25+25);
		int resultado = sumar(num1, num2);
		
		muestraContenido(resultado);
	}
}
