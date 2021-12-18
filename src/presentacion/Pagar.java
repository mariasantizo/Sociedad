package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Socio;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JToggleButton;
import java.awt.Scrollbar;
import javax.swing.JSpinner;

public class Pagar extends JFrame {

	private JPanel contentPane;

	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pagar frame = new Pagar();
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
	public Pagar(JFrame ventanaAnterior, Socio socio) {
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
		btnPagar.setBounds(414, 398, 115, 29);
		contentPane.add(btnPagar);
		
		JLabel lblProductos = new JLabel("Productos:");
		lblProductos.setBounds(41, 37, 148, 20);
		contentPane.add(lblProductos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 83, 238, 286);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(324, 82, 32, 26);
		contentPane.add(spinner);
	}
}
