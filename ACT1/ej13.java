package es.florida.ej;

import java.util.Scanner;

public class ej13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		System.out.print("Dime una temperatura en grados centigrados: ");
		Integer num = Integer.parseInt(teclado.nextLine());
		Integer deCF = (num * 9 / 5) + 32;
		System.out.print("La temperatura " + num + "º en Farenheit seria: " + deCF);
		
	}

}
