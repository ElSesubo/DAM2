package es.florida.ej;

import java.util.ArrayList;
import java.util.Scanner;

public class ej25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		Integer num;
		Integer numRan;
		ArrayList<Integer> cadena = new ArrayList<Integer>();
		ArrayList<Integer> cadenaRan = new ArrayList<Integer>();
		
		for(int i = 1; i < 4; i++) {
			System.out.println("Dime un numero entre 1 y 10: ");
			num = Integer.parseInt(teclado.nextLine());
			numRan = (int) (Math.random()*10+1);
			cadena.add(num);
			cadenaRan.add(numRan);
		}
		for(int i = 0; i < cadena.size(); i++) {
			if(cadena.get(i) == cadenaRan.get(i)) {
				System.out.println("Has ganado");
			}else {
				System.out.println("Has perdido");
			}
		}
	}

}
