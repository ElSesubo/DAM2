package es.florida.ej;

import java.util.Scanner;

public class ej12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado;
		Integer acuSuspendidos = 0;
		Integer acuAprobados = 0;
		Integer acuNotables = 0;
		Integer acuSobresalientes = 0;
		Integer acuMatriculas = 0;
		Integer nota;
		
		for(int i = 0; i < 5; i++) {
			teclado = new Scanner(System.in);
			System.out.print("Nota " + (i+1) + ": ");
			nota = Integer.parseInt(teclado.nextLine());
			if(nota < 0) {
				System.out.println("No se pueden poner valores negativos");
			}else {
				if(nota >= 0 && nota <= 4) {
					acuSuspendidos++;
				}else if(nota > 4 && nota <= 6) {
					acuAprobados++;
				}else if(nota > 6 && nota <= 8) {
					acuNotables++;
				}else if(nota > 9 && nota < 10) {
					acuSobresalientes++;
				}else {
					acuMatriculas++;
				}
			}
		}
		
		System.out.println("Total suspendidos: " + acuSuspendidos);
		System.out.println("Total aprobados: " + acuAprobados);
		System.out.println("Total notables: " + acuNotables);
		System.out.println("Total sobresalientes: " + acuSobresalientes);
		System.out.println("Total matriculas: " + acuMatriculas);
		
	}

}
