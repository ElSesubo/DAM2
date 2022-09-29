package es.florida.ej;

import java.util.Iterator;
import java.util.Scanner;

public class ej28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tipo, marca, modelo;
		Scanner teclado = new Scanner(System.in);
		Vehiculo[] vehiculos = new Vehiculo[5];
		
		for(int i = 0; i < vehiculos.length; i++) {
			System.out.println("Vehiculo numero: " + (i+1));
			System.out.print("Tipo: ");
			tipo = teclado.nextLine();
			System.out.println("Modelo: ");
			modelo = teclado.nextLine();
			System.out.println("Marca: ");
			marca = teclado.nextLine();
			Vehiculo vehiculonew = new Vehiculo(tipo, modelo, marca);
			vehiculos[i] = vehiculonew;
		}
		
		for(Vehiculo vehiculonew : vehiculos) {
			System.out.println(vehiculonew.toString());
		}
	}

}
