package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Administrador;
import datos.Producto;
import datos.TipoProducto;
import gestorBD.GestorBD;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class AnadirProducto extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JComboBox comboBox;

	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnadirProducto frame = new AnadirProducto();
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
	public AnadirProducto(Administrador admin) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Añadir Producto");
		lblNewLabel.setBounds(32, 31, 473, 55);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(lblNewLabel);
		
		JButton button = new JButton("Añadir");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				ArrayList<TipoProducto> tipos = GestorBD.selectAllTipoProducto();
				Producto p = new Producto(textField.getText(), Integer.parseInt(textField_1.getText()), tipos.get(comboBox.getSelectedIndex()), Double.parseDouble(textField_3.getText()));
				GestorBD.insertProducto(p);
				Almacen a = new Almacen(admin);
				a.setVisible(true);
				AnadirProducto.this.setVisible(false);
			}
		});
		button.setBounds(474, 299, 180, 33);
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(button);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(313, 114, 180, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setBounds(313, 151, 180, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(130, 114, 137, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Codigo");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(130, 145, 137, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo de producto");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(130, 189, 173, 25);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Almacen a = new Almacen(admin);
				a.setVisible(true);
				AnadirProducto.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(32, 299, 186, 32);
		contentPane.add(btnNewButton);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_3.setBounds(313, 237, 180, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Precio");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(130, 237, 162, 20);
		contentPane.add(lblNewLabel_4);
		
		ArrayList<TipoProducto> tipos = GestorBD.selectAllTipoProducto();
		String[] arrayTipos = new String[tipos.size()];
		for (int i=0; i<tipos.size(); i++) {
			arrayTipos[i]=tipos.get(i).getNombre();
		}
		comboBox = new JComboBox(arrayTipos);
		comboBox.setBounds(313, 194, 180, 22);
		contentPane.add(comboBox);
	}
}
