package EJ_TEMA_3.src.es.AE01;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;

public class Lanzadora extends JFrame implements Runnable {

	private JPanel contentPane;
	private JTextField tfNumCroquetas;

	private int numCroquetas;
	private String tipoCroqueta;
	
	public Lanzadora(int numCroquetas, String tipoCroqueta) {
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
		setBounds(100, 100, 489, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfNumCroquetas = new JTextField();
		tfNumCroquetas.setBounds(97, 66, 86, 20);
		contentPane.add(tfNumCroquetas);
		tfNumCroquetas.setColumns(10);
		
		JComboBox cbTipoCroqueta = new JComboBox();
		cbTipoCroqueta.setBounds(97, 97, 86, 22);
		contentPane.add(cbTipoCroqueta);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(209, 66, 239, 259);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("Fabricar");
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

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
