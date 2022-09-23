package es.florida.ej;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ej21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado;
		String nombre;
		ArrayList<String> cadena = new ArrayList<String>();
		for(int i = 0; i < 5; i++) {
			teclado = new Scanner(System.in);
			System.out.println("Dime un nombre: ");
			nombre = teclado.nextLine();
			cadena.add(nombre);
		}
		System.out.println(cadena);
	}

}
