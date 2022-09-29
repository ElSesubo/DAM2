package es.florida.ej;

import java.util.ArrayList;

public class ej32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] nombre = new String[6];
		ArrayList<String> nombres = new ArrayList<String>();
		
		nombre[0] = "haitian";
		nombre[1] = "pablo";
		nombre[2] = "diego";
		nombre[3] = "merino";
		nombre[4] = "jaime";
		nombre[5] = "santi";
		
		System.out.println("Recorriendo Array: ");
		
		for(int i = 0; i < nombre.length; i++) {
			System.out.println(nombre[i]);
			nombres.add(nombre[i]);
		}
		
		System.out.println("\nRecorriendo ArrayList: ");
		
		for (String nom : nombres) {
			  System.out.println(nom);
			}
	}

}
