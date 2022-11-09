package AE02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Controlador {
	private static Vista vista;
	private static Model model;
	
	public Controlador(Vista vista, Model model) {
		this.vista = vista;
		this.model = model;
		try {
			InitEventHandler();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void InitEventHandler() {
		if(model.conexion == null) {
			vista.btnTancarConexio.setEnabled(true);
			vista.btnReconectar.setEnabled(false);
		}else {
			vista.btnTancarConexio.setEnabled(false);
			vista.btnReconectar.setEnabled(true);
		}
		
		ActionListener escucha = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tablas = model.nomTablas("dam2");
				String[] opciones = tablas.split(" ");
		        String tabla = (String)JOptionPane.showInputDialog(null, "Nom de la taula a visualitzar", 
		                "Elegir taula", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
				String text = model.mostrarContingut(tabla, model.numColumnas(tabla));
				
				vista.textArea.setText(text);
			}
		};
		
		ActionListener cerrarS = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vista.textArea.setText("");
				model.cierraConexion();
				if(model.conexion == null) {
					vista.btnTancarConexio.setEnabled(true);
					vista.btnReconectar.setEnabled(false);
				}else {
					vista.btnTancarConexio.setEnabled(false);
					vista.btnReconectar.setEnabled(true);
				}
			}
		};
		
		ActionListener abrirS = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.Conexion(null, null, null);
				if(model.conexion == null) {
					vista.btnTancarConexio.setEnabled(true);
					vista.btnReconectar.setEnabled(false);
				}else {
					vista.btnTancarConexio.setEnabled(false);
					vista.btnReconectar.setEnabled(true);
				}
			}
		};
		
		ActionListener realizarConsulta = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] opciones = {"SELECT", "OTROS"};
		        String tabla = (String)JOptionPane.showInputDialog(null, "Nom de la taula a visualitzar", 
		                "Elegir taula", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		        if(tabla.equals("SELECT")) {
		        	vista.textArea.setText(model.realizarCSelect(vista.textField.getText()));
		        	vista.textField.setText("");
		        }else {
		        	model.realizarCIUD(vista.textField.getText());
		        	vista.textField.setText("");
		        }
			}
		};
		
		try {
			String base = null, pass = null, user = null;
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = (Document) dBuilder.parse(new File("./conexion.xml"));
			NodeList nodeList = document.getElementsByTagName("conexion");
			for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					base = eElement.getElementsByTagName("base").item(0).getTextContent();
					user = eElement.getElementsByTagName("user").item(0).getTextContent();
					pass = eElement.getElementsByTagName("pass").item(0).getTextContent();
				}
			}
		   if(model.Conexion(base, user, pass) != null) {
			   if(login() == true) {
				   vista.btnRealitzarConsulta.addActionListener(realizarConsulta);
				   vista.btnMostrarInfo.addActionListener(escucha);
				   vista.btnTancarConexio.addActionListener(cerrarS);
			   }
		   }else {
			   JOptionPane.showMessageDialog(null, "Error al conectar amb la base de dades");
		   }
		} catch (Exception ex) {
			ex.printStackTrace();
	    }
	}
	
	public static boolean login() throws Exception {
		boolean correcte = false;
		JTextField usu= new JTextField();
		JTextField pass = new JTextField();
		
		Object[] fields = {
				"Usuari: ", usu,
				"Contrasenya: ", pass
		};   		
		int opcion = JOptionPane.showConfirmDialog(null,fields,"Iniciar sesió",JOptionPane.OK_CANCEL_OPTION);
		if (opcion == JOptionPane.OK_OPTION)
		{
		    String value1 = usu.getText();
		    String value2 = model.Encrypt(pass.getText());
		    if(model.comprobarLogin(value1, value2) == false) {
		    	JOptionPane.showMessageDialog(null, "Contrasenya o usuari incorrectes");
		    	login();
		    }else {
		    	correcte = true;
		    }
		}else {
			System.exit(0);
		}
		return correcte;
	}
}
