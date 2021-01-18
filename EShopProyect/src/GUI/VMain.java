package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonValue;

import BD.CarritoBD;
import BD.LLamadasBD;
import BD.LinkPhoto;
import BD.UsuarioBD;
import Producto.Carrito;
import Usuario.Usuario;
import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JLabel;

public class VMain {

	public JFrame ventanaMain;
	private final Action actionHome = new SwingActionHome();
	private final Action actionShop = new SwingActionShop();
	private final Action actionAccount = new SwingActionAccount();
	private final Action actionHistory = new SwingActionHistory();
	private final Action actionPreferences = new SwingActionPreferences();
	private JTable table;
	private static Usuario usuario;
	private LinkPhoto lblNewLabel;
	protected JTextField jTextFieldNombre = new JTextField();
    protected JTextField jTextFieldPrecio = new JTextField();
    protected JTextField jTextFieldLN = new JTextField();
    public static ArrayList<Carrito> carro = new ArrayList<Carrito>();
	public static double precioaco=0;
	 public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VMain window = new VMain(usuario);
					window.ventanaMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 
	JButton bAdministar = new JButton("Administrar");
	JPanel pBotonera= new JPanel();
	LLamadasBD cct= new LLamadasBD();
	Connection conn = null;
	/**
	 * Create the application.
	 */
	public VMain(Usuario us) {
		this.usuario = us;
		initialize();
		conn = cct.Conexion();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventanaMain = new JFrame();
		ventanaMain.setResizable(false);
		ventanaMain.setBounds(100, 100, 1280, 720);
		ventanaMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaMain.getContentPane().setLayout(null);
		
		
	
		pBotonera.setBounds(0, 0, 350, 698);
		ventanaMain.getContentPane().add(pBotonera);
		pBotonera.setLayout(null);
		
		
		bAdministar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel pHome = new JPanel();
				pHome.setBounds(0, 0, 360, 900);
				ventanaMain.getContentPane().add(pHome);
				pHome.setLayout(null);
			}
		});
		bAdministar.setAction(actionHome);
		bAdministar.setBounds(10, 10, 250, 50);
		bAdministar.setFocusPainted(false);
		
		
		jTextFieldNombre.setBounds(10, 170, 250, 20);
		pBotonera.add(jTextFieldNombre);
		
		JButton bShop = new JButton("Shop");
		bShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "SELECT NOMBRE, PRECIO, DESCRIPCION FROM PRODUCTO";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					table.setDefaultEditor(Object.class, null);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		bShop.setAction(actionShop);
		bShop.setBounds(10, 70, 250, 50);
		bShop.setFocusPainted(false);
		pBotonera.add(bShop);
		
		JButton baddcarrito = new JButton("Añadir al carrito");
		baddcarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel pAccount = new JPanel();
				pAccount.setBounds(0, 0, 360, 900);
				ventanaMain.getContentPane().add(pAccount);
				pAccount.setLayout(null);
			}
		});
		baddcarrito.setAction(actionAccount);
		baddcarrito.setBounds(10, 510, 250, 50);
		baddcarrito.setFocusPainted(false);
		pBotonera.add(baddcarrito);
		
		JButton bcarrito = new JButton("Carrito");
		bcarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel pHistory = new JPanel();
				pHistory.setBounds(0, 0, 360, 900);
				ventanaMain.getContentPane().add(pHistory);
				pHistory.setLayout(null);
			}
		});
		bcarrito.setAction(actionHistory);
		bcarrito.setBounds(10, 570, 250, 50);
		bcarrito.setFocusPainted(false);
		pBotonera.add(bcarrito);
		
		JButton bHistorial = new JButton("Historial");
		bHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel pPreferences = new JPanel();
				pPreferences.setBounds(0, 0, 360, 900);
				ventanaMain.getContentPane().add(pPreferences);
				pPreferences.setLayout(null);
			}
		});
		bHistorial.setAction(actionPreferences);
		bHistorial.setBounds(10, 630, 250, 50);
		bHistorial.setFocusPainted(false);
		pBotonera.add(bHistorial);
		
		
		String path = "";
		lblNewLabel = new LinkPhoto("foto");
		lblNewLabel.setBounds(47, 335, 165, 162);
		pBotonera.add(lblNewLabel);
		
		JScrollPane scrollShop = new JScrollPane();
		scrollShop.setBounds(372, 36, 884, 581);
		ventanaMain.getContentPane().add(scrollShop);
		
		table = new JTable();
		   table.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                jTable1MouseClicked(evt);
	            }
	        });
		   setAdministrarvisible();
		scrollShop.setViewportView(table);
		//Hilo de ejecuccion que permite que podamos seleccionar entre disitintos elementos de la tabla y hacer display de su foto
		//ya que mientras hace display de ella la app se quedaria colgada
		Thread showpic = new Thread () {
			@Override
			public void run () {
				while(table.isEnabled()) {
					if(table.getSelectedRow() < 0) {
						lblNewLabel.setText("");
					}
					else {
						String table_id = table.getValueAt(table.getSelectedRow(), 0).toString();

						try {
							String query = "SELECT IMAGEN FROM PRODUCTO WHERE NOMBRE = ? ";
							
							PreparedStatement pst = conn.prepareStatement(query);
							pst.setString(1, table_id);
							ResultSet rs = pst.executeQuery();
							if(rs.next()) {
								lblNewLabel.setText(rs.getString(1));
								lblNewLabel.setPath(rs.getString(1));
								lblNewLabel.PutImage(lblNewLabel);
								
							}
						}catch (Exception e) {
							System.out.println(e);
							e.printStackTrace();
						}
					}
				}
			}
		};
		showpic.start();
	}
	protected void setAdministrarvisible() 
	{
		
		if(UsuarioBD.getUsuario(UsuarioBD.nickg).isTipo_cuenta()== true)
		{
			pBotonera.add(bAdministar);
		}
		else 
		{
			
		}
	}
	private class SwingActionHome extends AbstractAction {
		public SwingActionHome() {
			putValue(NAME, "Administar");
			putValue(SHORT_DESCRIPTION, "Boton de administracion");
		}
		public void actionPerformed(ActionEvent e) {
			VentanaAdministracion v1 = new VentanaAdministracion();
			v1.frame.setVisible(true);
			System.out.println("Abres el admin");
		}
	}
	private class SwingActionShop extends AbstractAction {
		public SwingActionShop() {
			putValue(NAME, "Tienda");
			putValue(SHORT_DESCRIPTION, "Accedes a la tienda");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	int i =0;
	private class SwingActionAccount extends AbstractAction {
		public SwingActionAccount() {
			putValue(NAME, "Añadir a carrito");
			putValue(SHORT_DESCRIPTION, "Añade el objeto al carrito");
		}
		public void actionPerformed(ActionEvent e) {
			insertCarro(carro);
		}
	}
	private class SwingActionHistory extends AbstractAction {
		public SwingActionHistory() {
			putValue(NAME, "Carrito");
			putValue(SHORT_DESCRIPTION, "Accede a la ventana carrito");
		}
		public void actionPerformed(ActionEvent e) {
			CarritoUI crui1 = new CarritoUI();
			crui1.frame.setVisible(true);
			getCarro(carro);
		}
	}
	public void getdata() 
	{
		
	}
	public ArrayList<Carrito> insertCarro(ArrayList<Carrito> carro)
	{
		Carrito c1 = new Carrito();
		c1.setId_carrito(i);
		c1.setNickname(UsuarioBD.nickg);
		c1.setNombre(jTextFieldNombre.getText());
		c1.setPrecio(Double.parseDouble(jTextFieldPrecio.getText()));
		CarritoBD.InsertarCarrito(c1);
		carro.add(c1);
		i++;
		System.out.println(c1.toString());
		return carro;

	}

	public ArrayList<Carrito> getCarro(ArrayList<Carrito> carro)
	{
		
		for (int i = 0; i < carro.size(); i++)
		{
			System.out.println(carro.get(i));
			precioaco +=carro.get(i).precio;
		}
		System.out.println(precioaco);
		return carro;

	}
	
	private class SwingActionPreferences extends AbstractAction {
		public SwingActionPreferences() {
			putValue(NAME, "Historial");
			putValue(SHORT_DESCRIPTION, "Accede a las compras de la cuenta");
		}
		public void actionPerformed(ActionEvent e) {
			getCarro(carro);
			
		}
	}
		  public void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
		        
		        // get the model from the jtable
		       DefaultTableModel model = (DefaultTableModel)table.getModel();

		        // get the selected row index
		       int selectedRowIndex = table.getSelectedRow();
		       
		       
			// set the selected row data into jtextfields
		       jTextFieldNombre.setText(model.getValueAt(selectedRowIndex, 0).toString());
		       jTextFieldPrecio.setText(model.getValueAt(selectedRowIndex, 1).toString());
		       jTextFieldLN.setText(model.getValueAt(selectedRowIndex, 2).toString());

		        
		    }                
	}


