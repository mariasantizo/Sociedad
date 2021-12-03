package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JButton;

public class CancelarReserva extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancelarReserva frame = new CancelarReserva();
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
	public CancelarReserva() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Cancelar reserva");
		
		JLabel lblElijaLaReserva = new JLabel("Elija la reserva que quiere cancelar:");
		lblElijaLaReserva.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblElijaLaReserva.setBounds(38, 33, 425, 43);
		contentPane.add(lblElijaLaReserva);
		
		JList list = new JList();
		list.setBounds(48, 92, 215, 272);
		contentPane.add(list);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(344, 335, 115, 29);
		contentPane.add(btnAceptar);
	}
}
