package ejT2;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ej2 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dam2","root","");
			System.out.println("Conectado exitosamente");
		} catch (Exception e) {
			System.out.println("Problema al conectarse a la base de datos");
			System.out.println(e);
		}
	}
}
