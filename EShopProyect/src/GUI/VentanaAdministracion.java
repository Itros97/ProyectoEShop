package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;

public class VentanaAdministracion {

	protected JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAdministracion window = new VentanaAdministracion();
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
	public VentanaAdministracion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JButton bcerrar = new JButton("Cerrar");
		springLayout.putConstraint(SpringLayout.NORTH, bcerrar, 238, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, bcerrar, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, bcerrar, 434, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(bcerrar);
		bcerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		JButton busuario = new JButton("Usuario");
		springLayout.putConstraint(SpringLayout.WEST, busuario, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, busuario, 434, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(busuario);
		busuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton bproducto = new JButton("Producto");
		springLayout.putConstraint(SpringLayout.NORTH, busuario, 6, SpringLayout.SOUTH, bproducto);
		springLayout.putConstraint(SpringLayout.NORTH, bproducto, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, bproducto, -198, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, bproducto, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, bproducto, 0, SpringLayout.EAST, bcerrar);
		frame.getContentPane().add(bproducto);
		
		JButton btnNewButton = new JButton("Generar codigos de descuento");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Codigos window = new Codigos();
				window.frame.setVisible(true);
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, busuario, -6, SpringLayout.NORTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, -89, SpringLayout.NORTH, bcerrar);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -6, SpringLayout.NORTH, bcerrar);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, bcerrar);
		frame.getContentPane().add(btnNewButton);
		bproducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				VentanaAnyadirProducto v1 = new VentanaAnyadirProducto();
			}
		});
	
	}
}
