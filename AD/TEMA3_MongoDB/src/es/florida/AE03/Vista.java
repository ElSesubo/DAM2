package AE03;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class Vista extends JFrame {

	JFrame frame;
	JPanel contentPane;
	JTable table_colection;
	JTextField txtNombre;
	JTextField txtAutor;
	JTextField txtFechaP;
	JTextField txtFechaN;
	JTextField txtID;
	JTextField txtNumP;
	JTextField txtEditorial;
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

		JLabel lblNewLabel = new JLabel("Total libros:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(33, 433, 111, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lbl_numLibro = new JLabel("0");
		lbl_numLibro.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_numLibro.setBounds(164, 433, 66, 45);
		contentPane.add(lbl_numLibro);
		
		JLabel lblListaDeColeccin = new JLabel("Lista de colección");
		lblListaDeColeccin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblListaDeColeccin.setBounds(33, 10, 175, 45);
		contentPane.add(lblListaDeColeccin);
		
		JLabel lblCaracteristicas = new JLabel("Caracteristicas:");
		lblCaracteristicas.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCaracteristicas.setBounds(360, 10, 151, 45);
		contentPane.add(lblCaracteristicas);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtNombre.setBounds(434, 113, 229, 28);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Titulo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(370, 112, 66, 28);
		contentPane.add(lblNewLabel_1);
		
		txtAutor = new JTextField();
		txtAutor.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtAutor.setColumns(10);
		txtAutor.setBounds(434, 152, 229, 28);
		contentPane.add(txtAutor);
		
		JLabel lblNewLabel_1_1 = new JLabel("Autor");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(370, 151, 66, 28);
		contentPane.add(lblNewLabel_1_1);
		
		txtEditorial = new JTextField();
		txtEditorial.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtEditorial.setColumns(10);
		txtEditorial.setBounds(434, 267, 229, 28);
		contentPane.add(txtEditorial);
		
		JLabel lblNewLabel_1_2 = new JLabel("Editorial");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(370, 266, 66, 28);
		contentPane.add(lblNewLabel_1_2);
		
		txtFechaP = new JTextField();
		txtFechaP.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtFechaP.setColumns(10);
		txtFechaP.setBounds(521, 229, 142, 28);
		contentPane.add(txtFechaP);
		
		JLabel lblNewLabel_1_3 = new JLabel("Fecha publicación");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(370, 228, 141, 28);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Imagen");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(370, 356, 66, 28);
		contentPane.add(lblNewLabel_1_4);
		
		lblImagen = new JLabel("Imagen");
		lblImagen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblImagen.setBackground(SystemColor.activeCaption);
		lblImagen.setBounds(447, 356, 230, 199);
		lblImagen.setOpaque(true);
		contentPane.add(lblImagen);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Fecha nacimiento");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3_1.setBounds(370, 190, 141, 28);
		contentPane.add(lblNewLabel_1_3_1);
		
		txtFechaN = new JTextField();
		txtFechaN.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtFechaN.setColumns(10);
		txtFechaN.setBounds(521, 190, 142, 28);
		contentPane.add(txtFechaN);
		
		JLabel lblNewLabel_1_5 = new JLabel("ID");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_5.setBounds(370, 74, 66, 28);
		contentPane.add(lblNewLabel_1_5);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtID.setColumns(10);
		txtID.setBounds(434, 75, 229, 28);
		contentPane.add(txtID);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Nombre págines");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(370, 303, 141, 28);
		contentPane.add(lblNewLabel_1_2_1);
		
		txtNumP = new JTextField();
		txtNumP.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtNumP.setColumns(10);
		txtNumP.setBounds(521, 305, 142, 28);
		contentPane.add(txtNumP);

		this.frame.setVisible(true);
	}
	public Vista() {
		aaa();
	}
}
