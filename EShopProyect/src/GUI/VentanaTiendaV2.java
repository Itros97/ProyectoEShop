package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.xdevapi.PreparableStatement;

import BD.LLamadasBD;
import Producto.Producto;

public class VentanaTiendaV2 {

	public JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaTiendaV2 window = new VentanaTiendaV2();
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
	public VentanaTiendaV2() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(313, 43, 111, 162);
		frame.getContentPane().add(table);
		
		JButton btnNewButton = new JButton("Comprar");
		btnNewButton.setBounds(323, 205, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Administrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(323, 238, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Carrito");
		lblNewLabel.setBounds(344, 27, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tienda");
		lblNewLabel_1.setBounds(10, 27, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JList list = new JList();
		list.setBounds(20, 42, 280, 162);
		frame.getContentPane().add(list);
		cargarproductos();
	}
	
	protected void cargarproductos() 
	{
	//	list.setRowCount(0);

		PreparedStatement ps;
		ResultSet rs;
		java.sql.ResultSetMetaData rsmd;
		int columnas;
	
		try {
		Connection con = LLamadasBD.Conexion();	
		ps = con.prepareStatement("SELECT * FROM PRODUCTO");
		rs= ps.executeQuery();
		rsmd= rs.getMetaData();
		columnas = rsmd.getColumnCount();
		System.out.println("Se ha inicializado");
		
		while(rs.next()) 
		{
			
			System.out.println(columnas);
			Object[] fila = new Object[columnas];
			for (int i = 0; i < columnas; i++) {
				fila[i] = rs.getObject(i+1);
			}
			modelo.addRow(fila);
		}
		
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.toString());
		}
	}
}
