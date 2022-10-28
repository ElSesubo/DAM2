package es.florida.ej;

import java.util.Scanner;

public class ej1 {
	
	private static Thread[] hilos;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numHilos = 2;
		hilos = new Thread[numHilos];
		CrearASCII ca;
		for(int i = 0; i < numHilos; i++) {
			ca = new CrearASCII(i+1);
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
