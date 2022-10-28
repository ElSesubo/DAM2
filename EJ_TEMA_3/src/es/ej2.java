package es.florida.ej;

import java.util.Scanner;

public class ej2 {
	
	private static Thread[] hilos;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numHilos = 5;
		hilos = new Thread[numHilos];
		Contador ca;
		for(int i = 0; i < numHilos; i++) {
			ca = new Contador("Contador " + i, 10, 200);
			hilos[i] = new Thread(ca);
			hilos[i].start();
			try {
				hilos[i].join();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}
