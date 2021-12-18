package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import datos.Mesa;
import datos.Reserva;
import datos.Socio;
import gestorBD.GestorBD;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;

public class ElegirMesa extends JFrame {

	private JPanel contentPane;
	private JLabel lblELEGIR;
	private JLabel lblDisponibles;
	private JLabel lblPlanoDelComedor;
	private JLabel lblNewLabel;
	private JButton btnReservar;
	private JButton btnVolver;
	private ArrayList <Mesa> arrayMesas;
	private ArrayList <Reserva> arrayReservas;
	private ArrayList <Socio> arraySocios;
	private JScrollPane scrollPane;
	private JList list;
	private JLabel lblDisponibles_1;
	private JScrollPane scrollPane_1;
	private JList list_1;

/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElegirMesa frame = new ElegirMesa(frame, null, null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * Primero se sacan en una lista qué mesas están ocupadas para ese día y horario
	 * Después se calcula y se sacan en una lista qué mesas están en este momento disponibles. Se quitan las ocupadas para ese día a las mesas que estan en la BD.
	 */
	
	public ElegirMesa(JFrame ventanaAnterior, Socio socio, JDateChooser date, JComboBox horario) {
		arraySocios=GestorBD.selectAllSocio();
		arrayMesas=GestorBD.selectAllMesa();
		arrayReservas=GestorBD.selectAllReserva(arraySocios, arrayMesas);
		DefaultListModel<Mesa> listaModeloMesasOcupadas = new DefaultListModel<>();
		for (Reserva r: arrayReservas) {
			if (date.getDate().getDate()==(r.getFecha().get(Calendar.DATE))){
				if (horario.getSelectedItem().equals(r.getHorario())){
					Mesa m=r.getMesa();
					listaModeloMesasOcupadas.addElement(m);		
				}
			}		
		}
		DefaultListModel<Mesa> listaModeloMesasDisponibles = new DefaultListModel<>();
		for (Mesa m1: arrayMesas) {
			String a= "Mesa" + m1.getCodigoMesa();
			if (a!=listaModeloMesasOcupadas.toArray().toString()){
					listaModeloMesasDisponibles.addElement(m1);		
				}
			}		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 697);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Login > Socios > Hacer Reserva > Elegir mesa");
		
		
		lblELEGIR = new JLabel("Reserva de mesa: " + horario.getSelectedItem() + " el " + date.getDate());
		lblELEGIR.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblELEGIR.setBounds(15, 16, 581, 54);
		contentPane.add(lblELEGIR);
		
		lblDisponibles = new JLabel("MESAS OCUPADAS:");
		lblDisponibles.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDisponibles.setBounds(298, 90, 161, 20);
		contentPane.add(lblDisponibles);
		
		lblPlanoDelComedor = new JLabel("PLANO DEL COMEDOR:");
		lblPlanoDelComedor.setBounds(210, 354, 207, 20);
		contentPane.add(lblPlanoDelComedor);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Alumno\\Documents\\Workspace\\Proyecto\\plano.png"));
		lblNewLabel.setBounds(118, 366, 368, 275);
		contentPane.add(lblNewLabel);
		
		btnReservar = new JButton("Reservar");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmacionReserva c = new ConfirmacionReserva (ventanaAnterior, socio, date, horario, list_1);
				c.setVisible(true);
				ElegirMesa.this.setVisible(false);
				
			}
		});
		btnReservar.setBounds(298, 300, 138, 38);
		contentPane.add(btnReservar);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ElegirMesa.this.dispose();
				ventanaAnterior.setVisible(true);
			}
		});
		btnVolver.setBounds(118, 300, 138, 38);
		contentPane.add(btnVolver);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(294, 122, 155, 171);
		contentPane.add(scrollPane);
		
		list = new JList();
		list.setEnabled(false);
		scrollPane.setViewportView(list);
		list.setModel(listaModeloMesasOcupadas);
		
		lblDisponibles_1 = new JLabel("MESAS DISPONIBLES:");
		lblDisponibles_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDisponibles_1.setBounds(86, 90, 197, 20);
		contentPane.add(lblDisponibles_1);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(103, 122, 155, 171);
		contentPane.add(scrollPane_1);
		
		list_1 = new JList();
		scrollPane_1.setViewportView(list_1);
		list_1.setModel(listaModeloMesasDisponibles);
		
	}
}
