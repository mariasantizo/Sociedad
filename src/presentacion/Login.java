package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Administrador;
import datos.Persona;
import datos.Socio;
import gestorBD.GestorBD;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private ArrayList<Socio> arraySocios;
	private ArrayList <Administrador> arrayAdmins;
	private JPasswordField passwordFieldContrasena;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		//error indexoutofbounds
		arraySocios= GestorBD.selectAllSocio();
		arrayAdmins=GestorBD.selectAllAdministrador();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Inicio Sesión");
		
		JLabel labelBienvenida = new JLabel("BIENVENID@ A LA SOCIEDAD");
		labelBienvenida.setForeground(Color.BLACK);
		labelBienvenida.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelBienvenida.setBounds(109, 16, 315, 60);
		contentPane.add(labelBienvenida);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblUsuario.setBounds(66, 114, 156, 34);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblContrasea.setBounds(66, 175, 156, 34);
		contentPane.add(lblContrasea);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(282, 120, 146, 26);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		passwordFieldContrasena = new JPasswordField();
		passwordFieldContrasena.setBounds(282, 181, 146, 26);
		contentPane.add(passwordFieldContrasena);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setForeground(Color.BLACK);
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textoUsuario = textFieldUsuario.getText();
				String passwordTexto= passwordFieldContrasena.getText();
				boolean usuarioEncontrado=false;
				for (int i=0; i<arraySocios.size();i++){
					if(textoUsuario.equals(arraySocios.get(i).getDni()) && passwordTexto.equals(((Socio) arraySocios.get(i)).getContrasena())){
						usuarioEncontrado=true;	
							Socios socios=new Socios (Login.this, arraySocios.get(i));
							socios.setVisible(true);
							Login.this.setVisible(false);
						}else if(textoUsuario.equals(arrayAdmins.get(i).getDni()) && passwordTexto.equals(((Administrador) arrayAdmins.get(i)).getContrasena())){
								usuarioEncontrado=true;	
								MenuAdministradores admins =new MenuAdministradores (arrayAdmins.get(i));
								admins.setVisible(true);
								Login.this.setVisible(false);
							}
						}
						
				if(usuarioEncontrado==false) {
					JOptionPane.showMessageDialog(Login.this, "Usuario o contraseña incorrectas");
				}
			}
		});
		btnAceptar.setBounds(372, 264, 115, 29);
		contentPane.add(btnAceptar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Alumno\\Documents\\Workspace\\Proyecto\\fondo.jpg"));
		label.setBounds(0, 0, 538, 321);
		contentPane.add(label);
	}
}
