package es.florida.ej;

public class CrearASCII implements Runnable {
	
	private int tipo;
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public CrearASCII(int tipo) {
		this.tipo = tipo;
	}
	
	/*public static void mostrarASCII(this.tipo) {
		
	}*/

	@Override
	public void run() {
		// TODO Auto-generated method stub
			System.out.println("Hilo: " + this.tipo);
			if(this.tipo == 2) {
				setTipo(0);
			}
			char I;
			int X;

			for(I=0;I<255;I++){
				if(I%2==this.tipo) {
					X=I;
					System.out.print("\n "+X+".-[ "+I+" ]");
					switch (I){
						case 10:
						case 20:
						case 30:
						case 40:
						case 50:
						case 60:
						case 70:
						case 80:
						case 90:
						case 100:
						case 110:
						case 120:
						case 130:
						case 140:
						case 150:
						case 160:
						case 170:
						case 180:
						case 190:
						case 200:
						case 210:
						case 220:
						case 230:
						case 240:
						case 250:
					System.out.println();
					}
				}
			}
		}
	}
