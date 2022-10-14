package AE01;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JTextArea;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class Vista2 extends JFrame {

	JPanel contentPane;
	JTextField textField;
	JButton btnBuscar;
	JButton btnCopiar;
	DefaultListModel<Object> listModel;
	static JList<Object> list;
	JScrollPane scrollPane;
	JTextArea textContingut;
	//CrearFitxer nombreFitxer = new CrearFitxer();
	JButton btnCrear;
	JButton btnCanviarN;
	JButton btnBuscarO;
	JButton btnEditar;
	JButton btnReemplazar;
	JButton btnGuardar;
	JButton btnSuprimir;
	String ruta="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista2 frame = new Vista2();
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
	public Vista2() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(279, 22, 431, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnBuscar = new JButton("Buscar Fitxer");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ruta=abrir();
				textField.setText(ruta);
				cargarLista(ruta);
				abrirArchivo(ruta);
				datos(ruta);
				Refrescar();
			}
		});
		btnBuscar.setBounds(26, 276, 185, 34);
		contentPane.add(btnBuscar);
		
		btnCrear = new JButton("Crear Fitxer");
		btnCrear.setEnabled(false);
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearFitxer(ruta);
				cargarLista(ruta);
				abrirArchivo(ruta);
				datos(ruta);
			}
		});
		btnCrear.setBounds(26, 321, 185, 34);
		contentPane.add(btnCrear);
		
		btnCanviarN = new JButton("Canviar Nom");
		btnCanviarN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarNombre(ruta);
				cargarLista(ruta);
				abrirArchivo(ruta);
				datos(ruta);
			}
		});
		btnCanviarN.setEnabled(false);
		btnCanviarN.setBounds(26, 366, 185, 34);
		contentPane.add(btnCanviarN);
		
		btnCopiar = new JButton("Copiar Fitxer");
		btnCopiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(copyFile(ruta, textField.getText()) == true) {
					JOptionPane.showMessageDialog(null, "Fitxer copiat correctament");
				}
				cargarLista(ruta);
				abrirArchivo(ruta);
				datos(ruta);
				Refrescar();
			}
		});
		btnCopiar.setEnabled(false);
		btnCopiar.setBounds(26, 411, 185, 34);
		contentPane.add(btnCopiar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textContingut.setEditable(true);
			}
		});
		btnEditar.setBounds(235, 427, 89, 61);
		contentPane.add(btnEditar);
		
		btnBuscarO = new JButton("Buscar");
		btnBuscarO.setEnabled(false);
		btnBuscarO.setBounds(357, 427, 89, 61);
		contentPane.add(btnBuscarO);
		
		btnReemplazar = new JButton("Reemplaçar");
		btnReemplazar.setEnabled(false);
		btnReemplazar.setBounds(480, 427, 89, 61);
		contentPane.add(btnReemplazar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setEnabled(false);
		btnGuardar.setBounds(609, 427, 89, 61);
		contentPane.add(btnGuardar);
		
		btnSuprimir = new JButton("Suprimir Fitxer");
		btnSuprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp =JOptionPane.showConfirmDialog(null,"SEGURO QUE QUIERES ELIMINAR?", "ELIMINAR",
			               JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				eliminar(ruta+"/"+list.getSelectedValue().toString(),resp);
				cargarLista(ruta);
				abrirArchivo(ruta);
				datos(ruta);
			}
		});
		btnSuprimir.setEnabled(false);
		btnSuprimir.setBounds(26, 456, 185, 34);
		contentPane.add(btnSuprimir);
		
		JLabel lblNewLabel = new JLabel("Ruta:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(225, 32, 46, 14);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 22, 185, 233);
		contentPane.add(scrollPane);
		
		list = new JList<Object>();
		scrollPane.setViewportView(list);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(221, 68, 490, 346);
		contentPane.add(scrollPane_1);
		
		textContingut = new JTextArea();
		textContingut.setEditable(false);
		scrollPane_1.setViewportView(textContingut);

	}
	
	public static String abrir() {
        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        f.showSaveDialog(null);
        return f.getSelectedFile().toString();
    }
	
	public static String[] cargararchivos(File arc) {
        Filtro filtro=new Filtro(".txt");
        return arc.list(filtro);
    }
	
	public void cargarLista(String arch) {
		File archivo = new File(arch);
        String[] Lista= cargararchivos(archivo);
        list = new JList<Object>();
        scrollPane.setViewportView(list);

        listModel = new DefaultListModel<Object>();
        for (int i=0; i<Lista.length; i++) {
            listModel.addElement(Lista[i]);
        }
        list.setModel(listModel);
    }
	
	public static String leer(String ruta) throws IOException {
        String currentLine;
        String texto="";
        try {
             BufferedReader reader = new BufferedReader(new FileReader(ruta));
             while((currentLine = reader.readLine()) != null) {
                texto+=currentLine+"\n";
             }

             reader.close();

         }catch (FileNotFoundException e){
             System.err.println("Error al leer.");
         }
        return texto;
    }
	
	public void abrirArchivo(String arch){
		File archivo = new File(arch);
        list.addMouseListener((MouseListener) new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {
                    int index = list.locationToIndex(evt.getPoint());
                    try {
                        textContingut.setText(leer(archivo+"/"+list.getSelectedValue()));
                        textField.setText(archivo+ "\\" + list.getSelectedValue());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("index: "+index);
                } 
            }
        });
    }
	
	public static void crearFitxer(String arch) {
			try {
				JTextField nombre= new JTextField();
				
				Object[] fields = {
						"Nom arxiu: ", nombre
				};  
				int opcion=JOptionPane.showConfirmDialog(null,fields,"Nom arxiu",JOptionPane.OK_CANCEL_OPTION);
				File fichero = new File (arch + "/" + nombre.getText());
				if (!fichero.exists()) {
		    		if(opcion == JOptionPane.OK_OPTION) {
		    			if (fichero.createNewFile()) {
							JOptionPane.showMessageDialog(null, "Fitxer creat correctament");
						}
						else {
							JOptionPane.showMessageDialog(null, "Ha hagut un problema al crear el fitxer");  
						};
		    		}	
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	
	
	
	//Este metodo lo hemos remplazado por otro mejor
//	public static String obtenerInfo(String archivo) {
//		File fichero = new File(archivo);
//		String texto = "";
//		
//		texto += "Nom del arxiu: " + fichero.getName() + "\n";
//		texto += "Ruta: " + fichero.getPath() + "\n";
//		texto += "Tamany: " + fichero.length() + "\n";
//		
//		return texto;
//	}
	
	
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
    
    public static void eliminar(String ruta, int opcion) {
		File dirfit = new File(ruta);
		
		if(opcion==0) {
			if (dirfit.exists()) {
				  if (dirfit.delete()) {
					  JOptionPane.showMessageDialog(null,"Fitxer s'ha eliminat correctament");
				  }
				  else {
					  JOptionPane.showMessageDialog(null,"Ha hagut un problema al eliminar el fitxer");  
				  }
				}else {
					JOptionPane.showMessageDialog(null,"El fitxer no existeix");
				}
		}
		
	}
    
    public static void cambiarNombre(String ruta) {
    	File fichero = new File(ruta+"/"+list.getSelectedValue());
    	if(fichero.exists()) {
    		JTextField nuevo= new JTextField();
    		
    		Object[] fields = {
    				"Nom arxiu: ", nuevo
    		};   		
    		int opcion=JOptionPane.showConfirmDialog(null,fields,"Cambiar nombre",JOptionPane.OK_CANCEL_OPTION);
    		if(opcion == JOptionPane.OK_OPTION) {
    			File nombre = new File(ruta+"/"+nuevo.getText());
    			if(fichero.renameTo(nombre)) {
    				 JOptionPane.showMessageDialog(null,"Nombre cambiado con exito");
    			}else{
    				JOptionPane.showMessageDialog(null,"Error al cambiar");
    			};
    		}		
		}
    }
    
    public boolean copyFile(String fromFile, String toFile) {
    	String destinacion = toFile.replace(".txt", "");
        File origin = new File(toFile);
        File destination = new File(destinacion + "_copy.txt");
        if (origin.exists()) {
        	if(!destination.exists()) {
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
	                JOptionPane.showMessageDialog(null, "Error");
	                return false;
	            }
        	}else {
        		JOptionPane.showMessageDialog(null, "El fitxer ja existeix");
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
    				matcher.replaceAll(palabra);
                }
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void datos(String arch) {
		File archivo = new File(arch);
        list.addMouseMotionListener((MouseMotionListener) new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                JList<?> l = (JList<?>)e.getSource();
                ListModel<?> m = l.getModel();
                int index = l.locationToIndex(e.getPoint());
                if( index>-1 ) {
                    File arg=new File(archivo+"/"+m.getElementAt(index).toString());
                    double tamaño=arg.length()/2024;
                    BasicFileAttributes attrs;
                    String formatted="";
                    try {
                        attrs = Files.readAttributes(arg.toPath(), BasicFileAttributes.class);
                        FileTime time = attrs.creationTime();
                        String pattern = "yyyy-MM-dd HH:mm:ss";
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                        formatted = simpleDateFormat.format( new Date( time.toMillis() ) );

                    } catch (IOException exc) {
                        exc.printStackTrace();

                    }

                    l.setToolTipText("<html>" + "Nombre: "+m.getElementAt(index).toString() + "<br>" + "Tamaño:"+tamaño+"MB" + "<br>" +
                    "Fecha creación: " + formatted +"<br>"+"Ruta: "+arg.getAbsolutePath()+"<br>"+ "<br>"+"Executable: " + arg.canExecute()+"<br>"+"Readable: "+arg.canRead()+
                    "<br>"+"Writable: "+ arg.canWrite()+"</html>");
                }
            }
        });
    }
	
	public void Refrescar() {
		if(textField.getText() == "") {
			btnCrear.setEnabled(false);
			btnCanviarN.setEnabled(false);
			btnSuprimir.setEnabled(false);
			btnCopiar.setEnabled(false);
			btnEditar.setEnabled(false);
			btnGuardar.setEnabled(false);
			btnBuscarO.setEnabled(false);
			btnReemplazar.setEnabled(false);
		}else {
			btnCrear.setEnabled(true);
			btnCanviarN.setEnabled(true);
			btnSuprimir.setEnabled(true);
			btnCopiar.setEnabled(true);
			btnEditar.setEnabled(true);
			btnGuardar.setEnabled(true);
			btnBuscarO.setEnabled(true);
			btnReemplazar.setEnabled(true);
		}
		datos(ruta);
	}
}
