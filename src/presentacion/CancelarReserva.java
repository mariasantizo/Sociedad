package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Reserva;
import datos.Socio;
import gestorBD.GestorBD;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CancelarReserva extends JFrame {

	private JPanel contentPane;
	private ArrayList<Reserva> arrayReservas;
	private JList<Reserva> list;

/*	public static void main(String[] args) {
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
	}*/

	/**
	 * Create the frame.
	 */
	public CancelarReserva(JFrame ventanaAnterior, Socio socio) {
		arrayReservas=GestorBD.selectAllReserva();
		DefaultListModel<Reserva> listaModeloReservas = new DefaultListModel<>();
		for (Reserva r: arrayReservas) {
			if (r.getSocio().getNumeroSocio()==socio.getNumeroSocio()){
				listaModeloReservas.addElement(r);	
			}
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Cancelar reserva");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 78, 238, 286);
		contentPane.add(scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(listaModeloReservas);
		
		JLabel lblElijaLaReserva = new JLabel("Elija la reserva que quiere cancelar:");
		lblElijaLaReserva.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblElijaLaReserva.setBounds(38, 33, 425, 43);
		contentPane.add(lblElijaLaReserva);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedIndex()==-1) {
					
				} else {
					int codigo = listaModeloReservas.get(list.getSelectedIndex()).getCodigo();
					GestorBD.deleteReserva(codigo);
					listaModeloReservas.remove(list.getSelectedIndex());
				}
			}
		});
				
			
		btnAceptar.setBounds(324, 425, 115, 29);
		contentPane.add(btnAceptar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelarReserva.this.dispose();
				ventanaAnterior.setVisible(true);
			}
		});
		btnVolver.setBounds(15, 425, 115, 29);
		contentPane.add(btnVolver);
		
	}
}
