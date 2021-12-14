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
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTree;

public class AdministrarSocios extends JFrame {

	private JPanel contentPane;
	private ArrayList<Socio> arraySocios;
	private JList<Socio> list;

	
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
		DefaultListModel<Socio> listaModeloSocios = new DefaultListModel<>();
		for (Socio s: arraySocios) {
			listaModeloSocios.addElement(s);
			System.out.println("entro");
		}
		Socio s = new Socio();
		s.setNombre("a");
		listaModeloSocios.addElement(s);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 63, 300, 341);
		contentPane.add(scrollPane);
		
		
		list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(listaModeloSocios);
		
		JLabel lblNewLabel = new JLabel("Socios");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(58, 26, 136, 26);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ver Información");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedIndex()==-1) {
					
				} else {
				Socio socio = listaModeloSocios.get(list.getSelectedIndex());
				FichaSocio fichaSocio = new FichaSocio (socio);
				fichaSocio.setVisible(true);
				AdministrarSocios.this.setVisible(false);
				}
			}
		});
		btnNewButton.setBounds(397, 112, 241, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Eliminar socio");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(397, 250, 241, 32);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Añadir socio");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(397, 184, 241, 32);
		contentPane.add(btnNewButton_2);
		
	}
}
