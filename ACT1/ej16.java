package es.florida.ej;

import java.util.Date;
import java.util.Scanner;

public class ej16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		System.out.print("Dia: ");
		Integer dia = Integer.parseInt(teclado.nextLine());
		System.out.print("Mes: ");
		Integer mes = Integer.parseInt(teclado.nextLine());
		System.out.print("Año: ");
		Integer anyo = Integer.parseInt(teclado.nextLine());
		Integer pero = 0;
		Integer otro = 0;
		
		String suma = String.valueOf(dia + mes + anyo);
		for(int i=0;i<suma.length();i++){
			otro = (int) suma.charAt(i);
			pero += otro;
	    }
		
		System.out.println("Tu numero de la suerte es: " + pero);
 	}
	

}
