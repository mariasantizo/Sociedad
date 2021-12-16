package presentacion;

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
	public Socios(JFrame ventanaAnterior, Socio socio) {
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
		
		JButton btnReservar = new JButton("Hacer reserva\r\n");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HacerReserva hacerReserva= new HacerReserva(Socios.this, socio);
				hacerReserva.setVisible(true);
				Socios.this.setVisible(false);
				}
		});
		btnReservar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReservar.setBounds(45, 121, 163, 79);
		contentPane.add(btnReservar);
		
		JButton btnCancelarReserva = new JButton("Cancelar reserva");
		btnCancelarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelarReserva cancelarReserva= new CancelarReserva(Socios.this, socio);
				cancelarReserva.setVisible(true);
				Socios.this.setVisible(false);
			}
		});
		btnCancelarReserva.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancelarReserva.setBounds(228, 121, 189, 79);
		contentPane.add(btnCancelarReserva);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pagar pagar= new Pagar();
				pagar.setVisible(true);
				Socios.this.setVisible(false);
			}
		});
		btnPagar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPagar.setBounds(434, 121, 163, 79);
		contentPane.add(btnPagar);
		
		String str= socio.getNombre();
		JLabel labelNombre = new JLabel(str+" !");
		labelNombre.setFont(new Font("Tahoma", Font.BOLD, 24));
		labelNombre.setForeground(SystemColor.textHighlight);
		labelNombre.setBounds(310, 40, 212, 40);
		contentPane.add(labelNombre);
	}
}
