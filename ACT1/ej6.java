package es.florida.ej;

import java.util.Iterator;
import java.util.Scanner;

public class ej6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado;
		Integer acumulador = 0;
		
		for(int i = 0; i < 5; i++) {
			teclado = new Scanner(System.in);
			System.out.print("Numero " + (i+1) + ": ");
			acumulador += Integer.parseInt(teclado.nextLine());
		}
		
		System.out.println("La suma total es: " + acumulador);
	}

}
