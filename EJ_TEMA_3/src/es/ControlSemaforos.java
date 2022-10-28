package es.florida.ej;

import java.util.LinkedList;

public class ControlSemaforos{
	
	public static class Semaforos {
		boolean encendido;
		
		public void encender() throws InterruptedException {
			while(true) {
				synchronized(this) {
					encendido = true;
					System.out.println("Semaforo encendido");
					notify();
					Thread.sleep(1000);
				}
			}
		}
		
		public void apagar() throws InterruptedException {
			while(true) {
				synchronized(this) {
					encendido = false;
					System.out.println("Semaforo apagado");
					notify();
					Thread.sleep(1000);
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final Semaforos semaforo = new Semaforos();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					semaforo.encender();
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					semaforo.apagar();
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}
}
