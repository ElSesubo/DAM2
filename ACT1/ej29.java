package es.florida.ej;

import java.util.ArrayList;
import java.util.Scanner;

public class ej29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tipo, marca, modelo, eleccion;
		Scanner teclado = new Scanner(System.in);
		int contador = 1;
		boolean continuar = false;
		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		
		do {
			System.out.println("Vehiculo numero: " + (contador));
			System.out.print("Tipo: ");
			tipo = teclado.nextLine();
			System.out.print("Modelo: ");
			modelo = teclado.nextLine();
			System.out.print("Marca: ");
			marca = teclado.nextLine();
			Vehiculo vehiculonew = new Vehiculo(tipo, modelo, marca);
			vehiculos.add(vehiculonew);
			System.out.println("Quieres continuar? (Y/N) ");
			eleccion = teclado.nextLine();
			if(eleccion.equals("Y") || eleccion.equals("y")) {
				contador++;
			}else {
				continuar = true;
			}
		}while(continuar != true);
		
		for(Vehiculo vehiculonew : vehiculos) {
			System.out.println(vehiculonew.toString());
		}
	}

}
