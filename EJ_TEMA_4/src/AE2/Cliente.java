package es.florida.AE2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cliente extends JFrame {

	private JButton btnP1;
	private JButton btnP2;
	private JButton btnP3;
	private JButton btnP4;
	private JButton btnP5;
	private JButton btnP6;
	private JButton btnP7;
	private JButton btnP8;
	private JButton btnP9;
	
	private boolean ganador = false;
	private JPanel contentPane;
	private String turno = "X";
	private JButton btns[] = new JButton[9];
	int validacion[][] = {
			{1,2,3},
			{4,5,6},
			{7,8,9},
			{1,4,7},
			{2,5,8},
			{3,6,9},
			{1,5,9},
			{3,5,7}
	};
	private JButton btnRefrescar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					Socket socket = new Socket();
					InetSocketAddress direccion = new InetSocketAddress("localhost", 1234);
					socket.connect(direccion);
					Cliente frame = new Cliente(socket);
					frame.setVisible(true);
					frame.enviarParImpar(socket);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Cliente(Socket socket) throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnP1 = new JButton("");
		btnP1.setFont(new Font("Poppins", Font.BOLD, 20));
		btnP1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					presionar(1,socket);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnP1.setBounds(79, 58, 89, 89);
		contentPane.add(btnP1);
		
		btnP2 = new JButton("");
		btnP2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					presionar(2,socket);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnP2.setFont(new Font("Poppins", Font.BOLD, 20));
		btnP2.setBounds(188, 58, 89, 89);
		contentPane.add(btnP2);
		
		btnP3 = new JButton("");
		btnP3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					presionar(3,socket);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnP3.setFont(new Font("Poppins", Font.BOLD, 20));
		btnP3.setBounds(298, 58, 89, 89);
		contentPane.add(btnP3);
		
		btnP4 = new JButton("");
		btnP4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					presionar(4,socket);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnP4.setFont(new Font("Poppins", Font.BOLD, 20));
		btnP4.setBounds(79, 164, 89, 89);
		contentPane.add(btnP4);
		
		btnP5 = new JButton("");
		btnP5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					presionar(5,socket);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnP5.setFont(new Font("Poppins", Font.BOLD, 20));
		btnP5.setBounds(188, 164, 89, 89);
		contentPane.add(btnP5);
		
		btnP6 = new JButton("");
		btnP6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					presionar(6,socket);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnP6.setFont(new Font("Poppins", Font.BOLD, 20));
		btnP6.setBounds(298, 164, 89, 89);
		contentPane.add(btnP6);
		
		btnP7 = new JButton("");
		btnP7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					presionar(7,socket);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnP7.setFont(new Font("Poppins", Font.BOLD, 20));
		btnP7.setBounds(79, 270, 89, 89);
		contentPane.add(btnP7);
		
		btnP8 = new JButton("");
		btnP8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					presionar(8,socket);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnP8.setFont(new Font("Poppins", Font.BOLD, 20));
		btnP8.setBounds(188, 270, 89, 89);
		contentPane.add(btnP8);
		
		btnP9 = new JButton("");
		btnP9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					presionar(9,socket);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnP9.setFont(new Font("Poppins", Font.BOLD, 20));
		btnP9.setBounds(298, 270, 89, 89);
		contentPane.add(btnP9);
		
		JLabel lblNewLabel = new JLabel("TRES EN RAYA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(173, 21, 119, 14);
		contentPane.add(lblNewLabel);
		
		btns[0] = btnP1;
		btns[1] = btnP2;
		btns[2] = btnP3;
		btns[3] = btnP4;
		btns[4] = btnP5;
		btns[5] = btnP6;
		btns[6] = btnP7;
		btns[7] = btnP8;
		btns[8] = btnP9;
		
		btnRefrescar = new JButton("Nueva partida");
		btnRefrescar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarControles();
			}
		});
		btnRefrescar.setBounds(24, 11, 101, 29);
		contentPane.add(btnRefrescar);
		limpiarControles();
	}
	
	public void presionar(int casilla, Socket socket) throws IOException {
		if(btns[casilla-1].getText().equals("")) {
			btns[casilla-1].setText(turno);
			
			System.err.println("Enviando datos al servidor");
			// Enviando datos al servidor
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.print(String.valueOf(casilla-1) + "\n");
			pw.flush();
			
			cambiarTurno();
			comprobarGanador();
			
			recibirInfo(socket);
		}
	}
	
	public void recibirInfo(Socket socket) throws NumberFormatException, IOException {
		System.err.println("Recibiendo datos del servidor");
		try {
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader bf = new BufferedReader(isr);
			int turnoServidor = Integer.parseInt(bf.readLine());
			System.err.println(String.valueOf(turnoServidor));
			if(!ganador) {
				if(btns[turnoServidor].getText().equals("")) {
					btns[turnoServidor].setText(turno);
					cambiarTurno();
					comprobarGanador();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void enviarParImpar(Socket socket) {
		String[] opciones = { "Par", "Impar" };
        int selection = JOptionPane.showOptionDialog(null, "¿Número par o impar?:", "Comienza el Juego", 0, 3, null,
                opciones, opciones[0]);
		OutputStream os;
		try {
			os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			System.err.println(selection);
			pw.write(String.valueOf(selection) + "\n");
			pw.flush();	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void cambiarTurno() {
		if(turno.equals("X")) {
			turno = "O";
		}else {
			turno = "X";
		}
	}
	
	public void comprobarGanador() {
		for(int i = 0; i < validacion.length; i++) {
			if(btns[validacion[i][0]-1].getText().equals("X") && btns[validacion[i][1]-1].getText().equals("X") && btns[validacion[i][2]-1].getText().equals("X")) {
				bloquearControles();
				btns[validacion[i][0]-1].setBackground(Color.green);
				btns[validacion[i][1]-1].setBackground(Color.green);
				btns[validacion[i][2]-1].setBackground(Color.green);
				ganador = true;
				JOptionPane.showMessageDialog(null,"Gana el jugador");
			}
			if(btns[validacion[i][0]-1].getText().equals("O") && btns[validacion[i][1]-1].getText().equals("O") && btns[validacion[i][2]-1].getText().equals("O")) {
				bloquearControles();
				btns[validacion[i][0]-1].setBackground(Color.red);
				btns[validacion[i][1]-1].setBackground(Color.red);
				btns[validacion[i][2]-1].setBackground(Color.red);
				ganador = true;
				JOptionPane.showMessageDialog(null,"Gana la maquina");
			}
		}
	}
	
	public void bloquearControles() {
		for(int i = 0; i < btns.length; i++) {
			btns[i].setEnabled(false);
		}
	}
	
	public void limpiarControles() {
		for(int i = 0; i < btns.length; i++) {
			btns[i].setText("");
			btns[i].setEnabled(true);
			btns[i].setBackground(Color.white);
		}
		ganador = false;
	}
}
