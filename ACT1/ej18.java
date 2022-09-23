package es.florida.ej;

import java.util.Scanner;

public class ej18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado;
		String contra;
		Integer mayusculas;
		Integer numeros;
		boolean correctoL = false;
		boolean correctoM = false;
		boolean correctoN = false;
		
		while(correctoL == false || correctoM == false || correctoN == false) {
			teclado = new Scanner(System.in);
			System.out.print("Contraseña: ");
			contra = teclado.nextLine();
			mayusculas = 0;
			numeros = 0;
			correctoL = false;
			correctoM = false;
			correctoN = false;
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
				correctoL = true;
			}else {
				System.out.println("El tamaño de la contraseña es correcto");
			}
			
			if(mayusculas > 0) {
				System.out.println("La contraseña contine mayusculas");
				correctoM = true;
			}else {
				System.out.println("La contraseña no contine mayusculas");
			}
			
			if(numeros > 0) {
				System.out.println("La contraseña contiene números");
				correctoN = true;
			}else{
				System.out.println("La contraseña no contiene números");
			}
		}
	}

}
