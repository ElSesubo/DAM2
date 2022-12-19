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

import javax.swing.JOptionPane;

public class Tablero implements Runnable {
	
	BufferedReader bfr;
	PrintWriter pw;
	String btns[] = { "","","","","","","","","" };
	Socket socket;
	
	public Tablero(Socket socket) {
		this.socket = socket;
	}
	
	private boolean iniciarParImpar() {
		int numeroRand = (int) (Math.random()*1);
		boolean acierto = false;
		InputStream is;
		String parImpar = "";
		try {
			is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader bf = new BufferedReader(isr);
			parImpar = bf.readLine();
			System.out.println(numeroRand);
			if(Integer.parseInt(parImpar)%2 == 1 && numeroRand%2 == 1) {
				JOptionPane.showMessageDialog(null, "Comienzas tu");
				acierto = true;
			} else if(Integer.parseInt(parImpar)%2 == 0 && numeroRand%2 == 0) {
				JOptionPane.showMessageDialog(null, "Comienzas tu");
				acierto = true;
			}else {
				JOptionPane.showMessageDialog(null, "Comienza la máquina");
				acierto = false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return acierto;
	}
	
	private void recibirPosicion(int pos) {
		btns[pos] = "X";
		comprobar();
	}
	
	private int ocuparPosicion() {
		int casilla = (int) (Math.random() * 8);
		while (btns[casilla] != "") {
			casilla = (int) (Math.random() * 8);
		}
		if (btns[casilla].equals("")) {
			btns[casilla] = "O";
		}
		comprobar();
		return casilla;
	}

	private boolean comprobar() {
		List<String> list = Arrays.asList(btns);
		if (list.contains("")) {
			return false;
		} else {
			return true;
		}
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
			boolean cerrar= false;
			String turnoCliente = "";
			while(true) {
				if(iniciarParImpar()) {
					while(!cerrar) {
						System.err.println("SERVIDOR >>> Lee datos para la operacion");
						int num1 = Integer.parseInt(bfr.readLine());
						System.err.println("SERVIDOR >>> Comprueba los espacios");
						recibirPosicion(num1);
						int numEnviar = ocuparPosicion();
						System.err.println("SERVIDOR >>> Devuelve resultado");
						pw.write(String.valueOf(numEnviar) + "\n");
						pw.flush();
					}
				}else {
					while(!cerrar) {
						int numEnviar = ocuparPosicion();
						System.err.println("SERVIDOR >>> Da resultado");
						pw.write(String.valueOf(numEnviar) + "\n");
						pw.flush();
						turnoCliente = bfr.readLine();
						System.err.println("Posicion cliente" + turnoCliente);
						recibirPosicion(Integer.valueOf(turnoCliente));
					}
				}
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		System.err.println("SERVIDOR >>> Error.");
		}
	}
}
