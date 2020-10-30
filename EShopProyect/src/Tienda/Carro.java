package Tienda;

import java.io.Serializable;
import java.util.ArrayList;

import Producto.Producto;

public class Carro implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private double precioTotal;
	private int cantidad;
	private ArrayList<Producto> producto;
	
	public Carro(double precioTotal, int cantidad, ArrayList<Producto> ropa) {
		super();
		this.precioTotal = precioTotal;
		this.cantidad = cantidad;
		this.producto = new ArrayList<Producto>(producto);
	}
	
	public Carro() {
		super();
		this.precioTotal = 0.0;
		this.cantidad = 0;
		this.producto = new ArrayList<Producto>();
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public ArrayList<Producto> getRopa() {
		return producto;
	}

	public void setRopa(ArrayList<Producto> producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "Carro [precioTotal=" + precioTotal + ", cantidad=" + cantidad + ", producto=" + producto + "]";
	}
	
	
}


