package presentacion;

/**
 * Último paso para realizar la reserva, es la confirmación de la reserva según los datos introducidos anteriormente en otras pantallas
 * @author mariasantizo y malensanz
 * @version 1
 * @since 1
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import datos.Mesa;
import datos.Reserva;
import datos.Socio;
import gestorBD.GestorBD;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.awt.event.ActionEvent;

public class ConfirmacionReserva extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ConfirmacionReserva(JFrame ventanaAnterior, Socio socio, JDateChooser date, JComboBox horario, JList list) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Login > Socios > Hacer Reserva > Elegir mesa > Confirmación Reserva");
		
		JLabel lblConfirmacinDeReserva = new JLabel("CONFIRMACI\u00D3N DE RESERVA");
		lblConfirmacinDeReserva.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblConfirmacinDeReserva.setBounds(97, 28, 375, 20);
		contentPane.add(lblConfirmacinDeReserva);
		
		JLabel lblNewLabel = new JLabel("" +date.getDate());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(25, 89, 513, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lbl = new JLabel (""+horario.getSelectedItem());
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl.setBounds(25, 161, 283, 20);
		contentPane.add(lbl);
		
		JButton boton = new JButton ("Confirmar reserva");
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numero = (int)(Math.random()*10000+1);
				Calendar c= new GregorianCalendar();
				
				int day = date.getDate().getDate();
				int month = date.getDate().getMonth();
				int year = date.getDate().getYear();
				
				c.set(Calendar.DATE, day);
				c.set(Calendar.MONTH, day);
				c.set(Calendar.YEAR, day);
				
				int codigo=Integer.parseInt(list.getSelectedValue().toString());	
				Mesa m= new Mesa (codigo, 10);
				Reserva r= new Reserva (numero, socio, m, c, horario.toString());
				GestorBD.insertReserva(r);
				
				JOptionPane.showMessageDialog(ConfirmacionReserva.this, "La reserva se ha realizado correctamente");
				ConfirmacionReserva.this.dispose();
				MenuSocios menuSocio = new MenuSocios (ventanaAnterior, socio);
				menuSocio.setVisible(true);
				
			}
		});
		boton.setBounds(283, 248, 240, 43);
		contentPane.add(boton);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmacionReserva.this.dispose();
				ventanaAnterior.setVisible(true);
			}
		});
		btnVolver.setBounds(25, 248, 240, 43);
		contentPane.add(btnVolver);
		
		JLabel lblNewLabel_1 = new JLabel("Reserva:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(25, 64, 513, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblMesa = new JLabel("Horario:");
		lblMesa.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblMesa.setBounds(25, 135, 283, 20);
		contentPane.add(lblMesa);
		
		JLabel lblMesa_2 = new JLabel("Mesa:");
		lblMesa_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblMesa_2.setBounds(25, 197, 283, 20);
		contentPane.add(lblMesa_2);
		
		JLabel lblMesa_1 = new JLabel(""+list.getSelectedValue());
		lblMesa_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblMesa_1.setBounds(25, 222, 283, 20);
		contentPane.add(lblMesa_1);
		
		
	}

}
