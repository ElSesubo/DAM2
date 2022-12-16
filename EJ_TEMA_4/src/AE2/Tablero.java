package es.florida.AE2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;

import es.florida.ej.Libro;

public class Tablero implements Runnable {
	
	BufferedReader bfr;
	PrintWriter pw;
	private String btns[] = {"","","","","","","","",""};
	Socket socket;
	
	public Tablero(Socket socket) {
		this.socket = socket;
	}
	
	public int comprobarPosiciones(int pos) {
		List<String> lista = Arrays.asList(btns);
		int posRandom = (int) (Math.random()*8);
		if(lista.contains("")) {
			while(!btns[posRandom].equals("")) {
				posRandom = (int) (Math.random()*8);
			}
			btns[posRandom] = "ocupado";
		}
		return posRandom;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			bfr = new BufferedReader(isr);
			OutputStream os = socket.getOutputStream();
			pw = new PrintWriter(os);
			System.err.println("SERVIDOR >>> Lee datos para la operacion");
			System.out.println(bfr.readLine());
			int num1 = Integer.parseInt(bfr.readLine());
			System.err.println("SERVIDOR >>> Comprueba los espacios");
			int numEnviar = comprobarPosiciones(num1);
			System.err.println("SERVIDOR >>> Devuelve resultado");
			pw.write(numEnviar);
			pw.flush();
			System.err.println("SERVIDOR >>> Espera nueva peticion");
		} catch (IOException e) {
			e.printStackTrace();
		System.err.println("SERVIDOR >>> Error.");
		}

	}
}
