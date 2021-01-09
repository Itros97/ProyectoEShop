package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaAnyadirProducto {

	private JFrame frame;
	private JTextField tfnombre;
	private JTextField tfprecio;
	private JTextField tfstock;
	private JTextField tfdescripcion;
	private JTextField tfimagen;
	private JTextField tfmarca;


	public VentanaAnyadirProducto() {
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
		
		JButton btnNewButton = new JButton("Crear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		tfnombre = new JTextField();
		tfnombre.setBounds(10, 36, 86, 20);
		frame.getContentPane().add(tfnombre);
		tfnombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Precio");
		lblNewLabel_1.setBounds(10, 66, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		tfprecio = new JTextField();
		tfprecio.setBounds(10, 91, 86, 20);
		frame.getContentPane().add(tfprecio);
		tfprecio.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Stock");
		lblNewLabel_2.setBounds(10, 122, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		tfstock = new JTextField();
		tfstock.setBounds(10, 147, 86, 20);
		frame.getContentPane().add(tfstock);
		tfstock.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Descripcion");
		lblNewLabel_3.setBounds(295, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		tfdescripcion = new JTextField();
		tfdescripcion.setBounds(293, 36, 86, 20);
		frame.getContentPane().add(tfdescripcion);
		tfdescripcion.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Imagen(Ruta)");
		lblNewLabel_4.setBounds(295, 66, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		tfimagen = new JTextField();
		tfimagen.setBounds(293, 91, 86, 20);
		frame.getContentPane().add(tfimagen);
		tfimagen.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Marca");
		lblNewLabel_5.setBounds(295, 122, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		tfmarca = new JTextField();
		tfmarca.setBounds(293, 147, 86, 20);
		frame.getContentPane().add(tfmarca);
		tfmarca.setColumns(10);
	}
}
