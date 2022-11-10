package AE01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Lanzadora extends JFrame {

	private JPanel contentPane;
	ArrayList<Integer> cantidades = new ArrayList<Integer>();
	ArrayList<String> tipos = new ArrayList<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lanzadora frame = new Lanzadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private static Thread[] hilos; 

	/**
	 * Create the frame.
	 */
	public Lanzadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tipo:");
		lblNewLabel.setBounds(27, 52, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(27, 86, 57, 14);
		contentPane.add(lblCantidad);
		
		JComboBox cbTipo = new JComboBox();
		cbTipo.setBounds(58, 48, 77, 22);
		contentPane.add(cbTipo);
		
		JSpinner spCantidad = new JSpinner();
		spCantidad.setBounds(78, 83, 57, 20);
		contentPane.add(spCantidad);
		
		JButton btnAnadir = new JButton("Añadir");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cant = (Integer) spCantidad.getValue();
				String tipo = (String) cbTipo.getSelectedItem();
				cantidades.add(cant);
				tipos.add(tipo);
			}
		});
		btnAnadir.setBounds(38, 206, 89, 23);
		contentPane.add(btnAnadir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(149, 47, 263, 150);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnFabricar = new JButton("Fabricar");
		btnFabricar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numHilos = 0;
				for(int i = 0; i < cantidades.size(); i++) {
					numHilos += cantidades.get(i);
				}
				hilos = new Thread[numHilos];
				Procesadora pro;
				for(int i = 0; i < numHilos; i++) {
					pro = new Procesadora(cantidades.get(i), tipos.get(i), numHilos);
					hilos[i] = new Thread(pro);
					hilos[i].start();
//					try {
//						hilos[i].join();
//					} catch (Exception ex) {
//						System.out.println(ex);
//					}
				}
			}
		});
		btnFabricar.setBounds(323, 206, 89, 23);
		contentPane.add(btnFabricar);
	}

}
