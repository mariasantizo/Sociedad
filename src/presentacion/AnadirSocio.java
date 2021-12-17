package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Administrador;
import datos.Socio;
import gestorBD.GestorBD;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class AnadirSocio extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldDNI;
	private JTextField textFieldTelefono;
	private JTextField textFieldDireccion;
	private JTextField textFieldNumeroSocio;
	private JLabel lblNewLabel_7;
	private JComboBox comboBox;

	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnadirSocio frame = new AnadirSocio();
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
	public AnadirSocio(Administrador admin) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Añadir Socio");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setBounds(33, 37, 279, 39);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				Socio s = new Socio(textFieldDNI.getText(), textFieldNombre.getText(), textFieldApellido.getText(), Integer.parseInt(textFieldTelefono.getText()), textFieldDireccion.getText(), Integer.parseInt(textFieldNumeroSocio.getText()), (String)comboBox.getSelectedItem(), 960);
				GestorBD.insertSocio(s);
				AdministrarSocios a = new AdministrarSocios(admin);
				a.setVisible(true);
				AnadirSocio.this.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(499, 398, 184, 33);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(87, 87, 117, 33);
		contentPane.add(lblNewLabel_1);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldNombre.setBounds(268, 87, 279, 30);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldApellido.setBounds(268, 128, 279, 30);
		contentPane.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(87, 131, 129, 25);
		contentPane.add(lblNewLabel_2);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldDNI.setBounds(268, 170, 279, 25);
		contentPane.add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("DNI: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(87, 167, 117, 30);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Teléfono: ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(87, 208, 129, 25);
		contentPane.add(lblNewLabel_4);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldTelefono.setBounds(268, 206, 279, 30);
		contentPane.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Dirección: ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(87, 244, 129, 25);
		contentPane.add(lblNewLabel_5);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldDireccion.setBounds(268, 247, 279, 26);
		contentPane.add(textFieldDireccion);
		textFieldDireccion.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Número de socio: ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(87, 288, 171, 25);
		contentPane.add(lblNewLabel_6);
		
		textFieldNumeroSocio = new JTextField();
		textFieldNumeroSocio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldNumeroSocio.setBounds(268, 284, 279, 29);
		contentPane.add(textFieldNumeroSocio);
		textFieldNumeroSocio.setColumns(10);
		
		lblNewLabel_7 = new JLabel("Tipo de cuota: ");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(85, 332, 154, 25);
		contentPane.add(lblNewLabel_7);
		
		String[] tiposCuota= {"Anual", "Semestral", "Trimestral", "Mensual"};
		comboBox = new JComboBox(tiposCuota);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setBounds(268, 337, 279, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdministrarSocios a = new AdministrarSocios(admin);
				a.setVisible(true);
				AnadirSocio.this.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(48, 398, 145, 33);
		contentPane.add(btnNewButton_1);
	}
}
