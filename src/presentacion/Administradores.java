package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;

public class Administradores extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administradores frame = new Administradores();
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
	public Administradores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHola = new JLabel("Hola ..., \u00BFqu\u00E9 desea hacer?");
		lblHola.setForeground(SystemColor.textHighlight);
		lblHola.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblHola.setBounds(149, 29, 388, 49);
		contentPane.add(lblHola);
		
		JButton btnAnadirSocio = new JButton("A\u00F1adir socio");
		btnAnadirSocio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAnadirSocio.setBounds(51, 129, 155, 41);
		contentPane.add(btnAnadirSocio);
		
		JButton btnBorrarSocio = new JButton("Borrar socio");
		btnBorrarSocio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBorrarSocio.setBounds(51, 186, 155, 41);
		contentPane.add(btnBorrarSocio);
		
		JButton btnVerCuentas = new JButton("Ver cuentas");
		btnVerCuentas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVerCuentas.setBounds(51, 245, 155, 41);
		contentPane.add(btnVerCuentas);
	}
}
