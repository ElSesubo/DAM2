package es.florida.ej2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ej8 {
	static String archivo = "./Ejercicios_T2_Multiproceso_NEOs.txt";
	
	public static void leerInformacion() {
		try(FileReader fileReader = new FileReader(archivo)){
	        int caracterLeido = fileReader.read();
	        while(caracterLeido!= -1) {
	            char caracter = (char) caracterLeido;
	            System.out.print(caracter);
	            caracterLeido = fileReader.read();
	        }
	    }catch(IOException ex){
	        System.err.println("Error al leer el archivo");
	        ex.printStackTrace();
	    }
	}
	
	public static void probabilidadColision() {
		// usar split para sacar las cosas
		BufferedReader leerArchivo = new BufferedReader(new FileReader(archivo));
        String lineaLeida;
        while((lineaLeida = leerArchivo.readLine()) != null) {
            String[] campos = lineaLeida.split(",");
            for(int i = 0 ; i < campos.length ; i++) {
            	System.out.println(campos[i]);
            }
        }
        
		double posicionTierra = 1;
		double velocidadTierra = 100;
		for (int i = 0; i < (50 * 365 * 24 * 60 * 60); i++) {
		posicionNEO = posicionNEO + velocidadNEO * i;
		posicionTierra = posicionTierra + velocidadTierra * i;
		}
		double resultado = 100 * Math.random() *
		Math.pow( ((posicionNEO-posicionTierra)/(posicionNEO+posicionTierra)), 2);
	}
	
	public static void guardarPosibilidad() {
		
	}
	
	public static void avisoMundial() {
		
	}
	
	public static void tiempoEjecucion() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		leerInformacion();
	}

}
