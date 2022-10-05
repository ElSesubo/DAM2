package es.florida.ejT1.ej2_9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Controlador {
	
	private Vista vista;
	private Model model;
	static File archivo = new File("./sus.txt");
	static File archivocopy = new File("./sus_copy.txt");
	
	public Controlador(Vista vista, Model model) {
		this.vista = vista;
		this.model = model;
		initEventHandler();
	}

	private void initEventHandler() {
		// TODO Auto-generated method stub
		vista.textArea.append(model.mostrarContenido(archivo));
		
		ActionListener escucha = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.buscarPalabra(vista.txfBuscar.getText());
			}
		};
		
		ActionListener reescribe = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.reemplazarPalabra(vista.txfBusqueda.getText(), vista.txfReemplazo.getText());
				vista.textArea_1.setText("");
				vista.textArea_1.append(model.mostrarContenido(archivocopy));
			}
			
		};
		
		vista.btnBuscar.addActionListener(escucha);
		vista.btnReemplazar.addActionListener(reescribe);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
