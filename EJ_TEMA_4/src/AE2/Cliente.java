package es.florida.AE2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class Cliente extends JFrame {

	private JPanel contentPane;
	private String[] tablero = new String[9];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					Cliente frame = new Cliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnP1 = new JButton("");
		btnP1.setBounds(79, 46, 89, 89);
		contentPane.add(btnP1);
		
		JButton btnP2 = new JButton("");
		btnP2.setBounds(188, 46, 89, 89);
		contentPane.add(btnP2);
		
		JButton btnP3 = new JButton("");
		btnP3.setBounds(298, 46, 89, 89);
		contentPane.add(btnP3);
		
		JButton btnP4 = new JButton("");
		btnP4.setBounds(79, 152, 89, 89);
		contentPane.add(btnP4);
		
		JButton btnP5 = new JButton("");
		btnP5.setBounds(188, 152, 89, 89);
		contentPane.add(btnP5);
		
		JButton btnP6 = new JButton("");
		btnP6.setBounds(298, 152, 89, 89);
		contentPane.add(btnP6);
		
		JButton btnP7 = new JButton("");
		btnP7.setBounds(79, 258, 89, 89);
		contentPane.add(btnP7);
		
		JButton btnP8 = new JButton("");
		btnP8.setBounds(188, 258, 89, 89);
		contentPane.add(btnP8);
		
		JButton btnP9 = new JButton("");
		btnP9.setBounds(298, 258, 89, 89);
		contentPane.add(btnP9);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(397, 344, 72, 29);
		contentPane.add(btnSalir);
		
		JLabel lblNewLabel = new JLabel("TRES EN RAYA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(173, 21, 119, 14);
		contentPane.add(lblNewLabel);
	}
}
