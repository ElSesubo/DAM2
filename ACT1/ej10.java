package es.florida.ej;

import java.util.Scanner;

public class ej10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		System.out.print("Dime el número de un mes: ");
		Integer num = Integer.parseInt(teclado.nextLine());
		if(num >= 1 && num <= 12) {
			switch(num) {
				case 1:
					System.out.println("Enero");
				case 2:
					System.out.println("Febrero");
				case 3:
					System.out.println("Marzo");
				case 4:
					System.out.println("Abril");
				case 5:
					System.out.println("Mayo");
				case 6:
					System.out.println("Junio");
				case 7:
					System.out.println("Julio");
				case 8:
					System.out.println("Agosto");
				case 9:
					System.out.println("Septiembre");
				case 10:
					System.out.println("Octubre");
				case 11:
					System.out.println("Noviembre");
				case 12:
					System.out.println("Diciembre");
			}
		}else {
			System.out.println(num + " no pertenece a ningún mes del año");
		}
	}

}
