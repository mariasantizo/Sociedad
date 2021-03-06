package presentacion;

/**
 * Pantalla para el menu de socios
 * @author mariasantizo y malensanz
 * @version 1
 * @since 1
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import datos.Socio;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class MenuSocios extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MenuSocios(JFrame ventanaAnterior, Socio socio) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Login > Socios");
		
		JLabel lblBienvenido = new JLabel("Bienvenid@ ");
		lblBienvenido.setForeground(Color.BLACK);
		lblBienvenido.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblBienvenido.setBounds(90, 16, 151, 49);
		contentPane.add(lblBienvenido);
		
		JButton btnReservar = new JButton("Hacer reserva\r\n");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HacerReserva hacerReserva= new HacerReserva(MenuSocios.this, socio);
				hacerReserva.setVisible(true);
				MenuSocios.this.setVisible(false);
				}
		});
		btnReservar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReservar.setBounds(15, 75, 472, 55);
		contentPane.add(btnReservar);
		
		JButton btnCancelarReserva = new JButton("Cancelar reserva");
		btnCancelarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelarReserva cancelarReserva= new CancelarReserva(MenuSocios.this, socio);
				cancelarReserva.setVisible(true);
				MenuSocios.this.setVisible(false);
			}
		});
		btnCancelarReserva.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancelarReserva.setBounds(15, 136, 472, 55);
		contentPane.add(btnCancelarReserva);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pagar pagar= new Pagar(MenuSocios.this, socio);
				pagar.setVisible(true);
				MenuSocios.this.setVisible(false);
			}
		});
		btnPagar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPagar.setBounds(15, 197, 472, 55);
		contentPane.add(btnPagar);
		
		String str= socio.getNombre();
		JLabel labelNombre = new JLabel(str+" !");
		labelNombre.setFont(new Font("Tahoma", Font.BOLD, 22));
		labelNombre.setForeground(Color.BLACK);
		labelNombre.setBounds(256, 20, 212, 40);
		contentPane.add(labelNombre);
		
		JButton btnCerrarSesin = new JButton("Cerrar sesi\u00F3n");
		btnCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuSocios.this.dispose();
				ventanaAnterior.setVisible(true);
			}
		});
		btnCerrarSesin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCerrarSesin.setBounds(15, 256, 472, 49);
		contentPane.add(btnCerrarSesin);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Alumno\\Documents\\Workspace\\Proyecto\\fondo.jpg"));
		label.setBounds(0, 0, 538, 321);
		contentPane.add(label);
	}
}
