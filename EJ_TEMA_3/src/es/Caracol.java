
package es.florida.ej;

import java.text.DecimalFormat;

public class Caracol implements Runnable{
	
	private double velocidad;
	private String nombre;
	private static int ganadores = 0;
	
	public Caracol(double velocidad, String nombre) {
		this.velocidad = velocidad;
		this.nombre = nombre;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		DecimalFormat formato1 = new DecimalFormat("#.00");
		double porcentaje;
		do {
			porcentaje = (velocidad * 100)/70;
			System.out.println(nombre + ": " + formato1.format(porcentaje) + "%");
			velocidad++;
		}while(velocidad < 70);
		System.out.println(nombre + " ha finalizado la carrera");
	}

}
