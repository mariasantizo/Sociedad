package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class PantallaInicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaInicial frame = new PantallaInicial();
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
	public PantallaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelBienvenida = new JLabel("BIENVENID@ A LA SOCIEDAD");
		labelBienvenida.setForeground(Color.BLACK);
		labelBienvenida.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelBienvenida.setBounds(102, 16, 315, 60);
		contentPane.add(labelBienvenida);
		
		JButton btnSocio = new JButton("SOCIO");
		btnSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginSocios loginSocio = new LoginSocios (PantallaInicial.this);
				loginSocio.setVisible(true);
				PantallaInicial.this.setVisible(false);
			}
		});
		btnSocio.setBounds(137, 97, 237, 60);
		contentPane.add(btnSocio);
		
		JButton btnAdmin = new JButton("ADMIN");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginAdmins loginAdmin = new LoginAdmins ();
				loginAdmin.setVisible(true);
				PantallaInicial.this.setVisible(false);
			}
		});
		btnAdmin.setBounds(137, 179, 237, 60);
		contentPane.add(btnAdmin);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Alumno\\Documents\\Workspace\\Proyecto\\fondo.jpg"));
		label.setBounds(0, 0, 538, 321);
		contentPane.add(label);
	}
}
