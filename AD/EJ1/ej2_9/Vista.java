package es.florida.ejT1.ej2_9;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vista extends JFrame {
	JFrame frame;
	JTextField txfBuscar;
	JTextField txfBusqueda;
	JTextField txfReemplazo;
	JButton btnBuscar;
	JButton btnReemplazar;
	JTextArea textArea;
	JTextArea textArea_1;

	
	public Vista() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 747, 353);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 214, 686, 87);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(10, 17, 126, 26);
		panel_1.add(btnBuscar);
		
		btnReemplazar = new JButton("Remplazar");
		btnReemplazar.setBounds(350, 17, 126, 26);
		panel_1.add(btnReemplazar);
		
		txfBuscar = new JTextField();
		txfBuscar.setColumns(10);
		txfBuscar.setBounds(146, 17, 188, 26);
		panel_1.add(txfBuscar);
		
		txfBusqueda = new JTextField();
		txfBusqueda.setColumns(10);
		txfBusqueda.setBounds(482, 17, 194, 26);
		panel_1.add(txfBusqueda);
		
		txfReemplazo = new JTextField();
		txfReemplazo.setColumns(10);
		txfReemplazo.setBounds(482, 50, 194, 26);
		panel_1.add(txfReemplazo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(20, 24, 338, 179);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 11, 318, 156);
		panel_2.add(textArea);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(368, 24, 338, 179);
		frame.getContentPane().add(panel_2_1);
		
		textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(10, 11, 318, 156);
		panel_2_1.add(textArea_1);
		
		this.frame.setVisible(true);
	}
}
