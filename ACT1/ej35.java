package es.florida.ej;

public class ej35{

	public static int numMayor(int[] numeros) {
		int mayor = 0;
		for(int i = 0; i < numeros.length; i++) {
			if(numeros[i] > mayor) {
				mayor = numeros[i];
			}
		}
		return mayor;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numeros = new int[5];
		
		numeros[0] = 2;
		numeros[1] = 5;
		numeros[2] = 12;
		numeros[3] = 3;
		numeros[4] = 543;
		
		System.out.println("El número más grande es: " + numMayor(numeros));
	}

}
