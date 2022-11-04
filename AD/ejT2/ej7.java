package ejT2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ej7 {

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
			System.out.println("Quina tabla vols borrar? ");
			int resultado = Integer.parseInt(teclado.nextLine());
			PreparedStatement psBorrar = con.prepareStatement("DELETE FROM api WHERE id = (?)");
			psBorrar.setInt(1,resultado);
			int resultadoBorrar = psBorrar.executeUpdate();
			psBorrar.close();
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
