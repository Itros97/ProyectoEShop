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

public class VentanaTienda extends JFrame {

	protected JTextField textField;
	protected JButton botonBuscar;
	protected JButton botonComprar;
	protected JButton botonEliminar;
	protected JButton a�adir;
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

	JList<Producto> listaProducto;
	DefaultListModel<Producto> modeloProducto;
	JList<Producto> listaCarro;
	DefaultListModel<Producto> modeloCarro;
	JScrollPane scrollProducto;
	JScrollPane scrollCarro;
	VentanaTienda ventana;

	public VentanaTienda(Tienda tienda) {

		textField = new JTextField(20);
		botonBuscar = new JButton("Buscar");
		botonComprar = new JButton("Comprar");
		botonEliminar = new JButton("Eliminar");
		a�adir = new JButton("A�adir al carrito");
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
		panelS.add(a�adir);

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
		
		a�adir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Producto producto = listaProducto.getSelectedValue();
<<<<<<< HEAD

				if (producto instanceof Ropa) {
					Ropa nueva;
					Ropa ropa = (Ropa) listaProducto.getSelectedValue();
					nueva = new Ropa(ropa);

					modeloCarro.addElement(nueva);
=======
				
				if(producto instanceof Camiseta) {
					Camiseta nueva;
					Camiseta camiseta = (Camiseta) listaProducto.getSelectedValue();
					nueva = new Camiseta(camiseta);
					
					modeloCarro.addElement(nueva);	
>>>>>>> refs/remotes/origin/Mikel
					tienda.getCarro().getProducto().add(nueva);
<<<<<<< HEAD

				} else if (producto instanceof Deporte) {
					Deporte nueva;
					Deporte deporte = (Deporte) listaProducto.getSelectedValue();
					nueva = new Deporte(deporte);

					modeloCarro.addElement(nueva);
					tienda.getCarro().getProducto().add(nueva);

=======
					
				} else if (producto instanceof Balon) {
					Balon nueva;
					Balon balon = (Balon) listaProducto.getSelectedValue();
					nueva = new Balon(balon);
					
					modeloCarro.addElement(nueva);	
					tienda.getCarro().getProducto().add(nueva);	
					
>>>>>>> refs/remotes/origin/Mikel
				} else if (producto instanceof Ordenador) {
					Ordenador nueva;
					Ordenador ordenador = (Ordenador) listaProducto.getSelectedValue();
					nueva = new Ordenador(ordenador);

					modeloCarro.addElement(nueva);
					tienda.getCarro().getProducto().add(nueva);
				} else {
<<<<<<< HEAD
					Maquillaje nueva;
					Maquillaje maquillaje = (Maquillaje) listaProducto.getSelectedValue();
					nueva = new Maquillaje(maquillaje);

					modeloCarro.addElement(nueva);
					tienda.getCarro().getProducto().add(nueva);
				}

=======
					PintaLabios nueva;
					PintaLabios pintalabios = (PintaLabios) listaProducto.getSelectedValue();
					nueva = new PintaLabios(pintalabios);
					
					modeloCarro.addElement(nueva);	
					tienda.getCarro().getProducto().add(nueva);	
				} 
					
>>>>>>> refs/remotes/origin/Mikel
			}
		});

		botonComprar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

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

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("TIENDA DE ROPA");
		setSize(900, 500);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
