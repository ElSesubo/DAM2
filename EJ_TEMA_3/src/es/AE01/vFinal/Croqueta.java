package AE01;

public class Croqueta implements Runnable {

	private String tipo;

	/**
	 * Contructor de la croqueta
	 * @param tipo tipo de croqueta
	 */
	public Croqueta(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return this.tipo;
	}

	/**
	 * Dependiendo del tipo creara una croqueta u otra
	 * @param c Objeto croqueta pasado desde la clase Procesadora
	 */
	synchronized public void crearCroqueta(Croqueta c) {
		try {
			switch (c.tipo) {
			case "jamón":
				System.out.println("Creando croqueta de jamón");
				Thread.sleep(5000);
				System.out.println("Croqueta de jamón finalizada" + "\n");
				break;

			case "pollo":
				System.out.println("Creando croqueta de pollo");
				Thread.sleep(6000);
				System.out.println("Croqueta de pollo finalizada" + "\n");
				break;

			case "bacalao":
				System.out.println("Creando croqueta de bacalao");
				Thread.sleep(7000);
				System.out.println("Croqueta de bacalao finalizada" + "\n");
				break;

			case "queso":
				System.out.println("Creando croqueta de queso");
				Thread.sleep(8000);
				System.out.println("Croqueta de queso finalizada" + "\n");
				break;
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		Croqueta c = new Croqueta(this.tipo);
		crearCroqueta(c);

	}

}

