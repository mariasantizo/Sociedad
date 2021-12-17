package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JToggleButton;
import com.toedter.components.JLocaleChooser;

import datos.Socio;

import javax.swing.Box;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HacerReserva extends JFrame {

/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HacerReserva frame = new HacerReserva();
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
	public HacerReserva(JFrame ventanaAnterior, Socio socio) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 477);
		getContentPane().setLayout(null);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 20));
		dateChooser.setBounds(83, 135, 198, 29);
		getContentPane().add(dateChooser);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Desayuno", "Almuerzo", "Comida", "Merienda", "Cena"}));
		comboBox.setBounds(83, 271, 198, 26);
		getContentPane().add(comboBox);
		
		JLabel lblNuevaReserva = new JLabel("NUEVA RESERVA");
		lblNuevaReserva.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNuevaReserva.setBounds(212, 33, 211, 20);
		getContentPane().add(lblNuevaReserva);
		
		JLabel lblElijaElDa = new JLabel("Elija el d\u00EDa de la reserva:");
		lblElijaElDa.setBounds(83, 99, 211, 20);
		getContentPane().add(lblElijaElDa);
		
		JLabel lblElijaLaHora = new JLabel("Elija la hora de la reserva:");
		lblElijaLaHora.setBounds(83, 231, 211, 20);
		getContentPane().add(lblElijaLaHora);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(436, 340, 115, 29);
		getContentPane().add(btnAceptar);
		
		JButton btnAceptar_1 = new JButton("Volver");
		btnAceptar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HacerReserva.this.dispose();
				//ventanaAnterior.setVisible(true);
			}
		});
		btnAceptar_1.setBounds(44, 340, 115, 29);
		getContentPane().add(btnAceptar_1);
	}
}
