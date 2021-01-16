package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class CarritoUI {

	 protected JFrame frame;
	 public JList list = new JList(cr1.toArray());
	 public static ArrayList<Producto.Carrito> cr1 = new ArrayList<Producto.Carrito>();
	 JLabel lblNewLabel_1 = new JLabel("null");
	 /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarritoUI window = new CarritoUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CarritoUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Comprar");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getCarro(cr1);
			}
		});
		btnNewButton.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cerrar");
		btnNewButton_1.setBounds(310, 227, 114, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("LimpiarCesta");
		btnNewButton_2.setBounds(310, 193, 114, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		
		list.setBounds(10, 11, 414, 172);
		frame.getContentPane().add(list);
		
		JLabel lblNewLabel = new JLabel("Precio Total:");
		lblNewLabel.setBounds(10, 197, 71, 14);
		frame.getContentPane().add(lblNewLabel);
		
		
		lblNewLabel_1.setBounds(97, 197, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
	}

	public void cargarlista() 
	{
		System.out.println("Hola");
	}
	double valoraco=0;
	public void getCarro(ArrayList<Producto.Carrito> cr1) 
	{
		
		cr1 = VMain.carro;
		valoraco=VMain.precioaco;
		cargarlista();
		lblNewLabel_1.setText(Double.toString(valoraco));
		System.out.println(cr1.toString());
		System.out.println(valoraco);
		
	}
	
}