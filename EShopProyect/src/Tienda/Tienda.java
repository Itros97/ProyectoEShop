package Tienda;


import java.io.Serializable;
import java.util.ArrayList;

import Producto.Producto;
import Usuario.Usuario;

public class Tienda implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Usuario conectado;
	private String nombre;
	private Carro carro;
	private ArrayList<Usuario> clientes;
	private ArrayList<Producto> productos;	

	public Tienda(Usuario conectado, String nombre, Carro carro, ArrayList<Usuario> usuarios, ArrayList<Producto> productos) {
		super();
		this.conectado = conectado;
		this.nombre = nombre;
		this.carro = carro;
		this.clientes =  new ArrayList<Usuario>(clientes);
		this.productos = new ArrayList<Producto>(productos);
	}

	public Tienda() {
		super();
		this.conectado = new Usuario();
		this.nombre = "";
		this.carro = new Carro();
		this.clientes = new ArrayList<Usuario>();
		this.productos = new ArrayList<Producto>();
	}

	public Usuario getConectado() {
		return conectado;
	}

	public void setConectado(Usuario conectado) {
		this.conectado = conectado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public ArrayList<Usuario> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Usuario> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	
	
}

