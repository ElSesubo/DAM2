package es.florida.ejT1.ej2_9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		model.reemplazarPalabra(null, null);
		
		ActionListener escucha = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.buscarPalabra(vista.txfBuscar.getText());
			}
		};
		
		vista.btnBuscar.addActionListener(escucha);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
