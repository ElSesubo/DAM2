package AE01;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class Vista extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnBuscar;
	private JButton btnCopiar;

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
		setBounds(100, 100, 750, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(279, 22, 431, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea textContingut = new JTextArea();
		textContingut.setBounds(225, 67, 485, 349);
		contentPane.add(textContingut);
		
		JTextArea textInfo = new JTextArea();
		textInfo.setBounds(26, 22, 185, 230);
		contentPane.add(textInfo);
		
		btnBuscar = new JButton("Buscar Fitxer");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirExplorador();
				textContingut.setText(mostrarContingut(textField.getText()));
				textInfo.setText(obtenerInfo(textField.getText()));
			}
		});
		btnBuscar.setBounds(26, 276, 185, 34);
		contentPane.add(btnBuscar);
		
		JButton btnCrear = new JButton("Crear Fitxer");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCrear.setBounds(26, 321, 185, 34);
		contentPane.add(btnCrear);
		
		JButton btnCanviarN = new JButton("Canviar Nom");
		btnCanviarN.setBounds(26, 366, 185, 34);
		contentPane.add(btnCanviarN);
		
		btnCopiar = new JButton("Copiar Fitxer");
		btnCopiar.setBounds(26, 411, 185, 34);
		contentPane.add(btnCopiar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(235, 427, 89, 61);
		contentPane.add(btnEditar);
		
		JButton btnBuscarO = new JButton("Buscar");
		btnBuscarO.setBounds(357, 427, 89, 61);
		contentPane.add(btnBuscarO);
		
		JButton btnRemplazar = new JButton("Reemplaçar");
		btnRemplazar.setBounds(480, 427, 89, 61);
		contentPane.add(btnRemplazar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(609, 427, 89, 61);
		contentPane.add(btnGuardar);
		
		JButton btnSuprimir = new JButton("Suprimir Fitxer");
		btnSuprimir.setBounds(26, 456, 185, 34);
		contentPane.add(btnSuprimir);
		
		JLabel lblNewLabel = new JLabel("Ruta:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(225, 32, 46, 14);
		contentPane.add(lblNewLabel);
	}
	
	public void abrirExplorador() {
		JFileChooser jf = new JFileChooser();
		jf.showOpenDialog(this);
		File archivo = jf.getSelectedFile();
		if(archivo != null) {
			this.textField.setText(archivo.getAbsolutePath());
		}
	}
	
	public static void crearFitxer(String ruta) {
		File fichero = new File (ruta);
		try {
			if (!fichero.exists()) {
			  if (fichero.createNewFile()) {
				  System.out.println("El fitxer s'ha creat correctament");
			  }
			  else {
				  System.out.println("Ha hagut un problema al crear el fitxer");  
			  }
			}else {
				System.out.println("El fitxer ja existeix"); 
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static String obtenerInfo(String archivo) {
		File fichero = new File(archivo);
		String texto = "";
		
		texto += "Nom del arxiu: " + fichero.getName() + "\n";
		texto += "Ruta: " + fichero.getPath() + "\n";
		texto += "Tamany: " + fichero.length() + "\n";
		
		return texto;
	}
	
    public static String mostrarContingut(String archivo) {
    	String texto = "";
		try(FileReader fileReader = new FileReader(archivo)){
	        int caracterLeido = fileReader.read();
	        while(caracterLeido!= -1) {
	            char caracter = (char) caracterLeido;
	            caracterLeido = fileReader.read();
	            texto += caracter;
	        }
	    }catch(IOException ex){
	        System.err.println("Error al leer el archivo");
	        ex.printStackTrace();
	    }
		return texto;
    }
    
    public static void eliminar(String ruta) {
		File dirfit = new File(ruta);
		if (!dirfit.exists()) {
			  if (dirfit.delete()) {
				  System.out.println("Fitxer s'ha eliminat correctament");
			  }
			  else {
				  System.out.println("Ha hagut un problema al eliminar el fitxer");  
			  }
			}else {
				System.out.println("El fitxer no existeix");
			}
	}
    
    public static void cambiarNombre(String ruta) {
    	Scanner teclado = new Scanner(System.in);
    	File fichero = new File(ruta);
    	if(!fichero.exists()) {
			System.out.print("Nom nou del fitxer: ");
			File nombre = new File(teclado.nextLine());
			fichero.renameTo(nombre);
		}
    }
    
    public boolean copyFile(String fromFile, String toFile) {
        File origin = new File(fromFile);
        File destination = new File(toFile);
        if (origin.exists()) {
            try {
                InputStream in = new FileInputStream(origin);
                OutputStream out = new FileOutputStream(destination);
                
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                in.close();
                out.close();
                return true;
            } catch (IOException ioe) {
                ioe.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }
    
	public void reemplazarPalabra(String palabra, String reemplazo, String archivo) {
		try {
			if(palabra.isEmpty() || reemplazo.isEmpty()) {
				JOptionPane.showMessageDialog(null, "El campo de texto está vacío");
			}else {
				String patron = "\\b"+ palabra + "\\b";
						
				BufferedReader leerArchivo = new BufferedReader(new FileReader(archivo));
                String lineaLeida;
                while((lineaLeida = leerArchivo.readLine()) != null) {
                	Pattern pattern = Pattern.compile(patron);
    				Matcher matcher = pattern.matcher(lineaLeida);
    				matcher.replaceAll(reemplazo);
                }
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void infoDirectorio(String directorio) {
		File direc = new File(directorio);
		String texto = "";
		String[] listaArchivos = direc.list();

		for (int i = 0; i < listaArchivos.length; i++) {
				texto += listaArchivos[i] + "\n";
		}
	}
	
	public void buscarPalabra(String palabra, String archivo) {
		try {
			if(palabra.isEmpty()) {
				JOptionPane.showMessageDialog(null, "El campo de texto está vacío");
			}else {
				String patron = "\\b"+ palabra + "\\b";
						
				BufferedReader leerArchivo = new BufferedReader(new FileReader(archivo));
                String lineaLeida;
                while((lineaLeida = leerArchivo.readLine()) != null) {
                	Pattern pattern = Pattern.compile(patron);
    				Matcher matcher = pattern.matcher(lineaLeida);
    				matcher.replaceAll(palabra) 	;
                }
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
