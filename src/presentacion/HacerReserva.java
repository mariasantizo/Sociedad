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
import java.awt.Color;

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
		setBounds(100, 100, 612, 537);
		getContentPane().setLayout(null);
		this.setTitle("Login > Socios > Hacer Reserva");
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy/MM/dd");
		dateChooser.setForeground(new Color(0, 0, 0));
		dateChooser.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 25));
		dateChooser.setBounds(171, 161, 245, 41);
		getContentPane().add(dateChooser);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 22));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Desayuno", "Almuerzo", "Comida", "Merienda", "Cena"}));
		comboBox.setBounds(171, 291, 245, 41);
		getContentPane().add(comboBox);
		
		JLabel lblNuevaReserva = new JLabel("NUEVA RESERVA");
		lblNuevaReserva.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNuevaReserva.setBounds(184, 35, 211, 20);
		getContentPane().add(lblNuevaReserva);
		
		JLabel lblElijaElDa = new JLabel("Elija el d\u00EDa de la reserva:");
		lblElijaElDa.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblElijaElDa.setBounds(171, 125, 346, 20);
		getContentPane().add(lblElijaElDa);
		
		JLabel lblElijaLaHora = new JLabel("Elija la hora de la reserva:");
		lblElijaLaHora.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblElijaLaHora.setBounds(171, 255, 346, 20);
		getContentPane().add(lblElijaLaHora);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ElegirMesa elegirMesa = new ElegirMesa (HacerReserva.this, socio, dateChooser, comboBox);
				elegirMesa.setVisible(true);
				HacerReserva.this.setVisible(false);
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnAceptar.setBounds(441, 396, 126, 41);
		getContentPane().add(btnAceptar);
		
		JButton btnAceptar_1 = new JButton("Volver");
		btnAceptar_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnAceptar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HacerReserva.this.dispose();
				ventanaAnterior.setVisible(true);
			}
		});
		btnAceptar_1.setBounds(59, 396, 126, 41);
		getContentPane().add(btnAceptar_1);
	}
}
