package es.florida.ej;

import java.util.Scanner;

public class ej5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado;
		Integer num1, num2;
		Boolean continuar = false;
		while (continuar == false) {
			teclado = new Scanner(System.in);
			System.out.print("Numero 1: ");
			num1 = Integer.parseInt(teclado.nextLine());
			System.out.print("Numero 2: ");
			num2 = Integer.parseInt(teclado.nextLine());
			if(num1 != num2) {
				System.out.println("Los números no son iguales");
			}else {
				System.out.println("Los números son iguales");
				continuar = true;
			}
		}
	}

}
