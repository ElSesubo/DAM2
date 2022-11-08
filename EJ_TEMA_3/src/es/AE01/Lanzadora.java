package es.florida.ej.AE01;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.florida.ej.Caracol;
import es.florida.ej.PolloKFC;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Lanzadora extends JFrame {

	static int contador = 0;
	private JPanel contentPane;
	private JTextField tfNumCroquetas;
	static JComboBox cbTipoCroqueta;
	JScrollPane scrollPane;
	static JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lanzadora frame = new Lanzadora();
					frame.setVisible(true);
					cargarComboBox();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private static Thread[] hilos;
	
	public Lanzadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfNumCroquetas = new JTextField();
		tfNumCroquetas.setBounds(97, 66, 86, 20);
		contentPane.add(tfNumCroquetas);
		tfNumCroquetas.setColumns(10);
		
		cbTipoCroqueta = new JComboBox();
		cbTipoCroqueta.setBounds(97, 97, 86, 22);
		contentPane.add(cbTipoCroqueta);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(209, 66, 239, 259);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("Fabricar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comprobarCampos() == true) {
					contador = 0;
					textArea.setText("");
					
					int numHilos = Integer.parseInt(tfNumCroquetas.getText());
					String tipo = (String) cbTipoCroqueta.getSelectedItem();
					hilos = new Thread[numHilos];
					Procesadora pro;
					for(int i = 0; i < numHilos; i++) {
						pro = new Procesadora(numHilos, tipo);
						hilos[i] = new Thread(pro);
						hilos[i].start();
//						try {
//							hilos[i].join();
//						} catch (Exception ex) {
//							System.out.println(ex);
//						}
					}
				}else {
					JOptionPane.showMessageDialog(null, "Numero de croquetas máximos sobrepasados");
				}
			}
		});
		btnNewButton.setBounds(42, 293, 141, 32);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("FABRICADOR DE CROQUETAS");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNewLabel.setBounds(121, 26, 274, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cantidad:");
		lblNewLabel_1.setBounds(42, 69, 55, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tipo:");
		lblNewLabel_1_1.setBounds(42, 101, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JComboBox cbTipoCroqueta_1 = new JComboBox();
		cbTipoCroqueta_1.setBounds(97, 158, 86, 22);
		contentPane.add(cbTipoCroqueta_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Personalizar Prioridad");
		chckbxNewCheckBox.setBounds(42, 128, 157, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JComboBox cbTipoCroqueta_1_1 = new JComboBox();
		cbTipoCroqueta_1_1.setBounds(97, 191, 86, 22);
		contentPane.add(cbTipoCroqueta_1_1);
		
		JComboBox cbTipoCroqueta_1_2 = new JComboBox();
		cbTipoCroqueta_1_2.setBounds(97, 224, 86, 22);
		contentPane.add(cbTipoCroqueta_1_2);
		
		JComboBox cbTipoCroqueta_1_3 = new JComboBox();
		cbTipoCroqueta_1_3.setBounds(97, 257, 86, 22);
		contentPane.add(cbTipoCroqueta_1_3);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("4:");
		lblNewLabel_1_1_1_3.setBounds(74, 261, 16, 14);
		contentPane.add(lblNewLabel_1_1_1_3);
		
		JLabel lblNewLabel_1_1_1_3_1 = new JLabel("1:");
		lblNewLabel_1_1_1_3_1.setBounds(74, 162, 16, 14);
		contentPane.add(lblNewLabel_1_1_1_3_1);
		
		JLabel lblNewLabel_1_1_1_3_2 = new JLabel("2:");
		lblNewLabel_1_1_1_3_2.setBounds(74, 195, 16, 14);
		contentPane.add(lblNewLabel_1_1_1_3_2);
		
		JLabel lblNewLabel_1_1_1_3_3 = new JLabel("3:");
		lblNewLabel_1_1_1_3_3.setBounds(74, 228, 16, 14);
		contentPane.add(lblNewLabel_1_1_1_3_3);
	}
	
	public static class Procesadora implements Runnable {
		private int numCroquetas;
		private String tipoCroqueta;
		
		public Procesadora(int numCroquetas, String tipoCroqueta) {
			this.numCroquetas = numCroquetas;
			this.tipoCroqueta = tipoCroqueta;
		}
		
		public int getNumCroquetas() {
			return numCroquetas;
		}

		public void setNumCroquetas(int numCroquetas) {
			this.numCroquetas = numCroquetas;
		}

		public String getTipoCroqueta() {
			return tipoCroqueta;
		}

		public void setTipoCroqueta(String tipoCroqueta) {
			this.tipoCroqueta = tipoCroqueta;
		}
		
		public void crearCroqueta(int num, String tipo) {
			try {
				System.out.println(num);
				if(num == 100) {
					Thread.sleep(3000);
				}
				switch (tipo) {
					case "jamón":
						contador++;
						textArea.append("\nCreando croqueta de jamón n." + contador);
						Thread.sleep(5000);
						textArea.append("\nCroqueta de jamón finalizada");
					break;
					case "pollo":
						contador++;
						textArea.append("\nCreando croqueta de pollo n." + contador);
						Thread.sleep(6000);
						textArea.append("\nCroqueta de pollo finalizada");
					break;
					case "bacalao":
						contador++;
						textArea.append("\nCreando croqueta de bacalao n." + contador);
						Thread.sleep(5000);
						textArea.append("\nCroqueta de bacalao finalizada");
					break;
					case "queso":
						contador++;
						textArea.append("\nCreando croqueta de queso n." + contador);
						Thread.sleep(5000);
						textArea.append("\nCroqueta de queso finalizada");
					break;		
				}
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			int numHilos = Integer.parseInt(tfNumCroquetas.getText());
			String tipo = (String) cbTipoCroqueta.getSelectedItem();
			crearCroqueta(40, "jamón");
		}
	}
	
	public static void cargarComboBox() {
		cbTipoCroqueta.addItem("jamón");
		cbTipoCroqueta.addItem("pollo");
		cbTipoCroqueta.addItem("bacalao");
		cbTipoCroqueta.addItem("queso");
	}
	
	public boolean comprobarCampos() {
		boolean continuar = true;
		int cantidad = Integer.parseInt(tfNumCroquetas.getText());
		if(cantidad > 100) {
			continuar = false;
		}
		return continuar;
	}
}
