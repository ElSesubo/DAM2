package es.florida.ej;

import java.util.Scanner;

public class ej7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado;
		Integer acumulador = 0;
		Integer iteracion = 0;
		
		while(iteracion != 5) {
			teclado = new Scanner(System.in);
			System.out.print("Numero " + (iteracion+1) + ": ");
			acumulador += Integer.parseInt(teclado.nextLine());
			iteracion++;
		}
		
		System.out.println("La suma total es: " + acumulador);
	}

}
