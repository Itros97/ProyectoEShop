package GUI;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

import Producto.Balon;
import Producto.PintaLabios;
import Producto.Ordenador;
import Producto.Producto;
import Producto.Camiseta;
import Tienda.Tienda;
import Usuario.Usuario;

public class VentanaTienda extends JFrame {

	protected JTextField textField;
	protected JButton botonBuscar;
	protected JButton botonComprar;
	protected JButton botonEliminar;
	public JButton botonAdministar;
	public JButton botonCargar;
	protected JButton anadir;
	protected JLabel cesta;
	protected JCheckBox checkBox1;
	protected JCheckBox checkBox2;
	protected JCheckBox checkBox3;
	protected JCheckBox checkBox4;
	protected JCheckBox checkBox5;
	protected JCheckBox checkBox6;

	protected JPanel panelNorth;
	protected JPanel panelEast;
	protected JPanel panelS;
	protected JPanel panelCestaSouth;
	protected JPanel panelCestaCenter;
	
	JMenuBar barra;
	JMenu cliente;
	JMenuItem editar;
	JMenuItem cerrarSesion;

	JList<Producto> listaProducto;
	DefaultListModel<Producto> modeloProducto;
	JList<Producto> listaCarro;
	DefaultListModel<Producto> modeloCarro;
	JScrollPane scrollProducto;
	JScrollPane scrollCarro;
	VentanaTienda ventana;
	

	public VentanaTienda(Tienda tienda) {
		
		barra = new JMenuBar();
		cliente = new JMenu("Cliente");
		cerrarSesion = new JMenuItem("Cerrar sesion");
		editar = new JMenuItem("Editar datos");

		textField = new JTextField(20);
		botonBuscar = new JButton("Buscar");
		botonComprar = new JButton("Comprar");
		botonEliminar = new JButton("Eliminar");
		botonAdministar = new JButton("Administar");
		botonCargar = new JButton("Cargar");
		anadir = new JButton("Agregar al carrito");
		botonComprar.setSize(100, 100);
		cesta = new JLabel("--------------------Cesta---------------------");
		checkBox1 = new JCheckBox();
		checkBox2 = new JCheckBox();
		checkBox3 = new JCheckBox();
		checkBox4 = new JCheckBox();
		checkBox5 = new JCheckBox();
		checkBox6 = new JCheckBox();

		panelCestaCenter = new JPanel();
		panelCestaCenter.setLayout(new GridLayout(10, 1));
		panelNorth = new JPanel();
		panelEast = new JPanel();
		panelS = new JPanel();
		panelCestaSouth = new JPanel();
		panelCestaSouth.setLayout(new GridLayout(2, 1));
		panelEast.setLayout(new BorderLayout());
		panelEast.setBorder(BorderFactory.createLineBorder(Color.black));

		panelCestaSouth.add(botonEliminar);
		panelCestaSouth.add(botonComprar);
		panelCestaSouth.add(botonAdministar);
		panelCestaSouth.add(botonCargar);
		panelNorth.add(textField);
		panelNorth.add(botonBuscar);
		panelEast.add(cesta, BorderLayout.NORTH);
		panelEast.add(panelCestaSouth, BorderLayout.SOUTH);
		panelEast.add(panelCestaCenter, BorderLayout.CENTER);
		panelCestaCenter.add(checkBox1);
		panelCestaCenter.add(checkBox2);
		panelCestaCenter.add(checkBox3);
		panelCestaCenter.add(checkBox4);
		panelCestaCenter.add(checkBox5);
		panelCestaCenter.add(checkBox6);
		panelS.add(anadir);

		add(panelNorth, BorderLayout.NORTH);
		add(panelEast, BorderLayout.EAST);
		add(panelS, BorderLayout.SOUTH);

		modeloProducto = new DefaultListModel<Producto>();
		listaProducto = new JList<Producto>(modeloProducto);
		scrollProducto = new JScrollPane(listaProducto);

		for (Producto ropa : tienda.getProductos()) {
			modeloProducto.addElement(ropa);
		}

		modeloCarro = new DefaultListModel<Producto>();
		listaCarro = new JList<Producto>(modeloCarro);
		scrollCarro = new JScrollPane(listaCarro);

		botonBuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		anadir.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				Producto producto = listaProducto.getSelectedValue();


				if (producto instanceof Balon) {
					Balon nueva;
					Balon balon = (Balon) listaProducto.getSelectedValue();
					nueva = new Balon(balon);
					
					modeloCarro.addElement(nueva);	
					tienda.getCarro().getProducto().add(nueva);

				} else if (producto instanceof Camiseta) {
					Camiseta nueva;
					Camiseta camiseta = (Camiseta) listaProducto.getSelectedValue();
					nueva = new Camiseta(camiseta);

					modeloCarro.addElement(nueva);
					tienda.getCarro().getProducto().add(nueva);


				} else if (producto instanceof Ordenador) {
					Ordenador nueva;
					Ordenador ordenador = (Ordenador) listaProducto.getSelectedValue();
					nueva = new Ordenador(ordenador);

					modeloCarro.addElement(nueva);
					tienda.getCarro().getProducto().add(nueva);
				} else {

					PintaLabios nueva;
					PintaLabios pintaLabios = (PintaLabios) listaProducto.getSelectedValue();
					nueva = new PintaLabios(pintaLabios);

					modeloCarro.addElement(nueva);
					tienda.getCarro().getProducto().add(nueva);
				}

			}
		});

		botonComprar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaProgreso(tienda);
			}
		});
				
		botonAdministar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//setadmin(null);
				VentanaAdministracion window = new VentanaAdministracion();
				window.frame.setVisible(true);
			}
		});

		botonEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Producto producto = listaCarro.getSelectedValue();
				tienda.getCarro().getProducto().remove(producto);
				modeloCarro.removeElement(producto);
			}
		});
		

		editar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaEditarUsuario v = new VentanaEditarUsuario(tienda.getConectado(), tienda);
				
				
			}
		});
		cerrarSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal v = new VentanaPrincipal();
				dispose();
				
			}
		});
		
		
		cliente.add(editar);
		cliente.add(cerrarSesion);
		barra.add(cliente);
		setJMenuBar(barra);


		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("TIENDA DE ROPA");
		setSize(900, 500);
		setLocationRelativeTo(null);
		setVisible(true);
	}
/*
	public void setadmin(Usuario u) 
	{
		if(u.isTipo_cuenta()== true || u.equals(null))
		{
			
			botonAdministar.setVisible(true);
		}
		else
			botonAdministar.setVisible(false);
	}
	*/ 
}
