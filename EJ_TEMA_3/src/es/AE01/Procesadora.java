package EJ_TEMA_3.src.es.AE01;

public class Procesadora {
	
	public void crearCroqueta(Lanzadora lanz) {
		try {
			if(lanz.getNumCroquetas() <= 100) {
				switch (lanz.getTipoCroqueta()) {
					case "jamón":
						System.out.println("Creando croqueta de jamón...");
						Thread.sleep(5000);
						System.out.println("Croqueta de jamón finalizada");
					break;
					case "pollo":
						System.out.println("Creando croqueta de pollo...");
						Thread.sleep(6000);
						System.out.println("Croqueta de pollo finalizada");
					break;
					case "bacalao":
						System.out.println("Creando croqueta de bacalao...");
						Thread.sleep(7000);
						System.out.println("Croqueta de bacalao finalizada");
					break;
					case "queso":
						System.out.println("Creando croqueta de queso...");
						Thread.sleep(8000);
						System.out.println("Croqueta de queso finalizada");
					break;
					
				}
			}else {
				System.out.println("Numero de hilos máximos sobrepasados");
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
