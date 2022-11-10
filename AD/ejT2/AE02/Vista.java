package ejT2.AE02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;

public class Vista extends JFrame {

	JFrame frame;
	JTextField textField;
	JTextArea textArea;
	JButton btnTancarConexio;
	JButton btnMostrarInfo;
	JButton btnRealitzarConsulta;
	JButton btnReconectar;
	
	public Vista() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 633, 533);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(195, 119, 391, 355);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		btnTancarConexio = new JButton("Tancar Conexió");
		btnTancarConexio.setBounds(35, 436, 135, 38);
		frame.getContentPane().add(btnTancarConexio);
		
		btnMostrarInfo = new JButton("Mostrar Info");
		btnMostrarInfo.setBounds(35, 121, 135, 38);
		frame.getContentPane().add(btnMostrarInfo);
		
		btnRealitzarConsulta = new JButton("Realitzar Consulta");
		btnRealitzarConsulta.setBounds(35, 70, 135, 38);
		frame.getContentPane().add(btnRealitzarConsulta);
		
		textField = new JTextField();
		textField.setBounds(195, 70, 391, 38);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CONSULTES A BASE DE DADES");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel.setBounds(195, 26, 202, 14);
		frame.getContentPane().add(lblNewLabel);
		
		btnReconectar = new JButton("Reconectar");
		btnReconectar.setBounds(35, 170, 135, 38);
		frame.getContentPane().add(btnReconectar);
		
		this.frame.setVisible(true);
	}
}
