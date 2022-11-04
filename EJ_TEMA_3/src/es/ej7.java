package es.florida.ej;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class ej7 implements Runnable{
	
	String nombre;
	double velocidad;
	double distancia = 100;
	
	ej7(String nombre, double velocidad){
		this.nombre = nombre;
		this.velocidad = velocidad;
	}
	
	public static void main(String[] args) {
		File fichero = new File("fich_result.txt");
		int[] prioridad = {1,2,3,4,10};
		ej7 caracol;
		Thread hilo;
		
		for(int i = 0; i < 5; i++) {
			caracol = new ej7("Caracol " + i, 3);
			hilo = new Thread(caracol);
			hilo.setPriority(prioridad[i]);
			hilo.start();
		}
		
		boolean existe = false;
		FileReader fr;
		
		while(!existe) {
			try {
				fr = new FileReader("fich_result.txt");
				BufferedReader br = new BufferedReader(fr);
				String nombre = br.readLine();
				System.out.println("Ganador: " + nombre);
				br.close();
				fr.close();
				existe = true;
			}catch(IOException io) {
				io.printStackTrace();
			}
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		DecimalFormat formato1 = new DecimalFormat("#.00");
		
		double velocidad = 0;
		double porcentaje = 0;
		do {
			porcentaje = (velocidad * 100)/70;
			System.out.println(nombre + ": " + formato1.format(porcentaje) + "%");
			velocidad++;
		}while(velocidad < 70);
	}

}
