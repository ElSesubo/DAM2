package es.florida.AE2;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import es.florida.ej.Libro;

public class Tablero implements Runnable {
	
	private final int matriz[][] = new int[3][3];
	
	Socket socket;
	
	public Tablero(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
