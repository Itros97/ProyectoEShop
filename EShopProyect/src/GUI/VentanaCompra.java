package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BD.CarritoBD;
import BD.LLamadasBD;
import BD.UsuarioBD;
import BD.UsuarioconcodBD;
import Producto.Carrito;
import Tiendapck.Usuarioconcod;
import net.proteanit.sql.DbUtils;

public class VentanaCompra {
	private final static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	 protected JFrame frame;
	 public ArrayList<Producto.Carrito> cr1 = VentanaTienda.carro;
	 JLabel lblNewLabel_1 = new JLabel("null");
	 static LLamadasBD cct= new LLamadasBD();
	 static Connection conn = cct.Conexion();
	 String nick = UsuarioBD.nickg;
	 String codigoac = UsuarioBD.cods;
	 double valoraco=0;
	 HashMap<Usuarioconcod,ArrayList<Producto.Carrito>> histo = new HashMap<Usuarioconcod,ArrayList<Producto.Carrito>>();
	 //Hashmap que guarda la compra del momento
	
	 /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				VentanaCompra window = new VentanaCompra();
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
	public VentanaCompra() {
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
		table.setBounds(10, 11, 414, 173);
		frame.getContentPane().add(table);
		
		JButton btnNewButton = new JButton("Comprar");		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuarioconcod u1 = new Usuarioconcod(nick, codigoac);
				UsuarioconcodBD.InsertarUsuarioconcod(u1);
				histo.put(u1, cr1);
				printticket(VentanaTienda.carro);
			
	
				JOptionPane.showMessageDialog(frame, "COMPRA REALIZADA.");
				try {
					//Generar el txt del log
					FileHandler fh = new FileHandler("Loggers\\loggercompra.txt");//Tambien se puede usar .log en vez de .txt
					fh.setLevel(Level.FINE);
					log.addHandler(fh);
				} catch (SecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					log.log(Level.INFO, "Compra realizada: "+VentanaTienda.carro.toString());
				//	deletecarro(nick, codigoac);
				
				lblNewLabel_1.setText(Double.toString(0.0));
				System.out.println(histo.toString());
				UsuarioBD.generarcodigoacceso();//Genero un codigo nuevo de acceso para que cuando se acceda al carrito sin haber cerrado la sesion, no se borre la ultima compra efectuada
			}

			private void printticket(ArrayList<Carrito> carro) {
				try {
				
					FileWriter writter = new FileWriter("tickets/Ticket.txt");
					for (int i = 0; i < carro.size(); i++) {
						writter.write("Datos prod: \n");
						writter.write(carro.get(i).toString());
						writter.write("\n");
						if(carro.size()-i > 1 ) {
						writter.write("-----");
						writter.write("\n");
						}
					}
					writter.write("--------------- \n");
					writter.write("Precio Total: \n");
			
					writter.write((int) (VentanaTienda.precioaco));
					writter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cerrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(310, 227, 114, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("LimpiarCesta");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(nick);
				cr1.clear();
				deletecarro(nick, codigoac);
				displaycarro(nick, codigoac);
				lblNewLabel_1.setText(Double.toString(0.0));
			}
		});
		btnNewButton_2.setBounds(310, 193, 114, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Precio Total:");
		lblNewLabel.setBounds(10, 197, 71, 14);
		frame.getContentPane().add(lblNewLabel);
		
		
		lblNewLabel_1.setBounds(97, 197, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_3 = new JButton("Abrir Cesta");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valoraco=0;
				getCarro(cr1);
				displaycarro(nick, codigoac);
			}
		});
		btnNewButton_3.setBounds(211, 193, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
	
	}

	
	private JTable table;
	public void getCarro(ArrayList<Producto.Carrito> cr1) 
	{
		
	//	cr1 = VMain.carro;
		for (int i = 0; i < cr1.size(); i++) {
			System.out.println(i);
			valoraco += cr1.get(i).getPrecio();
		}
		lblNewLabel_1.setText(Double.toString(valoraco));
		System.out.println(cr1.toString());
		System.out.println(valoraco);
		
	}
	public void displaycarro(String nickname,String codigoac) //Se muestra todo el carrito ya que no esta configurado aun lo del codigo de acceso
	{
		try {
			String query = "SELECT NOMBRE, PRECIO FROM CARRITO WHERE NICKNAME = '" +nickname+ "'"+"AND CODIGOACCESO = '" +codigoac+"'";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			table.setDefaultEditor(Object.class, null);
			System.out.println(cr1.isEmpty());
			if(cr1.size()==0) 
			{
				System.out.println("HOLA");
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public void deletecarro(String nickname,String codigoac) 
	{
		try {
			String query = "DELETE FROM CARRITO WHERE NICKNAME = '" +nickname+"'"+"AND CODIGOACCESO = '" +codigoac+"'";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.execute();
			pst.close();
			displaycarro(nickname, codigoac);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void aplicardescuento(String code) 
	{
		try {
			String query = "DELETE FROM CODIGOS WHERE CODIGO = '" +code+ "'";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.execute();
			pst.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	}

