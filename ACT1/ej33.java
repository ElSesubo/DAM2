package es.florida.ej; 

import java.util.Scanner;

public class ej33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		System.out.print("Hasta cual número quieres sumar? ");
		int num = Integer.parseInt(teclado.nextLine());
		int pares = 0;
		
		for(int i = 0; i < num; i++) {
			if(i%2==0) {
				pares += i;
			}
		}
		
		System.out.println("Suma de pares: " + pares);
	}

}
