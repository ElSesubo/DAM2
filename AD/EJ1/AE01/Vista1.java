package AE01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.DropMode;
import java.awt.Color;

public class Vista1 extends JFrame {

	private JPanel contentPane;
	JTextField txfRuta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista1 frame = new Vista1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vista1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 404);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txfRuta = new JTextField();
		txfRuta.setEditable(false);
		txfRuta.setBounds(255, 22, 410, 20);
		contentPane.add(txfRuta);
		txfRuta.setColumns(10);
		
		JButton btnCopiar = new JButton("Copiar fitxer");
		btnCopiar.setBounds(10, 311, 178, 43);
		contentPane.add(btnCopiar);
		
		JButton btnCambiarNom = new JButton("Cambiar nom");
		btnCambiarNom.setBounds(10, 267, 178, 43);
		contentPane.add(btnCambiarNom);
		
		JButton btnCrear = new JButton("Crear fitxer");
		btnCrear.setBounds(10, 224, 178, 43);
		contentPane.add(btnCrear);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(199, 53, 466, 231);
		contentPane.add(textArea);
		
		JButton btnExplorador = new JButton("Obrir explorador");
		btnExplorador.setBounds(10, 182, 178, 43);
		contentPane.add(btnExplorador);
		
		JLabel lblNewLabel = new JLabel("Ruta:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(199, 22, 49, 20);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setEditable(false);
		textArea_2.setBounds(10, 20, 178, 151);
		contentPane.add(textArea_2);
		
		JButton btnEscriure = new JButton("Escriure");
		btnEscriure.setBounds(198, 291, 89, 63);
		contentPane.add(btnEscriure);
		
		JButton btnReemplazar = new JButton("Reemplaçar");
		btnReemplazar.setBounds(297, 291, 89, 63);
		contentPane.add(btnReemplazar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(396, 291, 89, 63);
		contentPane.add(btnBuscar);
		
		JButton btnSuprimir = new JButton("Suprimir");
		btnSuprimir.setBounds(495, 291, 89, 63);
		contentPane.add(btnSuprimir);
		
		JButton btnGuardar = new JButton("G");
		btnGuardar.setBounds(594, 291, 71, 63);
		contentPane.add(btnGuardar);
	}
}
