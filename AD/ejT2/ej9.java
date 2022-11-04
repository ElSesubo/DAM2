package ejT2;

import java.text.ParseException;
import java.text.SimpleDateFormat;  
import com.csvreader.CsvReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ej9 {

	public static void main(String[] args) throws ParseException {
        List<Libro> libros = new ArrayList<Libro>();
        
        libros = importarCSV();
        
        try {
			insertarMySQL(libros);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static List<Libro> importarCSV() throws ParseException {
        List<Libro> libros = new ArrayList<Libro>();
        
        try {
            CsvReader leerLibro = new CsvReader("Libros.csv");
            leerLibro.readHeaders();
            
            while(leerLibro.readRecord()) {
                String nombre = leerLibro.get(0);
                String autor = leerLibro.get(1);
                Date anyNaixement = new SimpleDateFormat("yyyy").parse(leerLibro.get(2));
                Date anyPublicacio  = new SimpleDateFormat("yyyy").parse(leerLibro.get(3));
                String editorial = leerLibro.get(4);
                int numPagines = Integer.parseInt(leerLibro.get(5));
                
                libros.add(new Libro(nombre, autor, anyNaixement, anyPublicacio, editorial, numPagines));
            }
            
            leerLibro.close();
            
            System.out.println("LISTA DE USUARIOS DEL CSV\n");
            for(Libro libro : libros) {
                System.out.println(
                        libro.getTitol()+", "+
                        libro.getAutor()+", "+
                        libro.getAnyNaixement()+", "+
                        libro.getAnyPublicacio()+", "+
                        libro.getEditorial()+", "+
                        libro.getNumPagines()
                );
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
        
        return libros;
        
    }
    
    public static void insertarMySQL(List<Libro> libros) throws SQLException, ClassNotFoundException {
        System.out.println("\nSE VAN A INSERTA: "+libros.size()+" REGISTROS\n");
        
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dam2","root","");
        
        String query = "INSERT INTO Llibres(titol, autor, anyNaixement, anyPublicacio, editorial, numPagines) VALUES(?,?,?,?,?,?)";
        
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
            
            for(int i = 0 ; i < libros.size() ; i++) {
                ps.setString(1, libros.get(i).getTitol());
                ps.setString(2, libros.get(i).getAutor());
                ps.setDate(3, (java.sql.Date) libros.get(i).getAnyNaixement());
                ps.setDate(4, (java.sql.Date) libros.get(i).getAnyPublicacio());
                ps.setString(5, libros.get(i).getEditorial());
                ps.setInt(6, libros.get(i).getNumPagines());
                
                ps.executeUpdate();
                
                System.out.println("Se inserto el elemento: "+(i+1)+"/"+libros.size());
            }
            
            ps.close();
            con.close();
        } catch(SQLException e) {
            
        }
    }

}
