package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Socio;
import gestorBD.GestorBD;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class AdministrarSocios extends JFrame {

	private JPanel contentPane;
	private ArrayList<Socio> arraySocios;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministrarSocios frame = new AdministrarSocios();
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
	public AdministrarSocios() {
		arraySocios=GestorBD.selectAllSocio();
		DefaultListModel<Socio> listaModeloSocios = new DefaultListModel();
		for (Socio s: arraySocios) {
			listaModeloSocios.addElement(s);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(41, 52, 300, 324);
		contentPane.add(list);
		list.setModel(listaModeloSocios);
		
		
		
	}
}
