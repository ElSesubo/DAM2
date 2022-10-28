package es.florida.ej;

public class PolloKFC implements Runnable{

	private static int consumoTotal = 0;
	private static int alitas = 100;
	private String nombre;
	private int cantidadAlitas;
	
	public PolloKFC(String nombre, int cantidadAlitas) {
		this.nombre = nombre;
		this.cantidadAlitas = cantidadAlitas;
	}
	
	public static int getConsumoTotal() {
		return consumoTotal;
	}

	public static void setConsumoTotal(int consumoTotal) {
		PolloKFC.consumoTotal = consumoTotal;
	}
	
	public static int getAlitas() {
		return alitas;
	}

	public static void setAlitas(int alitas) {
		PolloKFC.alitas = alitas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidadAlitas() {
		return cantidadAlitas;
	}

	public void setCantidadAlitas(int cantidadAlitas) {
		this.cantidadAlitas = cantidadAlitas;
	}

	public void consumirAlitas() {
		if(this.cantidadAlitas <= this.alitas) {
			this.alitas = this.alitas - this.cantidadAlitas;
			System.out.println(nombre + " ha consumido: " + cantidadAlitas + " alitas restantes: " + this.alitas);
			this.consumoTotal = this.consumoTotal + this.cantidadAlitas;
		}else {
			System.out.println(nombre + " se ha quedado sin alitas :( ");
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		do {
			consumirAlitas();
		}while(this.cantidadAlitas <= this.alitas);
	}

}
