package AE01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Lanzadora extends JFrame {

	private JPanel contentPane;
	private static int croquetasJamon;
	private static int croquetasPollo;
	private static int croquetasQueso;
	private static int croquetasBacalao;
	JComboBox cbTipo;
	JSpinner spCant;
	JTextArea textArea;
	JComboBox cbPrioridad;
	JCheckBox chPaquete;
	
	/**
	 * A través de processBuilder, enviamos los parametros a la clase Procesadora
	 * @param prioridad
	 */
	public static void lanzarProcesadora(String prioridad) {
		try {

			String clase = "AE01.Procesadora";
			String javaHome = System.getProperty("java.home");
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");

			List<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(clase);
			command.add(croquetasJamon + "");
			command.add(croquetasPollo + "");
			command.add(croquetasQueso + "");
			command.add(croquetasBacalao + "");
			command.add(prioridad);

			ProcessBuilder builder = new ProcessBuilder(command);
			Process p = builder.inheritIO().start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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

	/**
	 * Create the frame.
	 */
	public Lanzadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAnadir = new JButton("Añadir");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chPaquete.isSelected()) {
					String tipo = cbTipo.getSelectedItem().toString();
					int cantidad = (int) spCant.getValue();
					switch (tipo) {
						case "jamón":
							croquetasJamon += cantidad*6;
							textArea.append(cantidad*6 + " croquetas de jamón" + "\n");
							break;
			
						case "pollo":
							croquetasPollo += cantidad*6;
							textArea.append(cantidad*6 + " croquetas de pollo" + "\n");
							break;
			
						case "bacalao":
							croquetasBacalao += cantidad*6;
							textArea.append(cantidad*6 + " croquetas de bacalao" + "\n");
							break;
			
						case "queso":
							croquetasQueso += cantidad*6;
							textArea.append(cantidad*6 + " croquetas de queso" + "\n");
							break;
					}
				}else {
					String tipo = cbTipo.getSelectedItem().toString();
					int cantidad = (int) spCant.getValue();
					switch (tipo) {
						case "jamón":
							croquetasJamon += cantidad;
							textArea.append(cantidad + " croquetas de jamón" + "\n");
							break;
			
						case "pollo":
							croquetasPollo += cantidad;
							textArea.append(cantidad + " croquetas de pollo" + "\n");
							break;
			
						case "bacalao":
							croquetasBacalao += cantidad;
							textArea.append(cantidad + " croquetas de bacalao" + "\n");
							break;
			
						case "queso":
							croquetasQueso += cantidad;
							textArea.append(cantidad + " croquetas de queso" + "\n");
							break;
					}
				}
			}
		});
		btnAnadir.setBounds(43, 227, 89, 23);
		contentPane.add(btnAnadir);
		
		JButton btnFabricar = new JButton("Fabricar");
		btnFabricar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lanzarProcesadora(cbPrioridad.getSelectedItem().toString());
				textArea.setText(null);
				croquetasJamon = 0;
				croquetasPollo = 0;
				croquetasBacalao = 0;
				croquetasQueso = 0;
				cbPrioridad.setSelectedIndex(0);
			}
		});
		btnFabricar.setBounds(313, 227, 89, 23);
		contentPane.add(btnFabricar);
		
		cbTipo = new JComboBox();
		cbTipo.setBounds(75, 62, 72, 22);
		contentPane.add(cbTipo);
		cbTipo.addItem("jamón");
		cbTipo.addItem("pollo");
		cbTipo.addItem("bacalao");
		cbTipo.addItem("queso");
		
		JLabel lblNewLabel = new JLabel("Tipo:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(34, 62, 49, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantidad.setBounds(34, 95, 64, 18);
		contentPane.add(lblCantidad);
		
		SpinnerModel sm = new SpinnerNumberModel(1, 1, 200, 1);
		spCant = new JSpinner(sm);
		spCant.setBounds(108, 96, 39, 20);
		contentPane.add(spCant);
		spCant.setEditor(new JSpinner.DefaultEditor(spCant));
		
		JLabel lblPrioridad = new JLabel("Prioridad:");
		lblPrioridad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrioridad.setBounds(34, 129, 64, 18);
		contentPane.add(lblPrioridad);
		
		cbPrioridad = new JComboBox();
		cbPrioridad.setBounds(98, 129, 49, 22);
		contentPane.add(cbPrioridad);
		cbPrioridad.addItem("jamón");
		cbPrioridad.addItem("pollo");
		cbPrioridad.addItem("bacalao");
		cbPrioridad.addItem("queso");
		
		chPaquete = new JCheckBox("   En paquetes?");
		chPaquete.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chPaquete.setBounds(34, 163, 113, 23);
		contentPane.add(chPaquete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(170, 60, 232, 142);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("CREADOR DE CROQUETAS");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNewLabel_1.setBounds(123, 23, 200, 14);
		contentPane.add(lblNewLabel_1);
	}
}
