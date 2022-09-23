package es.florida.ej;

import java.util.Scanner;

public class ej4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		System.out.print("Numero 1: ");
		Integer num1 = Integer.parseInt(teclado.nextLine());
		System.out.print("Numero 2: ");
		Integer num2 = Integer.parseInt(teclado.nextLine());
		if (num1 > num2) {
			System.out.println(num1 + " es mayor que " + num2);
		}else if(num1 < num2) {
			System.out.println(num2 + " es mayor que " + num1);
		}else {
			System.out.println(num1 + " y " + num2 + " son iguales");
		}
	}

}
