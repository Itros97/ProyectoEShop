package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Producto.Deporte;
import Producto.Maquillaje;
import Producto.Ordenador;
import Producto.Producto;
import Producto.Ropa;
import Tienda.Tienda;

public class VentanaTienda extends JFrame{

	JMenuBar barra;
	JMenu cliente;
	
	JPanel arriba;
	JPanel abajo;
	JPanel panelSumar;
	JPanel panelCarrito;
	
	JList<Producto> listaProducto;
	DefaultListModel<Producto> modeloProducto;
	JList<Producto> listaCarro;
	DefaultListModel<Producto> modeloCarro;
	JButton sumarAlCarrito;
	JButton eliminarDelCarrito;
	JButton comprarProducto;
	JScrollPane scrollProducto;
	JScrollPane scrollCarro;
	VentanaTienda ventana;
	
	
	public VentanaTienda(Tienda tienda) {
		
		ventana = this;
		
		setLayout(new GridLayout(2,1));
		barra = new JMenuBar();
		cliente = new JMenu("Cliente");

		barra.add(cliente);
		
		JPanel arriba = new JPanel();
		JPanel abajo = new JPanel();
		
		arriba.setLayout(new BorderLayout());
		abajo.setLayout(new BorderLayout());
		
		modeloProducto = new DefaultListModel<Producto>();
		listaProducto = new JList<Producto>(modeloProducto);
		scrollProducto = new JScrollPane(listaProducto);
		
		for(Producto ropa : tienda.getProductos()) {
			modeloProducto.addElement(ropa);
		}
		
		modeloCarro = new DefaultListModel<Producto>();
		listaCarro = new JList<Producto>(modeloCarro);
		scrollCarro = new JScrollPane(listaCarro);
		
		panelSumar =  new JPanel();
		sumarAlCarrito = new JButton("Anyadir al carrito");
		
sumarAlCarrito.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Producto producto = listaProducto.getSelectedValue();
				
				if(producto instanceof Ropa) {
					Ropa nueva;
					Ropa ropa = (Ropa) listaProducto.getSelectedValue();
					nueva = new Ropa(ropa);
					
					modeloCarro.addElement(nueva);	
					tienda.getCarro().getProducto().add(nueva);
					
				} else if (producto instanceof Deporte) {
					Deporte nueva;
					Deporte deporte = (Deporte) listaProducto.getSelectedValue();
					nueva = new Deporte(deporte);
					
					modeloCarro.addElement(nueva);	
					tienda.getCarro().getProducto().add(nueva);	
					
				} else if (producto instanceof Ordenador) {
					Ordenador nueva;
					Ordenador ordenador = (Ordenador) listaProducto.getSelectedValue();
					nueva = new Ordenador(ordenador);
					
					modeloCarro.addElement(nueva);	
					tienda.getCarro().getProducto().add(nueva);	
				} else {
					Maquillaje nueva;
					Maquillaje maquillaje = (Maquillaje) listaProducto.getSelectedValue();
					nueva = new Maquillaje(maquillaje);
					
					modeloCarro.addElement(nueva);	
					tienda.getCarro().getProducto().add(nueva);	
				} 
					
			}
		});
		
		panelSumar.add(sumarAlCarrito);
		arriba.add(scrollProducto);
		arriba.add(panelSumar, BorderLayout.SOUTH);
		
		panelCarrito = new JPanel();
		
		comprarProducto = new JButton("Comprar");
		
		comprarProducto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		
		eliminarDelCarrito = new JButton("Eliminar");
		
		eliminarDelCarrito.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Producto producto = listaCarro.getSelectedValue();
				tienda.getCarro().getProducto().remove(producto);
				modeloCarro.removeElement(producto);
			}
		});
		
		panelCarrito.add(comprarProducto);
		panelCarrito.add(eliminarDelCarrito);
		
		
		abajo.add(scrollCarro);
		abajo.add(panelCarrito, BorderLayout.SOUTH);
		
		add(arriba);
		add(abajo);
		setJMenuBar(barra);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("TIENDA DE ROPA");
		setSize(900, 900);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
