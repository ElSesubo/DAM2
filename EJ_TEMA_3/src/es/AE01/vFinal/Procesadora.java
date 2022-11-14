package AE01;

import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import AE01.Croqueta;

public class Procesadora {
	
	/**
	 * Realiza croquetas dependiendo de su prioridad
	 * @param args parametros pasados desde lanzadora
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.nanoTime();

		int croquetaJamon = Integer.parseInt(args[0]);
		int croquetaPollo = Integer.parseInt(args[1]);
		int croquetaQueso = Integer.parseInt(args[2]);
		int croquetaBacalao = Integer.parseInt(args[3]);
		String prioridad = args[4];
		Thread hilo;

		int totalHilos = croquetaJamon + croquetaPollo + croquetaQueso + croquetaBacalao;
		
		switch (prioridad) {
			case "jamón":
				totalHilos = hacerHilos(croquetaJamon, "jamón", totalHilos);
				break;
				
			case "pollo":
				totalHilos = hacerHilos(croquetaPollo, "pollo", totalHilos);
				break;
	
			case "bacalao":
				totalHilos = hacerHilos(croquetaBacalao, "bacalao", totalHilos);
				break;
	
			case "queso":
				totalHilos = hacerHilos(croquetaQueso, "queso", totalHilos);
				break;
			}
		
		totalHilos = hacerHilos(croquetaJamon, "jamón", totalHilos);
		totalHilos = hacerHilos(croquetaPollo, "pollo", totalHilos);
		totalHilos = hacerHilos(croquetaBacalao, "bacalao", totalHilos);
		totalHilos = hacerHilos(croquetaQueso, "queso", totalHilos);

		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		long total = TimeUnit.SECONDS.convert(totalTime, TimeUnit.NANOSECONDS);

		JOptionPane.showMessageDialog(null, "Tiempo total de fabricación: " + total + " segundos");
	}
	
	/**
	 * Se encarga de crear los hilos, también comprueba cuantos hilos hay activos, dependiendo del número realizara un Thread.sleep
	 * @param cant cantidad de croquetas
	 * @param nombre tipo de la croqueta
	 * @param totalHilos total de hilos
	 * @return total de hilos
	 */
	public static int hacerHilos(int cant, String nombre, int totalHilos) {
		Thread hilo;
		for (int i = 1; i <= cant; i++) {
			int count=Thread.activeCount();
			while(count==101) {
				try {
					System.out.println("Maximo de croquetas alcanzado");
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				count=Thread.activeCount();
			}
			Croqueta c = new Croqueta(nombre);
			hilo = new Thread(c);
			hilo.start();
			try {
				hilo.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			totalHilos--;
		}
		return totalHilos;
	}

}
