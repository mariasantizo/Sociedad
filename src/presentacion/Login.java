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
		arraySocios= GestorBD.selectAllSocio();
		arrayAdmins=GestorBD.selectAllAdministrador();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Inicio Sesión");
		
		JLabel labelBienvenida = new JLabel("BIENVENIDO A LA SOCIEDAD");
		labelBienvenida.setForeground(SystemColor.textHighlight);
		labelBienvenida.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelBienvenida.setBounds(109, 16, 382, 60);
		contentPane.add(labelBienvenida);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsuario.setBounds(55, 105, 156, 34);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContrasea.setBounds(55, 166, 156, 34);
		contentPane.add(lblContrasea);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(255, 111, 146, 26);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		passwordFieldContrasena = new JPasswordField();
		passwordFieldContrasena.setBounds(255, 172, 146, 26);
		contentPane.add(passwordFieldContrasena);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textoUsuario = textFieldUsuario.getText();
				String passwordTexto= passwordFieldContrasena.getText();
				boolean usuarioEncontrado=false;
				for (int i=0; i<arraySocios.size();i++){
					if(textoUsuario.equals(arraySocios.get(i).getNombre()) && passwordTexto.equals(((Socio) arraySocios.get(i)).getContrasena())) {
						usuarioEncontrado=true;	
							Socios socios=new Socios (Login.this, textFieldUsuario);
							socios.setVisible(true);
							Login.this.setVisible(false);
						}else{
							if(textoUsuario.equals(arrayAdmins.get(i).getNombre()) && passwordTexto.equals(((Administrador) arrayAdmins.get(i)).getContrasena())){
								usuarioEncontrado=true;	
								Administradores admins =new Administradores ();
								admins.setVisible(true);
								Login.this.setVisible(false);
							}
						}
						}
				if(usuarioEncontrado==false) {
					JOptionPane.showMessageDialog(Login.this, "Usuario o contraseña incorrectas");
				}
			}
		});
		btnAceptar.setBounds(393, 230, 115, 29);
		contentPane.add(btnAceptar);
	}
}
