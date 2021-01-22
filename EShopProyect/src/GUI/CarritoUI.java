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

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;

import BD.LLamadasBD;
import BD.UsuarioBD;
import Producto.Carrito;
import net.proteanit.sql.DbUtils;

public class CarritoUI {

	 protected JFrame frame;
	 public static ArrayList<Producto.Carrito> cr1 = new ArrayList<Producto.Carrito>();
	 JLabel lblNewLabel_1 = new JLabel("null");
	 static LLamadasBD cct= new LLamadasBD();
	 static Connection conn = cct.Conexion();
	 String nick = UsuarioBD.nickg;
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
	
		table = new JTable();
		table.setBounds(10, 11, 414, 173);
		frame.getContentPane().add(table);
		
		JButton btnNewButton = new JButton("Comprar");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printticket(VMain.carro);
				JOptionPane.showMessageDialog(frame, "COMPRA REALIZADA.");
				deletecarro(nick);
			}

			private void printticket(ArrayList<Carrito> carro) {
				try {
					double vt= 0;
					FileWriter writter = new FileWriter("tickets/Ticket.txt");
					for (int i = 0; i < carro.size(); i++) {
						vt += carro.get(i).getPrecio();
						System.out.println(vt);
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
				//	Double.toString(vt);
				//	writter.write(vt);
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
				deletecarro(nick);
				displaycarro(nick);
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
				getCarro(cr1);
				displaycarro(nick);
			}
		});
		btnNewButton_3.setBounds(211, 193, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
	
	}

	double valoraco=0;
	private JTable table;
	public void getCarro(ArrayList<Producto.Carrito> cr1) 
	{
		
		cr1 = VMain.carro;
		valoraco=VMain.precioaco;
		lblNewLabel_1.setText(Double.toString(valoraco));
		System.out.println(cr1.toString());
		System.out.println(valoraco);
		
	}
	public void displaycarro(String nickname) 
	{
		try {
			String query = "SELECT NOMBRE, PRECIO FROM CARRITO WHERE NICKNAME = '" +nickname+ "'";
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			table.setDefaultEditor(Object.class, null);

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public void deletecarro(String nickname) 
	{
		try {
			String query = "DELETE FROM CARRITO WHERE NICKNAME = '" +nickname+ "'";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.execute();
			pst.close();
			
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

