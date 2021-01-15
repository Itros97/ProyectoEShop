package GUI;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
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
import BD.UsuarioBD;
import Producto.Producto;
import net.proteanit.sql.DbUtils;

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
		JButton bShop = new JButton("Shop");
		bShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				try {
					String query = "SELECT name, prize, desc FROM product";
					PreparedStatement pst = LLamadasBD.Conexion().prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					System.out.println();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					table.setDefaultEditor(Object.class, null);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
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
		list.setBounds(20, 42, 283, 162);
		frame.getContentPane().add(list);
		cargarTabla();
		
		JScrollPane scrollShop = new JScrollPane();
		scrollShop.setBounds(10, 11, 404, 227);
		frame.getContentPane().add(scrollShop);
		
		table = new JTable();
		scrollShop.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("LOAD");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				try {
					String query = "SELECT NOMBRE, PRECIO, DESCRIPCION FROM PRODUCTO";
					PreparedStatement pst = LLamadasBD.Conexion().prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					System.out.println();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					table.setDefaultEditor(Object.class, null);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setBounds(10, 238, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		Thread row = new Thread () {
			@Override
			public void run () {
				while(table.isEnabled()) {
					//System.out.println("W");
					if(table.getSelectedRow() < 0) {
						lblNewLabel.setText("");
					}
					else {
						String table_id = table.getValueAt(table.getSelectedRow(), 0).toString();
						//System.out.println(table_id);
						//lblNewLabel.setText(""+table_id);
						try {
							String query = "SELECT image FROM product where name = ? ";
							
							PreparedStatement pst = LLamadasBD.Conexion().prepareStatement(query);
							pst.setString(1, table_id);
							ResultSet rs = pst.executeQuery();
							if(rs.next()) {
								lblNewLabel.setText(rs.getString(1));
							//	lblNewLabel.setPath(rs.getString(1));
							//	lblNewLabel.PutImage();
								//System.out.println(rs.getString(1));
							}
						}catch (Exception e) {
							System.out.println(e);
							e.printStackTrace();
						}
					}
				}
			}
		};
		row.start();
	}
	
		private void cargarTabla() 
		{
			
			
		}
}
