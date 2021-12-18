package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Administrador;
import datos.MergeSort;
import datos.Ordenable;
import datos.Producto;
import datos.QuickSort;
import datos.TipoProducto;
import gestorBD.GestorBD;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Almacen extends JFrame {

	private JPanel contentPane;
	private ArrayList<TipoProducto> tipos;
	private ArrayList<Producto> productos;

	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Almacen frame = new Almacen();
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
	public Almacen(Administrador admin) {
		tipos=GestorBD.selectAllTipoProducto();
		productos=GestorBD.selectAllProducto(tipos);
		DefaultListModel<Producto> listaModeloProductos = new DefaultListModel<Producto>();
		for (Producto p: productos) {
			listaModeloProductos.addElement(p);
		}
		Producto prod = new Producto("Bolsa de limones", 1, null, 2.5);
		listaModeloProductos.addElement(prod);
		productos.add(prod);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(55, 64, 256, 257);
		contentPane.add(list);
		list.setModel(listaModeloProductos);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministrarCuentas cuentas = new AdministrarCuentas(admin);
				cuentas.setVisible(true);
				Almacen.this.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(394, 284, 213, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Añadir producto");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(394, 140, 213, 37);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Almacén");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(55, 22, 213, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valor del almacén:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(394, 65, 213, 37);
		contentPane.add(lblNewLabel_1);
		
		double importe=0;
		for (Producto p: productos) {
			importe=importe+p.getPrecio();
		}
		JLabel lblNewLabel_2 = new JLabel(importe+"€");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(394, 98, 213, 31);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("Ordenar Con MergeSort");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ordenable<Producto> current = new QuickSort<Producto>();
				current.ordenar(productos, 0, productos.size());
				DefaultListModel<Producto> listaModeloProductos = new DefaultListModel<Producto>();
				listaModeloProductos=null;
				for (Producto p: productos) {
					listaModeloProductos.addElement(p);
					list.setModel(listaModeloProductos);
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(394, 202, 213, 31);
		contentPane.add(btnNewButton_2);
	}
}
