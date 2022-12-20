package es.florida.AE03;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.json.simple.parser.ParseException;

import com.mysql.cj.util.Base64Decoder;

public class Controlador {
	private static Vista vista;
	private static Model model;
	
	public Controlador(Vista vista, Model model) throws Exception {
		this.vista = vista;
		this.model = model;
		InitEventHandler();
	}
	
	public void InitEventHandler() throws Exception {
		do {
			
		}while(!login());
		rellenarInfo(1);
	}
	
	public void rellenarInfo(int ident) {
		String info;
		try {
			info = model.mostrarInfoId(ident);
			String[] campos = info.split("\n");
			
			vista.txtID.setText(campos[0]);
			vista.txtNombre.setText(campos[1]);
			vista.txtAutor.setText(campos[2]);
			vista.txtFechaN.setText(campos[3]);
			vista.txtFechaP.setText(campos[4]);
			vista.txtEditorial.setText(campos[5]);
			vista.txtNumP.setText(campos[6]);
			
			vista.lblImagen.setIcon(new ImageIcon(crearImage(campos)));
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static byte[] decodeToImage(String imageString) {
		return Base64.getDecoder().decode(imageString);
    }
	
	public Image crearImage(String[] campos) throws IOException {
		byte[] b = decodeToImage(campos[7]);
		return new ImageIcon(b).getImage().getScaledInstance(158, 158, Image.SCALE_SMOOTH);
	}
	
	public static boolean login() throws Exception {
		boolean correcte = false;
		JTextField usu= new JTextField();
		JTextField pass = new JTextField();
		
		Object[] fields = {
				"Usuari: ", usu,
				"Contrasenya: ", pass
		};   		
		int opcion = JOptionPane.showConfirmDialog(null,fields,"Iniciar sesió",JOptionPane.OK_CANCEL_OPTION);
			if (opcion == JOptionPane.OK_OPTION)
			{
			    String value1 = usu.getText();
			    String value2 = pass.getText();
			    if(!model.login(value1, value2)) {
			    	JOptionPane.showMessageDialog(null, "Contrasenya o usuari incorrectes");
			    }else {
			    	correcte = true;
			    }
			}else {
				System.exit(0);
			}
		return correcte;
	}

}
