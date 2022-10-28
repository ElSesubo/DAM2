package es.florida.ej;

public class ej3 {
	
	private static Thread[] hilos;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numHilos = 5;
		hilos = new Thread[numHilos];
		Caracol ca;
		for(int i = 0; i < numHilos; i++) {
			ca = new Caracol(3 + i, "Caracol" + i);
			hilos[i] = new Thread(ca);
			hilos[i].start();
//			try {
//				hilos[i].join();
//			} catch (Exception e) {
//				System.out.println(e);
//			}
		}
	}

}
