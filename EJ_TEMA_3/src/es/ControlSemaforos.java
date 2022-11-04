package es.florida.ej;

import java.util.LinkedList;

public class ControlSemaforos{
	
	public static class Semaforos {
		int encendido = 1;
		
		public void encenderSemaforo1() {
			while(true) {
				synchronized(this) {
					try {
						while(encendido == 2) wait();
						System.err.print("Semáforo 2 rojo ->");
						System.out.println(" Tiempo del semáforo 1 en verde: " + 5000/1000 + " segundos");
						Thread.sleep(5000);
						encendido = 2;
						notify();
					}catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		public void encenderSemaforo2() {
			while(true) {
				synchronized(this) {
					try {
						while(encendido == 1) wait();
						System.err.print("Semáforo 1 rojo ->");
						System.out.println(" Tiempo del semáforo 2 en verde: " + 5000/1000 + " segundos");
						Thread.sleep(5000);
						encendido = 1;
						notify();
					}catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Semaforos semaforo = new Semaforos();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				semaforo.encenderSemaforo1();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				semaforo.encenderSemaforo2();
			}
		});
		t1.start();
		t2.start();
	}
}
