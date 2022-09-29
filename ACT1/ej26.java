package es.florida.ej;

import java.util.Scanner;

public class ej26 {
	
	static Integer acuSuspendidos = 0;
	static Integer acuAprobados = 0;
	static Integer acuNotables = 0;
	static Integer acuSobresalientes = 0;
	static Integer acuMatriculas = 0;

	public static void Nota(Integer nota) {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado;
		Integer nota;
		
		for(int i = 0; i < 5; i++) {
			teclado = new Scanner(System.in);
			System.out.print("Nota " + (i+1) + ": ");
			nota = Integer.parseInt(teclado.nextLine());
			Nota(nota);
		}
		
		System.out.println("Total suspendidos: " + acuSuspendidos);
		System.out.println("Total aprobados: " + acuAprobados);
		System.out.println("Total notables: " + acuNotables);
		System.out.println("Total sobresalientes: " + acuSobresalientes);
		System.out.println("Total matriculas: " + acuMatriculas);
	}
}
