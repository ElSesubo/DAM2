package es.florida.ej;

import java.util.ArrayList;
import java.util.Scanner;

public class ej23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		String nombre = "pepe";
		ArrayList<String> cadena = new ArrayList<String>();
		boolean salir = false;
		do {
			System.out.println("Dime un nombre: ");
			nombre = teclado.nextLine();
			if(nombre.equals("0")) {
				salir = true;
			}else {
				cadena.add(nombre);
			}
		}while(salir == false);
		for(int i = 0; i < cadena.size(); i++) {
			System.out.println((i+1) + "." + cadena.get(i));
		}
	}

}
