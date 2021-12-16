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
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class ElegirMesa extends JFrame {

	private JPanel contentPane;
	private JLabel lblELEGIR;
	private JLabel lblDisponibles;
	private JLabel lblReservados;
	private JLabel lblPlanoDelComedor;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElegirMesa frame = new ElegirMesa();
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
	public ElegirMesa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 697);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Reservar mesa");
		
		lblELEGIR = new JLabel("Reserva de mesa: \r\nComida el 16-12-2021");
		lblELEGIR.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblELEGIR.setBounds(78, 33, 437, 54);
		contentPane.add(lblELEGIR);
		
		lblDisponibles = new JLabel("DISPONIBLES");
		lblDisponibles.setBounds(77, 117, 161, 20);
		contentPane.add(lblDisponibles);
		
		lblReservados = new JLabel("RESERVADOS:");
		lblReservados.setBounds(365, 117, 134, 20);
		contentPane.add(lblReservados);
		
		lblPlanoDelComedor = new JLabel("PLANO DEL COMEDOR:");
		lblPlanoDelComedor.setBounds(209, 327, 207, 20);
		contentPane.add(lblPlanoDelComedor);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Alumno\\Documents\\Workspace\\Proyecto\\plano.png"));
		lblNewLabel.setBounds(102, 345, 368, 275);
		contentPane.add(lblNewLabel);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Mesa 1", "Mesa 2", "Mesa 3", "Mesa 4", "Mesa 5"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(77, 153, 106, 147);
		contentPane.add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(364, 153, 106, 147);
		contentPane.add(list_1);
	}
}
