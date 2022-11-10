package AE01;

import javax.swing.JOptionPane;

public class Procesadora implements Runnable {

	private int cantidad;
	private String tipo;
	private int numTotal;
	
	public Procesadora(int cantidad, String tipo,int numTotal) {
		this.cantidad = cantidad;
		this.tipo = tipo;
		this.numTotal = numTotal;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getNumTotal() {
		return numTotal;
	}

	public void setNumTotal(int numTotal) {
		this.numTotal = numTotal;
	}
	
	public String crearCroqueta(Procesadora pro) {
		String mensaje = "";
		try {
			if(pro.getNumTotal() <= 100) {
				switch (pro.getTipo()) {
					case "jamón":
						mensaje += "Creando croqueta de jamón";
						Thread.sleep(5000);
						mensaje += "Croqueta de jamón finalizada";
					break;
					case "pollo":
						mensaje += "Creando croqueta de pollo";
						Thread.sleep(6000);
						mensaje += "Croqueta de pollo finalizada";
					break;
					case "bacalao":
						mensaje += "Creando croqueta de bacalao";
						Thread.sleep(7000);
						mensaje += "Croqueta de bacalao finalizada";
					break;	
					case "queso":
						mensaje += "Creando croqueta de queso";
						Thread.sleep(8000);
						mensaje += "Croqueta de queso finalizada";
					break;	
				}
			}else {
				JOptionPane.showMessageDialog(null, "Numero de hilos máximos sobrepasados");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mensaje;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	}

}
