package es.florida.ej2;

import java.util.Scanner;

public class ej1 {
	
	public static int sumar(int num1, int num2) {
		int resultado = 0;
		for(int i = num1; i <= num2; i++) {
			resultado += i;
		}
		return resultado;
	}


	public static void main(String[] args) {
		int num1 = (int) (Math.random()*25+1);
		int num2 = (int) (Math.random()*25+25);
		System.out.println(sumar(num1, num2));
	}


}
