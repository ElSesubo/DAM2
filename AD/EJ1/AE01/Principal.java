package AE01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Principal {
	Vista1 vista = new Vista1();
	File archivo;
	String ruta;
	int lineasTotales;
	int totalCoincidencias;
	
	public Principal(Vista1 vista) {
		this.vista = vista;
		initEventHandler();
	}
	
	ActionListener escucha = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			abrirExplorador();
		}
	};
	
	public void buscarPalabra(String palabra) {
		try {
			if(palabra.isEmpty()) {
				JOptionPane.showMessageDialog(null, "El campo de texto está vacío");
			}else {
				if(archivo.exists()) {
	            	lineasTotales = 0;
	            	totalCoincidencias = 0;
	                BufferedReader leerArchivo = new BufferedReader(new FileReader(archivo));
	                String lineaLeida;
	                while((lineaLeida = leerArchivo.readLine()) != null) {
	                    lineasTotales = lineasTotales + 1;
	                    String[] palabras = lineaLeida.split(" ");
	                    for(int i = 0 ; i < palabras.length ; i++) {
	                        if(palabras[i].equals(palabra)) {
	                            totalCoincidencias = totalCoincidencias + 1;
	                        }
	                    }
	                }
	            }
	            JOptionPane.showMessageDialog(null, "En total se encotro la palabra: " + palabra + ", " + totalCoincidencias + " Veces en el archivo");
	            vista.txfRuta.setText("");
			}
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
	}
	
	public void abrirExplorador() {
		JFileChooser jf = new JFileChooser();
		jf.showOpenDialog(vista);
		File archivo = jf.getSelectedFile();
		if(archivo != null) {
			vista.txfRuta.setText(archivo.getAbsolutePath());
		}
	}
	
	private void initEventHandler() {
		vista.btnNewButton_1.addActionListener(escucha);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
