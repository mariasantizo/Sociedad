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
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReservarMesa extends JFrame {

	private JPanel contentPane;
	private JLabel lblELEGIR;
	private JButton btnMesa1;
	private JButton btnMesa2;
	private JButton btnMesa3;
	private JButton btnMesa4;
	private JButton btnMesa5;
	private JButton btnMesa6;
	private JButton btnMesa7;
	private JButton btnMesa8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservarMesa frame = new ReservarMesa();
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
	public ReservarMesa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Reservar mesa");
		
		lblELEGIR = new JLabel("ELIJA LA MESA QUE QUIERA RESERVAR:");
		lblELEGIR.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblELEGIR.setBounds(102, 31, 469, 20);
		contentPane.add(lblELEGIR);
		
		btnMesa1 = new JButton("1");
		btnMesa1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMesa1.setBackground(Color.RED);
			}
		});
		btnMesa1.setForeground(Color.BLACK);
		btnMesa1.setBackground(Color.GREEN);
		btnMesa1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMesa1.setBounds(62, 92, 145, 44);
		contentPane.add(btnMesa1);
		
		btnMesa2 = new JButton("2");
		btnMesa2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMesa2.setBackground(Color.RED);
			}
		});
		btnMesa2.setForeground(Color.BLACK);
		btnMesa2.setBackground(Color.GREEN);
		btnMesa2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMesa2.setBounds(247, 92, 145, 44);
		contentPane.add(btnMesa2);
		
		btnMesa3 = new JButton("3");
		btnMesa3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMesa3.setBackground(Color.RED);
			}
		});
		btnMesa3.setForeground(Color.BLACK);
		btnMesa3.setBackground(Color.GREEN);
		btnMesa3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMesa3.setBounds(426, 92, 145, 44);
		contentPane.add(btnMesa3);
		
		btnMesa4 = new JButton("4");
		btnMesa4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMesa4.setBackground(Color.RED);
			}
		});
		btnMesa4.setForeground(Color.BLACK);
		btnMesa4.setBackground(Color.GREEN);
		btnMesa4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMesa4.setBounds(161, 184, 145, 44);
		contentPane.add(btnMesa4);
		
		btnMesa5 = new JButton("5");
		btnMesa5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMesa5.setBackground(Color.RED);
			}
		});
		btnMesa5.setForeground(Color.BLACK);
		btnMesa5.setBackground(Color.GREEN);
		btnMesa5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMesa5.setBounds(336, 184, 145, 44);
		contentPane.add(btnMesa5);
		
		btnMesa6 = new JButton("6");
		btnMesa6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMesa6.setBackground(Color.RED);
			}
		});
		btnMesa6.setForeground(Color.BLACK);
		btnMesa6.setBackground(Color.GREEN);
		btnMesa6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMesa6.setBounds(62, 265, 145, 44);
		contentPane.add(btnMesa6);
		
		btnMesa7 = new JButton("7");
		btnMesa7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMesa7.setBackground(Color.RED);
			}
		});
		btnMesa7.setForeground(Color.BLACK);
		btnMesa7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMesa7.setBackground(Color.GREEN);
		btnMesa7.setBounds(247, 265, 145, 44);
		contentPane.add(btnMesa7);
		
		btnMesa8 = new JButton("8");
		btnMesa8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMesa8.setBackground(Color.RED);
			}
		});
		btnMesa8.setForeground(Color.BLACK);
		btnMesa8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMesa8.setBackground(Color.GREEN);
		btnMesa8.setBounds(426, 265, 145, 44);
		contentPane.add(btnMesa8);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(494, 359, 115, 29);
		contentPane.add(btnAceptar);
	}
}
