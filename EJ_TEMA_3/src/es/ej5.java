package es.florida.ej;

public class ej5 {

	private static Thread[] hilos;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int numHilos = 30;
		hilos = new Thread[numHilos];
		PolloKFC ca;
		int consumoTotal = 0;
		int alitasAleatorias;
		for(int i = 0; i < numHilos; i++) {
			alitasAleatorias = (int) (Math.random()*9 + 1);
			ca = new PolloKFC("Jaime" + (i+1), alitasAleatorias);
			consumoTotal = ca.getConsumoTotal();
			hilos[i] = new Thread(ca);
			hilos[i].start();
//			try {
//				hilos[i].join();
//			} catch (Exception e) {
//				System.out.println(e);
//			}
		}
		Thread.sleep(1000);
		System.out.println("Alitas totales consumidas: " + consumoTotal);
	}
}
