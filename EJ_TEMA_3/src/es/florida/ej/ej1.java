package es.florida.ej;

import java.util.Scanner;

public class ej1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		System.out.print("Tipo: ");
		int num = Integer.parseInt(teclado.nextLine());
		int numHilos = 2;
		CrearASCII ca;
		for(int i = 0; i < numHilos; i++) {
			ca = new CrearASCII(num);
			Thread hilo = new Thread(ca);
			hilo.start();
		}
	}

}
