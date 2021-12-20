package presentacion;
/**
 * Ventana para los socios, representa el proceso de pago de los productos consumidos
 * @author mariasantizo y malensanz
 * @version 1
 * @since 1
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Mesa;
import datos.Producto;
import datos.Reserva;
import datos.Socio;
import datos.TipoProducto;
import gestorBD.GestorBD;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import java.awt.Scrollbar;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class Pagar extends JFrame {

	private JPanel contentPane;
	private ArrayList <Producto> productos;
	private ArrayList<negocio.Almacen> almacen;
	private ArrayList <TipoProducto> tiposProducto;
	private GestorBD bd;

	/**
	 * Create the frame.
	 */
	public Pagar(JFrame ventanaAnterior, Socio socio) {
		
		tiposProducto=GestorBD.selectAllTipoProducto();	
		productos=GestorBD.selectAllProducto(tiposProducto);

		DefaultListModel<Producto> listaModelo = new DefaultListModel<>();
		/*for (Producto p: productos) {
			listaModelo.addElement(p);		
				}*/
		
		//expresión lamda
		
		productos.stream().forEach(e -> listaModelo.addElement(e));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Login > Socios > Pagar");
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pagar.this.dispose();
				ventanaAnterior.setVisible(true);
			}
		});
		btnVolver.setBounds(74, 398, 115, 29);
		contentPane.add(btnVolver);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Pagar.this, "Pago realizado correctamente, imprimir ticket");
				Pagar.this.dispose();
				ventanaAnterior.setVisible(true);
				
			}
		});
		btnPagar.setBounds(414, 398, 115, 29);
		contentPane.add(btnPagar);
		
		JLabel lblProductos = new JLabel("Productos:");
		lblProductos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblProductos.setBounds(41, 37, 148, 20);
		contentPane.add(lblProductos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 83, 238, 286);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
			}
		});
		scrollPane.setViewportView(list);
		list.setModel(listaModelo);
		
		JLabel suma=new JLabel("");
		JSpinner spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				double importe=0;		
				suma.setBounds(398, 205, 69, 20);
				for (Producto p: productos) {
					int value = (Integer) spinner.getValue();
					importe = p.getPrecio()*value;
					suma.setText(importe+"€");
					contentPane.add(suma);
				}
			}
		});
		spinner.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		spinner.setBounds(290, 82, 66, 26);
		contentPane.add(spinner);
		
		JLabel lblTotalAPagar = new JLabel("Total a pagar:");
		lblTotalAPagar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTotalAPagar.setBounds(358, 150, 148, 39);
		contentPane.add(lblTotalAPagar);
		
	}
}
