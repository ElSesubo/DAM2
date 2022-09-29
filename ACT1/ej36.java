package es.florida.ej;

import java.util.Arrays;

public class ej36 {
	public static int sumaNumeros(int[] numeros) {
		int[] invertido = new int[numeros.length];
		int suma = 0;
		
		for(int i = 0; i < numeros.length; i++) {
			suma += numeros[i];
		}
		
        for(int i=0;i<numeros.length;i++){
            invertido[i] = numeros[numeros.length-1-i];
        }
		System.out.println(Arrays.toString(invertido));
		return suma;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numeros = new int[5];
		
		numeros[0] = 2;
		numeros[1] = 5;
		numeros[2] = 12;
		numeros[3] = 3;
		numeros[4] = 543;
		
		System.out.println(sumaNumeros(numeros));
	}

}
