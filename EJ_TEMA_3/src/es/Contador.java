package es.florida.ej;

public class Contador implements Runnable{
	
	private String nombreHilo;
	private int inicioContador;
	private int limiteContador;
	
	public Contador (String nombreHilo, int inicioContador, int limiteContador) {
		this.nombreHilo = nombreHilo;
		this.inicioContador = inicioContador;
		this.limiteContador = limiteContador;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(this.nombreHilo);
		for(int i = this.inicioContador; i < this.limiteContador; i++) {
			System.out.println(i);
		}
	}

}
