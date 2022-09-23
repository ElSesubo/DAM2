package es.florida.ej;

import java.util.Scanner;

public class ej17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		System.out.print("Contraseña: ");
		String contra = teclado.nextLine();
		Integer mayusculas = 0;
		Integer numeros = 0;
		
		for(int i=0;i<contra.length();i++){
	    	if(Character.isUpperCase(contra.charAt(i))){
	    		mayusculas++;
	    	}
	    	if(Character.isDigit(contra.charAt(i))) {
    			numeros++;
	    	}
	    }
		if(contra.length() < 5) {
			System.out.println("La contraseña no se compone como minimo de 5 caracteres");
		}else {
			System.out.println("El tamaño de la contraseña es correcto");
		}
		
		if(mayusculas > 0) {
			System.out.println("La contraseña contine mayusculas");
		}else {
			System.out.println("La contraseña no contine mayusculas");
		}
		
		if(numeros > 0) {
			System.out.println("La contraseña contiene números");
		}else{
			System.out.println("La contraseña no contiene números");
		}
	}
}
