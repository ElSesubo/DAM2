package es.florida.ej;

import java.util.Scanner;

public class ej37 {
	
	public static void mostrarNS(String nombre, int anyos) {
		if(anyos < 1) {
			System.out.println("Desarrollador Junior L1 -15000-18000");
		}
		if(anyos >= 1 && anyos <= 2) {
			System.out.println("Desarrollador Junior L2 -18000-22000");
		}
		if(anyos >= 3 && anyos <= 5) {
			System.out.println("Desarrollador Senior L1 -22000-28000");
		}
		if(anyos >= 6 && anyos <= 8) {
			System.out.println("Desarrollador Senior L2 -28000-36000");
		}
		if(anyos > 8) {
			System.out.println("Analista / Arquitecto. Salario a convenir en base a rol");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		System.out.println("Nombre: ");
		String nombre = teclado.nextLine();
		System.out.println("Años de experiencia: ");
		int anyos = Integer.parseInt(teclado.nextLine());
		
		mostrarNS(nombre, anyos);
	}

}
