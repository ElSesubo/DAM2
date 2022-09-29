package es.florida.ej;

import java.util.Scanner;

public class ej38 {
	
	public static void mostrarIntervalo(int num1, int num2) {
		boolean primo;
		long tiempoIni = System.nanoTime();
		for(int i = num1; i < num2; i++) {
			if(i == 0 || i == 1) {
				primo = false;
			}else {
				primo = true;
				for(int j = 2; j<= i/2; j++) {
					if(i%j == 0) {
						primo = false;
						break;
					}
				}
			}
			if(!primo) {
				System.out.println(i);
			}else {
				System.out.println(i + " es primo");
			}
		}
		long tiempoFin = System.nanoTime();
		long duracion = (tiempoFin + tiempoIni)/1000000;
		System.out.println("Tiempo de ejecución: " + duracion + " ms");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		System.out.println("Numero 1: ");
		int num1 = Integer.parseInt(teclado.nextLine());
		System.out.println("Numero 2: ");
		int num2 = Integer.parseInt(teclado.nextLine());
		
		mostrarIntervalo(num1, num2);
	}

}
