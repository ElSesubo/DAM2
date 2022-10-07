package AE01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Principal {
	Vista1 vista = new Vista1();
	File archivo;
	String ruta;
	int lineasTotales;
	int totalCoincidencias;
	
	public Principal(Vista1 vista) {
		this.vista = vista;
	}
	
	public void buscarPalabra(String palabra) {
		try {
			if(palabra.isEmpty()) {
				JOptionPane.showMessageDialog(null, "El campo de texto está vacío");
			}else {
				if(archivo.exists()) {
	            	lineasTotales = 0;
	            	totalCoincidencias = 0;
	                BufferedReader leerArchivo = new BufferedReader(new FileReader(archivo));
	                String lineaLeida;
	                while((lineaLeida = leerArchivo.readLine()) != null) {
	                    lineasTotales = lineasTotales + 1;
	                    String[] palabras = lineaLeida.split(" ");
	                    for(int i = 0 ; i < palabras.length ; i++) {
	                        if(palabras[i].equals(palabra)) {
	                            totalCoincidencias = totalCoincidencias + 1;
	                        }
	                    }
	                }
	            }
	            JOptionPane.showMessageDialog(null, "En total se encotro la palabra: " + palabra + ", " + totalCoincidencias + " Veces en el archivo");
	            vista.txfRuta.setText("");
			}
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
	}
	
	public void guardar() {
		// Ventana de si quiere guardar o no
	}
	
	public void reemplazarPalabra(String palabra, String reemplazo) {
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
		String[] listaArchivos = direc.list();

		for (int i = 0; i < listaArchivos.length; i++) {
				System.out.println(listaArchivos[i]);
		}
	}
	
	public static void obtenerInfo(String archivo) {
		File fichero = new File(archivo);
		
		System.out.println("Nombre del archivo: " + fichero.getName());
		System.out.println("Ruta: " + fichero.getPath());
		System.out.println("Ruta absoluta: " + fichero.getAbsolutePath());
		System.out.println("Se puede leer: " + fichero.canRead());
		System.out.println("Se puede escribir: : " + fichero.canWrite());
		System.out.println("Tamaño: " + fichero.length());
		System.out.println("Existe: " + fichero.exists());
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
	
	public void abrirExplorador() {
		JFileChooser jf = new JFileChooser();
		jf.showOpenDialog(vista);
		File archivo = jf.getSelectedFile();
		if(archivo != null) {
			vista.txfRuta.setText(archivo.getAbsolutePath());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
