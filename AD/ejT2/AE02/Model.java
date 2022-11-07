package AE02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Model {
	
	public static boolean Conexion() {
		boolean exito = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dam2","root","");
			exito = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return exito;
	}
	
	public static boolean comprobarLogin(String userN, String passN) {
		boolean correcto = true;
		try {
			String user = "";
			String pass = "";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dam2","root","");
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
    
   public static void mostrarContingut(String tabla) {
	   try {
		   	String infoTabla = "";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dam2","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM " + tabla);
			ResultSet nt = stmt.executeQuery("SELECT COUNT(*) FROM information_schema.columns WHERE table_name = " + tabla);
			int asd = nt.getInt(0);
			//for(int i = 1; i < columnas; i++) {
				
			//}
			while(rs.next()) {
				infoTabla += " " + rs.getString(1);
				infoTabla += " " + rs.getString(2);
				infoTabla += " " + rs.getString(3);
				infoTabla += " " + rs.getString(4);
				infoTabla += " " + rs.getString(5);
				infoTabla += " " + rs.getString(6);
				infoTabla += "\n";
			}
			System.out.println(infoTabla);
	   }catch(Exception e) {
		   System.out.println(e);
	   }
   }
   
   public static void main(String[] args) throws Exception {
	   if(Conexion() == true) {
		   if(comprobarLogin("roberto", Encrypt("roberto")) == true) {
			   mostrarContingut("titles");
		   }else {
			   System.out.println("Error");
		   }
	   }else {
		   System.out.println("Error");
	   }
   }
	
	
}
