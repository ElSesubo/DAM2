package es.florida.ej;

public class ej34 {
	
	public static void main(String[] args) {
		long factorial = 1;
		int num = 15;
		for (int i = num; i >= 1; i--) {
			factorial += i;
		}
		
		System.out.println("Número factorial de " + num + " es: " + factorial);
	}

}
