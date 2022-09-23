package es.florida.ej; 

import java.util.Scanner;

public class ej24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		System.out.println("Dime un numero entre 1 y 10: ");
		Integer num = Integer.parseInt(teclado.nextLine());
		Integer numRan = (int) (Math.random()*10+1);
		
		if(numRan == num) {
			System.out.println("Has ganado");
		}else {
			System.out.println("Has perdido");
		}
	}

}
