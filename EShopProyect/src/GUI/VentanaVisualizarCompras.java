package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JTable;

import BD.LLamadasBD;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class VentanaVisualizarCompras {
	protected JTextField jTextFieldNombre = new JTextField();
	protected JTextField jTextFieldCarro = new JTextField();
	protected JTextField jTextFieldCod = new JTextField();
	JFrame frame;
	private JTable table;
	private JTable table_1;
	static LLamadasBD cct= new LLamadasBD();
	static Connection conn = cct.Conexion();
	private JTextField textField;
	private JTable table_2;
	DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaVisualizarCompras window = new VentanaVisualizarCompras();
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

	public VentanaVisualizarCompras() {
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
		
		table = new JTable();
		 table.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                jTable1MouseClicked(evt);
	            	try {
						String query = "SELECT NICKNAME,CODIGOACCESO FROM USUARIOCOD WHERE NICKNAME = '" +jTextFieldNombre.getText()+ "'";
						PreparedStatement pst = conn.prepareStatement(query);
						ResultSet rs = pst.executeQuery();
						
						
						table_1.setModel(DbUtils.resultSetToTableModel(rs));
						table_1.setDefaultEditor(Object.class, null);

					} catch (Exception e1) {
						e1.printStackTrace();
					}
	                
	            }
	        });
		table.setBounds(10, 71, 89, 154);
		frame.getContentPane().add(table);
		
		JButton btnNewButton = new JButton("Cargar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "SELECT NICKNAME FROM USUARIO";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					table.setDefaultEditor(Object.class, null);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		table_1 = new JTable();
		table_1.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	            	jTable1MouseClicked1(evt);
	            	try {
						String query = "SELECT NOMBRE,PRECIO FROM CARRITO WHERE NICKNAME = '" +jTextFieldCarro.getText()+ "'"+"AND CODIGOACCESO = '" +jTextFieldCod.getText()+"'";;
						PreparedStatement pst = conn.prepareStatement(query);
						ResultSet rs = pst.executeQuery();
						
						
						table_2.setModel(DbUtils.resultSetToTableModel(rs));
						table_2.setDefaultEditor(Object.class, null);

					} catch (Exception e1) {
						e1.printStackTrace();
					}
	                
	            }
	        });
		table_1.setBounds(109, 71, 89, 154);
		frame.getContentPane().add(table_1);
		
		JButton btnNewButton_1 = new JButton("Cerrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
			});
		btnNewButton_1.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("USUARIOS");
		lblNewLabel.setBounds(20, 46, 70, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("COMPRAS");
		lblNewLabel_1.setBounds(128, 46, 49, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(10, 15, 302, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("BUSCAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String buscar =textField.getText();
				busqueda(buscar);
			}
		});
		btnNewButton_2.setBounds(322, 14, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		table_2 = new JTable();
		table_2.setBounds(208, 71, 216, 154);
		frame.getContentPane().add(table_2);
		
		JLabel lblNewLabel_2 = new JLabel("CARRITO");
		lblNewLabel_2.setBounds(290, 46, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
	}
	 public void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
	        
	        // get the model from the jtable
	       DefaultTableModel model = (DefaultTableModel)table.getModel();

	        // get the selected row index
	       int selectedRowIndex = table.getSelectedRow();
	       
	       
		// set the selected row data into jtextfields
	       jTextFieldNombre.setText(model.getValueAt(selectedRowIndex, 0).toString());
	     
	        
	    }    
	 public void jTable1MouseClicked1(java.awt.event.MouseEvent evt) {                                     
	        
	        // get the model from the jtable
	       DefaultTableModel model = (DefaultTableModel)table_1.getModel();

	        // get the selected row index
	       int selectedRowIndex = table_1.getSelectedRow();
	       
	       
		// set the selected row data into jtextfields
	       jTextFieldCarro.setText(model.getValueAt(selectedRowIndex, 0).toString());
	       jTextFieldCod.setText(model.getValueAt(selectedRowIndex, 1).toString());
	       System.out.println(jTextFieldCod.getText());
	        
	    }   
		public void busqueda(String texto) 
		{
			try {
				String [] headers = {"Nombre","Producto","Precio"};
				String filter = ""+texto+"";
				String query ="SELECT * FROM CARRITO WHERE NICKNAME LIKE"+'"'+filter+'"';
				
				System.out.println(query);
				
				model = new DefaultTableModel(null,headers);
				PreparedStatement pst = conn.prepareStatement(query);
				ResultSet re = pst.executeQuery(query);
				
				table_2.setModel(DbUtils.resultSetToTableModel(re));
				table_2.setDefaultEditor(Object.class, null);
				
			}
			  
			catch (Exception e) {
				// TODO: handle exception
			}
		}
}
