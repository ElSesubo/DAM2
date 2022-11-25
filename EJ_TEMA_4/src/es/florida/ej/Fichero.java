package es.florida.ej;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;

public class Fichero implements Runnable {
	
	private Socket sc;
    private DataInputStream in;
    private DataOutputStream out;
    private String nombreCliente;
    
    public Fichero(Socket sc, DataInputStream in, DataOutputStream out, String nombreCliente) {
        this.sc = sc;
        this.in = in;
        this.out = out;
        this.nombreCliente = nombreCliente;
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		 File f = new File("hola.txt");
		 
		try {
			// Obtengo los bytes del fichero
	        byte[] contenidoFichero = ficheroNumeroCliente(f);
	        // Envio la longitud array
	        out.writeInt(contenidoFichero.length);
	        
	        // Envio los bytes uno a uno
	        for (int i = 0; i < contenidoFichero.length; i++) {
	            out.writeByte(contenidoFichero[i]);
	        }
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	 public byte[] ficheroNumeroCliente(File f) throws FileNotFoundException, IOException{
	        
	        BufferedReader br = new BufferedReader(new FileReader(f));
	        
	        String linea = "";
	        String contenido="";
	        
	        while( (linea = br.readLine()) != null){
	            // Corto la linea en dos partes
	            String[] partes = linea.split(":");
	            if(partes[0].equals(nombreCliente)){
	                contenido+=linea+"\r\n";
	            }
	        }
	        
	        br.close();
	        
	        return contenido.getBytes();
	        
	    }

}
