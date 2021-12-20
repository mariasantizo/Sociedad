/**
 * Ventana del menu de administradores
 * @author mariasantizo y malensanz
 * @version 1
 * @since 1
 */

package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Administrador;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MenuAdministradores extends JFrame {

	private JPanel contentPane;

	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAdministradores frame = new MenuAdministradores();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public MenuAdministradores(Administrador admin) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblHola = new JLabel("Hola "+admin.getNombre()+", \u00BFqu\u00E9 desea hacer?");
		lblHola.setForeground(SystemColor.textHighlight);
		lblHola.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(lblHola);
		
		JButton btnAdministrarSocios = new JButton("Administrar socios");
		btnAdministrarSocios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministrarSocios a = new AdministrarSocios(admin);
				a.setVisible(true);
				MenuAdministradores.this.setVisible(false);
			}
		});
		btnAdministrarSocios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnAdministrarSocios);
		
		JButton btnVerCuentas = new JButton("Administrar cuentas");
		btnVerCuentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministrarCuentas a = new AdministrarCuentas(admin);
				a.setVisible(true);
				MenuAdministradores.this.setVisible(false);
			}
		});
		btnVerCuentas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnVerCuentas);
		
		JButton btnNewButton = new JButton("Cerrar Sesión");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginAdmins a = new LoginAdmins();
				a.setVisible(true);
				MenuAdministradores.this.setVisible(false);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnNewButton);
	}
}
