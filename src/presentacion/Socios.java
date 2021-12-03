package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;

public class Socios extends JFrame {

	private JPanel contentPane;
	
	
	
/*	public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				Socios frame = new Socios();
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
	public Socios(JFrame ventanaAnterior, JTextField textFieldUsuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Socios");
		
		JLabel lblBienvenido = new JLabel("Bienvenido ");
		lblBienvenido.setForeground(SystemColor.textHighlight);
		lblBienvenido.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBienvenido.setBounds(144, 36, 151, 49);
		contentPane.add(lblBienvenido);
		
		JButton btnReservar = new JButton("Reservar Mesa");
		btnReservar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReservar.setBounds(45, 121, 163, 79);
		contentPane.add(btnReservar);
		
		JButton btnCancelarReserva = new JButton("Cancelar reserva");
		btnCancelarReserva.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancelarReserva.setBounds(228, 121, 189, 79);
		contentPane.add(btnCancelarReserva);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPagar.setBounds(434, 121, 163, 79);
		contentPane.add(btnPagar);
		
		String str= textFieldUsuario.getText();
		JLabel labelNombre = new JLabel(str+" !");
		labelNombre.setFont(new Font("Tahoma", Font.BOLD, 24));
		labelNombre.setForeground(SystemColor.textHighlight);
		labelNombre.setBounds(310, 40, 212, 40);
		contentPane.add(labelNombre);
	}
}
