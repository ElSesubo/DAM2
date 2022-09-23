package es.florida.ej;

import java.util.Scanner;

public class ej3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		System.out.print("Numero 1: ");
		Integer num1 = Integer.parseInt(teclado.nextLine());
		System.out.print("Numero 2: ");
		Integer num2 = Integer.parseInt(teclado.nextLine());
		Integer resultado = num1+num2;
		System.out.println("La suma entre " + num1 + " y " + num2 + " es: " + resultado);
	}

}
