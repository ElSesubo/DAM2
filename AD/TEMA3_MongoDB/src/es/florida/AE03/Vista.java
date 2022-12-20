package es.florida.AE03;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Color;

public class Vista extends JFrame {

	JFrame frame;
	JPanel contentPane;
	JTable table_colection;
	JTextField txtEditorial;
	JTextField txtFechaP;
	JTextField txtFechaN;
	JTextField txtAutor;
	JTextField txtNombre;
	JTextField txtID;
	JTextField textField;
	JTextField txtNumP;
	JLabel lblImagen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Vista a=new Vista();
	}

	/**
	 * Create the frame.
	 */
	
	public void aaa() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 893, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setLayout(null);
		frame.getContentPane().add(contentPane);
		
		table_colection = new JTable();
		table_colection.setBounds(33, 60, 283, 363);
		contentPane.add(table_colection);

		JLabel lblNewLabel = new JLabel("Total llibres:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(33, 433, 111, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lbl_numLibro = new JLabel("0");
		lbl_numLibro.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_numLibro.setBounds(164, 433, 66, 45);
		contentPane.add(lbl_numLibro);
		
		JLabel lblListaDeColeccin = new JLabel("Llista de coleccions");
		lblListaDeColeccin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblListaDeColeccin.setBounds(33, 10, 175, 45);
		contentPane.add(lblListaDeColeccin);
		
		JLabel lblCaracteristicas = new JLabel("Caracterísitques:");
		lblCaracteristicas.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCaracteristicas.setBounds(360, 10, 165, 45);
		contentPane.add(lblCaracteristicas);
		
		JPanel panel = new JPanel();
		panel.setBounds(347, 47, 343, 478);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_4 = new JLabel("Image");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(22, 293, 66, 28);
		panel.add(lblNewLabel_1_4);
		
		lblImagen = new JLabel("");
		lblImagen.setOpaque(true);
		lblImagen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblImagen.setBackground(SystemColor.activeCaption);
		lblImagen.setBounds(157, 293, 158, 158);
		panel.add(lblImagen);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Nombre págines");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(22, 240, 141, 28);
		panel.add(lblNewLabel_1_2_1);
		
		txtEditorial = new JTextField();
		txtEditorial.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtEditorial.setColumns(10);
		txtEditorial.setBounds(86, 204, 229, 28);
		panel.add(txtEditorial);
		
		JLabel lblNewLabel_1_2 = new JLabel("Editorial");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(22, 203, 66, 28);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Data publicació");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(22, 165, 141, 28);
		panel.add(lblNewLabel_1_3);
		
		txtFechaP = new JTextField();
		txtFechaP.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtFechaP.setColumns(10);
		txtFechaP.setBounds(173, 166, 142, 28);
		panel.add(txtFechaP);
		
		txtFechaN = new JTextField();
		txtFechaN.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtFechaN.setColumns(10);
		txtFechaN.setBounds(173, 127, 142, 28);
		panel.add(txtFechaN);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Data naixement");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3_1.setBounds(22, 127, 141, 28);
		panel.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Autor");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(22, 88, 66, 28);
		panel.add(lblNewLabel_1_1);
		
		txtAutor = new JTextField();
		txtAutor.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtAutor.setColumns(10);
		txtAutor.setBounds(86, 89, 229, 28);
		panel.add(txtAutor);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtNombre.setColumns(10);
		txtNombre.setBounds(86, 50, 229, 28);
		panel.add(txtNombre);
		
		JLabel lblNewLabel_1 = new JLabel("Titol");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(22, 49, 66, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_5 = new JLabel("ID");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_5.setBounds(22, 11, 66, 28);
		panel.add(lblNewLabel_1_5);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtID.setColumns(10);
		txtID.setBounds(86, 12, 229, 28);
		panel.add(txtID);
		
		txtNumP = new JTextField();
		txtNumP.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtNumP.setColumns(10);
		txtNumP.setBounds(173, 240, 142, 28);
		panel.add(txtNumP);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBackground(Color.LIGHT_GRAY);
		btnAgregar.setBounds(726, 60, 129, 45);
		contentPane.add(btnAgregar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBackground(Color.LIGHT_GRAY);
		btnEditar.setBounds(726, 116, 129, 45);
		contentPane.add(btnEditar);
		
		JButton btnBorrar = new JButton("Esborrar");
		btnBorrar.setBackground(Color.LIGHT_GRAY);
		btnBorrar.setBounds(726, 172, 129, 45);
		contentPane.add(btnBorrar);
		
		JButton btnSalir = new JButton("Eixir");
		btnSalir.setBackground(Color.LIGHT_GRAY);
		btnSalir.setBounds(726, 499, 129, 45);
		contentPane.add(btnSalir);

		this.frame.setVisible(true);
	}
	public Vista() {
		aaa();
	}
}
