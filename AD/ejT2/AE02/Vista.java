package ejT2.AE02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Vista extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
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
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(180, 103, 451, 355);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnMostrarInfo = new JButton("Mostrar Informació");
		btnMostrarInfo.setBounds(26, 103, 132, 41);
		contentPane.add(btnMostrarInfo);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(180, 34, 451, 46);
		contentPane.add(scrollPane_1);
		
		textField = new JTextField();
		scrollPane_1.setViewportView(textField);
		textField.setColumns(10);
		
		JButton btnRealitarConsulta = new JButton("Realitzar consulta");
		btnRealitarConsulta.setBounds(26, 34, 132, 41);
		contentPane.add(btnRealitarConsulta);
		
		JButton btnTancarConexi = new JButton("Tancar Conexió");
		btnTancarConexi.setBounds(26, 417, 132, 41);
		contentPane.add(btnTancarConexi);
	}
}
