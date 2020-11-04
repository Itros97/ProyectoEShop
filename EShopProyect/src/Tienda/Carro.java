package Tienda;

import java.io.Serializable;

import java.util.ArrayList;

import Producto.Producto;

/*
En esta clase se iran añadiendo los productos que quiera comprar el usuario, se contara
la cantidad de productos que quiere comprar y se sumara el precio total de todos los 
productos.
*/

public class Carro implements Serializable {

	private static final long serialVersionUID = 1L;

	private double precioTotal;
	private int cantidad;
	private ArrayList<Producto> producto;

	public Carro(double precioTotal, int cantidad, ArrayList<Producto> producto) {
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

	public ArrayList<Producto> getProducto() {
		return producto;
	}

	public void setProducto(ArrayList<Producto> producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "Carro [precioTotal=" + precioTotal + ", cantidad=" + cantidad + ", producto=" + producto + "]";
	}

}
