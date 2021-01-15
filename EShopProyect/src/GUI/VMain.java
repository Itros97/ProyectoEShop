package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import BD.LLamadasBD;
import BD.LinkPhoto;
import Usuario.Usuario;
import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;
import java.sql.*;
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
	protected JTextField jTextFieldID = new JTextField();
    protected JTextField jTextFieldFN = new JTextField();
    protected JTextField jTextFieldLN = new JTextField();

	
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
		
		
		JPanel pBotonera= new JPanel();
		pBotonera.setBounds(0, 0, 350, 698);
		ventanaMain.getContentPane().add(pBotonera);
		pBotonera.setLayout(null);
		
		JButton bHome = new JButton("Home");
		bHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel pHome = new JPanel();
				pHome.setBounds(0, 0, 360, 900);
				ventanaMain.getContentPane().add(pHome);
				pHome.setLayout(null);
			}
		});
		bHome.setAction(actionHome);
		bHome.setBounds(10, 10, 250, 50);
		bHome.setFocusPainted(false);
		pBotonera.add(bHome);
		
		jTextFieldID.setBounds(10, 170, 250, 20);
		pBotonera.add(jTextFieldID);
		
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
		
		JButton bAccount = new JButton("Account");
		bAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel pAccount = new JPanel();
				pAccount.setBounds(0, 0, 360, 900);
				ventanaMain.getContentPane().add(pAccount);
				pAccount.setLayout(null);
			//	VProfile vP = new VProfile(usuario);
			//	vP.frame.setVisible(true);
			}
		});
		bAccount.setAction(actionAccount);
		bAccount.setBounds(10, 510, 250, 50);
		bAccount.setFocusPainted(false);
		pBotonera.add(bAccount);
		
		JButton bHistory = new JButton("History");
		bHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel pHistory = new JPanel();
				pHistory.setBounds(0, 0, 360, 900);
				ventanaMain.getContentPane().add(pHistory);
				pHistory.setLayout(null);
			}
		});
		bHistory.setAction(actionHistory);
		bHistory.setBounds(10, 570, 250, 50);
		bHistory.setFocusPainted(false);
		pBotonera.add(bHistory);
		
		JButton bPreferences = new JButton("Preferences");
		bPreferences.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel pPreferences = new JPanel();
				pPreferences.setBounds(0, 0, 360, 900);
				ventanaMain.getContentPane().add(pPreferences);
				pPreferences.setLayout(null);
			}
		});
		bPreferences.setAction(actionPreferences);
		bPreferences.setBounds(10, 630, 250, 50);
		bPreferences.setFocusPainted(false);
		pBotonera.add(bPreferences);
		
		
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
		scrollShop.setViewportView(table);
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
							String query = "SELECT IMAGEN FROM PRODUCTO WHERE NOMBRE = ? ";
							
							PreparedStatement pst = conn.prepareStatement(query);
							pst.setString(1, table_id);
							ResultSet rs = pst.executeQuery();
							if(rs.next()) {
								lblNewLabel.setText(rs.getString(1));
								lblNewLabel.setPath(rs.getString(1));
								lblNewLabel.PutImage();
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
	private class SwingActionHome extends AbstractAction {
		public SwingActionHome() {
			putValue(NAME, "Home");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
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
	private class SwingActionAccount extends AbstractAction {
		public SwingActionAccount() {
			putValue(NAME, "A�adir a carrito");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingActionHistory extends AbstractAction {
		public SwingActionHistory() {
			putValue(NAME, "Carrito");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingActionPreferences extends AbstractAction {
		public SwingActionPreferences() {
			putValue(NAME, "Cuenta");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
		  public void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
		        
		        // get the model from the jtable
		       DefaultTableModel model = (DefaultTableModel)table.getModel();

		        // get the selected row index
		       int selectedRowIndex = table.getSelectedRow();
		       
		       
			// set the selected row data into jtextfields
		       jTextFieldID.setText(model.getValueAt(selectedRowIndex, 0).toString());
		       jTextFieldFN.setText(model.getValueAt(selectedRowIndex, 1).toString());
		       jTextFieldLN.setText(model.getValueAt(selectedRowIndex, 2).toString());

		        
		    }                
	}


