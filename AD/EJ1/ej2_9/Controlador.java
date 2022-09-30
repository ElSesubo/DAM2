package es.florida.ejT1.ej2_9;

public class Controlador {
	
	private Vista vista;
	private Model model;
	
	public Controlador(Vista vista, Model model) {
		this.vista = vista;
		this.model = model;
		initEventHandler();
	}

	private void initEventHandler() {
		// TODO Auto-generated method stub
		vista.textArea.append(model.mostrarContenido());
		model.reemplazarPalabra(null, null, null);
		model.buscarPalabra(null, null);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
