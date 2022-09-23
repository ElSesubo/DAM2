package es.florida.ej;

import java.util.Scanner;

public class ej14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		System.out.print("Dime el radio de una circunferencia: ");
		Integer num = Integer.parseInt(teclado.nextLine());
		Integer diametro = num * 2;
		Double area = num * num * Math.PI;
		
		System.out.println("El radio es: " + num + ", su diametro es de: " + diametro + " y el area es de: " + area);
	}

}
