package ejT2.AE02;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Model {
	
	public static Connection Conexion() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dam2","root","");
		} catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage() + 
                    ". >>> Error de Conexion 1!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + 
                    ". >>> Error de Conexion 2!!");
        }
		return con;
	}
	
	public static boolean comprobarLogin(String userN, String passN) {
		boolean correcto = true;
		try {
			String user = "";
			String pass = "";

			Connection con = Conexion();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM users");
			while(rs.next()) {
				user = rs.getString(2);
				pass = rs.getString(3);
			}
			if(userN == user && passN == pass) {
				return true;
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
			Connection con = Conexion();
			Statement stmt = con.createStatement();
			ResultSet nt = stmt.executeQuery("SELECT COUNT(*) FROM information_schema.columns WHERE TABLE_NAME='" + tabla + "'");
			while(nt.next()) {
				cols = nt.getInt(1);
			}
	   }catch(Exception e) {
		   System.out.println(e);
	   }
	   return cols;
   }
    
   public static void mostrarContingut(String tabla, int columnas) {
	   try {
		   	String infoTabla = "";

			Connection con = Conexion();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM " + tabla);
			//for(int i = 1; i < columnas; i++) {
				
			//}
			while(rs.next()) {
				for(int i = 1; i <= columnas; i++) {
					infoTabla += " " + rs.getString(i);
					infoTabla += "\n";
				}
			}
//			while(rs.next()) {
//				infoTabla += " " + rs.getString(1);
//				infoTabla += " " + rs.getString(2);
//				infoTabla += " " + rs.getString(3);
//				infoTabla += " " + rs.getString(4);
//				infoTabla += " " + rs.getString(5);
//				infoTabla += " " + rs.getString(6);
//				infoTabla += "\n";
//			}
			System.out.println(infoTabla);
	   }catch(Exception e) {
		   System.out.println(e);
	   }
   }
   
   public static void main(String[] args) throws Exception {
	   if(Conexion() != null) {
		   if(comprobarLogin("roberto", Encrypt("roberto")) == true) {
			   mostrarContingut("authors", numColumnas("authors"));
		   }else {
			   System.out.println("Error");
		   }
	   }else {
		   System.out.println("Error");
	   }
   }
	
	
}
