package es.florida.AE03;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.simple.parser.ParseException;

import com.mongodb.client.model.Filters;
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
//		do {
//			
//		}while(!login());
		Bson query = null;
		cargarTabla(query);
		
		ActionListener editarInformacion = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarInfo(vista.table_colection.getSelectedRow() + 1);
				try {
					cargarTabla(query);
				} catch (IOException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
		
		ActionListener elimiarRegistro = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.deleteObject(vista.table_colection.getSelectedRow() + 1);
				try {
					cargarTabla(query);
				} catch (IOException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
		
		ActionListener limpiarCampos = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarControles();
			}
		};
		
		ActionListener agregarRegistro = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarRegistro();
			}
		};
		
		ActionListener filtrarRegistros = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cargarTabla(realizarConsulta());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
		
		MouseListener recogerIndex = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TableModel modelo=vista.table_colection.getModel();
                if (vista.table_colection.getSelectedRow() != -1) {
                     String codigo = (String) modelo.getValueAt(vista.table_colection.getSelectedRow(), 1);
                    // Lo imprimimos en pantalla
                     rellenarInfo(vista.table_colection.getSelectedRow() + 1);
                } else {
                    System.out.println("Seleccione un renglon primero");
                }
            }

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
        };
        
        vista.btnFiltrar.addActionListener(filtrarRegistros);
        vista.btnAgregar.addActionListener(agregarRegistro);
        vista.btnBorrar.addActionListener(elimiarRegistro);
        vista.btnActualizar.addActionListener(editarInformacion);
        vista.btnEditar.addActionListener(limpiarCampos);
        vista.table_colection.addMouseListener(recogerIndex);
	}
	
	public void limpiarControles() {
		vista.txtNombre.setText("");
		vista.txtAutor.setText("");
		vista.txtFechaN.setText("");
		vista.txtFechaP.setText("");
		vista.txtEditorial.setText("");
		vista.txtNumP.setText("");
		vista.txtNombre.setEditable(true);
		vista.txtAutor.setEditable(true);
		vista.txtFechaN.setEditable(true);
		vista.txtFechaP.setEditable(true);
		vista.txtEditorial.setEditable(true);
		vista.txtNumP.setEditable(true);
	}
	
	public void editarInfo(int ident) {
		Document doc = new Document();
		doc.append("Titulo", vista.txtNombre.getText());
		doc.append("Autor", vista.txtAutor.getText());
		doc.append("Anyo_nacimiento", Integer.parseInt(vista.txtFechaN.getText()));
		doc.append("Anyo_publicacion", Integer.parseInt(vista.txtFechaP.getText()));
		doc.append("Editorial", vista.txtEditorial.getText());
		doc.append("Numero_paginas", Integer.parseInt(vista.txtNumP.getText()));
		
		model.updateObject(ident, doc);
	}
	
	public void agregarRegistro() {
		Document doc = new Document();
		doc.append("Titulo", vista.txtNombre.getText());
		doc.append("Autor", vista.txtAutor.getText());
		doc.append("Anyo_nacimiento", Integer.parseInt(vista.txtFechaN.getText()));
		doc.append("Anyo_publicacion", Integer.parseInt(vista.txtFechaP.getText()));
		doc.append("Editorial", vista.txtEditorial.getText());
		doc.append("Numero_paginas", Integer.parseInt(vista.txtNumP.getText()));
		doc.append("Thumbnail", vista.lblImagen.getText());
		
		model.insertObject(doc);
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
	
	public Bson realizarConsulta() throws Exception {
		boolean correcte = false;
		Bson query = null;
		int i;
		String[] querys = new String[] { "eq","gte","lte"};
		String[] campos = new String[] { "Id","Anyo_nacimiento","Anyo_publicacion","Numero_paginas" };
		JComboBox tipoCampo = new JComboBox();
		for(i = 0; i < querys.length; i++) {
			tipoCampo.addItem(campos[i]);
		}
		JComboBox tipoQuery = new JComboBox();
		for(i = 0; i < querys.length; i++) {
			tipoQuery.addItem(querys[i]);
		}
		JTextField numero = new JTextField();
		Object[] fields = {
				"Querys: ", tipoQuery,
				"Campos: ", tipoCampo,
				"Valor: ", numero,
		};   		
		int opcion = JOptionPane.showConfirmDialog(null,fields,"Iniciar sesió",JOptionPane.OK_CANCEL_OPTION);
			if (opcion == JOptionPane.OK_OPTION)
			{
				String tquery = (String) tipoQuery.getSelectedItem();
				String campo = (String) tipoCampo.getSelectedItem();
				int resultado = Integer.parseInt(numero.getText());
				
				switch(tquery) {
					case "eq":
						query = Filters.eq(campo, resultado);
						break;
					case "gte":
						query = Filters.gte(campo, resultado);
						break;
					case "lte":
						query = Filters.lte(campo, resultado);
						break;
				}
			}
			return query;
	}
	
	public void cargarTabla(Bson query) throws IOException, ParseException {
        DefaultTableModel modelo = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        List<Libros> lista = model.mostrarInfo(query);
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[] { String.valueOf(lista.get(i).getId()), lista.get(i).getTitulo() });
        }

        vista.table_colection.setModel(modelo);
        vista.table_colection.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TableColumnModel column = vista.table_colection.getColumnModel();
        TableColumn tc = column.getColumn(1);
        tc.setPreferredWidth(300);// Ajustar las columnas al tamaño que mas se adecua
        
        vista.table_colection.setRowSelectionInterval(0, 0);
        vista.lbl_numLibro.setText(String.valueOf(lista.size()));
    }

}
