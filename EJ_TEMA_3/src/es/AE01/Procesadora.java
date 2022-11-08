package es.florida.ej.AE01;

import javax.swing.JOptionPane;

public class Procesadora implements Runnable {
	
	Lanzadora lanz;
	private int numCroquetas;
	private String tipoCroqueta;
	
	public Procesadora(int numCroquetas, String tipoCroqueta) {
		this.numCroquetas = numCroquetas;
		this.tipoCroqueta = tipoCroqueta;
	}
	
	public int getNumCroquetas() {
		return numCroquetas;
	}

	public void setNumCroquetas(int numCroquetas) {
		this.numCroquetas = numCroquetas;
	}

	public String getTipoCroqueta() {
		return tipoCroqueta;
	}

	public void setTipoCroqueta(String tipoCroqueta) {
		this.tipoCroqueta = tipoCroqueta;
	}
	
	public String crearCroqueta(Procesadora pro) {
		String mensaje = "";
		try {
			if(pro.getNumCroquetas() <= 100) {
				switch (pro.getTipoCroqueta()) {
					case "jamón":
						mensaje = "Creando croqueta de jamón...";
						Thread.sleep(5000);
						mensaje += "\nCroqueta de jamón finalizada";
					break;
					case "pollo":
						lanz.textArea.append("Creando croqueta de pollo...");
						Thread.sleep(6000);
						lanz.textArea.append("Croqueta de pollo finalizada");
					break;
					case "bacalao":
						lanz.textArea.append("Creando croqueta de bacalao...");
						Thread.sleep(7000);
						lanz.textArea.append("Croqueta de bacalao finalizada");
					break;
					case "queso":
						lanz.textArea.append("Creando croqueta de queso...");
						Thread.sleep(8000);
						lanz.textArea.append("Croqueta de queso finalizada");
					break;		
				}
			}else {
				JOptionPane.showMessageDialog(lanz, "Numero de hilos máximos sobrepasados");
			}
		}catch(InterruptedException e) {
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
