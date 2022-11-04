package ejT2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ej6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner teclado = new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dam2","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM api");
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
			System.out.println("Inserción en base de datos: ");
			String resultado = teclado.nextLine();
			PreparedStatement psActualizar = con.prepareStatement("UPDATE api SET correo = (?) WHERE id = 1");
			psActualizar.setString(1,resultado);
			int resultadoActualizar = psActualizar.executeUpdate();
			psActualizar.close();
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
