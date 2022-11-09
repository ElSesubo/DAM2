package AE02;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.System.Logger;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Model {
	
	public static Connection conexion = null;
	
	public static Connection Conexion(String base, String usu, String pass) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(base,usu,pass);
		} catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage() + 
                    ". >>> Error de Conexion 1!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + 
                    ". >>> Error de Conexion 2!!");
        }
		return conexion;
	}
	
	public static String realizarCSelect(String consulta) {
	   String infoTabla = "";
	   try {
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(consulta);

			while(rs.next()) {
				infoTabla += rs.getString("*") + "\n ";
			}
	   }catch(Exception e) {
		   System.out.println(e);
	   }
	   return infoTabla;
	}
	
	public static void realizarCIUD(String consulta) {
		try {
			PreparedStatement psInsertar = conexion.prepareStatement(consulta);
			int resultadoInsertar = psInsertar.executeUpdate();
			if(resultadoInsertar == 0) {
				JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta");
			}
			psInsertar.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean comprobarLogin(String userN, String passN) {
		boolean correcto = false;
		try {
			String user = "";
			String pass = "";

			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM users");
			while(rs.next()) {
				user = rs.getString(2);
				pass = rs.getString(3);
			}
			if(userN.equals(user) && passN.equals(pass)) {
				correcto = true;
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return correcto;
	}
	
    public static String Encrypt(String pass) throws Exception {
    	String plaintext = pass;
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.reset();
		m.update(plaintext.getBytes());
		byte[] digest = m.digest();
		BigInteger bigInt = new BigInteger(1,digest);
		String hashtext = bigInt.toString(16);
		while(hashtext.length() < 32 ){
		  hashtext = "0"+hashtext;
	
		}
                          
        return hashtext;
  }
    
   public static int numColumnas(String tabla) {
	   int cols = 0;
	   try {
			Statement stmt = conexion.createStatement();
			ResultSet nt = stmt.executeQuery("SELECT COUNT(*) FROM information_schema.columns WHERE TABLE_NAME='" + tabla + "'");
			while(nt.next()) {
				cols = nt.getInt(1);
			}
	   }catch(Exception e) {
		   System.out.println(e);
	   }
	   return cols;
   }
   
//   public static int numTablas(String base) {
//	   int tabs = 0;
//	   try {
//			Statement stmt = conexion.createStatement();
//			ResultSet nt = stmt.executeQuery("SELECT COUNT(*) from Information_Schema.Tables where TABLE_SCHEMA='" + base + "'");
//			while(nt.next()) {
//				tabs = nt.getInt(1);
//			}	
//	   }catch(Exception e) {
//		   e.printStackTrace();
//	   }
//	   System.out.println(tabs);
//	   return tabs;
//   }
   
   public static String nomTablas(String base) {
	   String nom = "";
	   try {
		   Statement stmt = conexion.createStatement();
		   ResultSet nt = stmt.executeQuery("SELECT TABLE_NAME from Information_Schema.Tables where table_schema = '" + base + "'");
		   while(nt.next()) {
			   nom += nt.getString(1) + " ";
		   }
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	   return nom;
   }
    
   public static String mostrarContingut(String tabla, int columnas) {
	   String infoTabla = "";
	   try {
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM " + tabla);

			while(rs.next()) {
				for(int i = 1; i <= columnas; i++) {
					if(rs.getString(i).equals(rs.getString(1))) {
						infoTabla += "\n";
					}
					infoTabla += rs.getString(i) + " ";
				}
			}
	   }catch(Exception e) {
		   System.out.println(e);
	   }
	   return infoTabla;
   }
   
   public static void cierraConexion() {
	   if (conexion != null) {
		    try {
		        conexion.close();
		        JOptionPane.showMessageDialog(null, "Conexió tancada");
		    } catch (SQLException e) {
		    	e.printStackTrace();
		    }
		}
	}
	
	
}
