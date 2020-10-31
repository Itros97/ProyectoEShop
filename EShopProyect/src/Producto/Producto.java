package Producto;

import java.io.Serializable;

public class Producto implements Serializable{
	protected double precio;
	protected int stock;
	protected String descripcion;
	protected String imagen;
	
	public Producto(double precio, int stock, String descripcion, String imagen) {
		super();
		this.precio = precio;
		this.stock = stock;
		this.descripcion = descripcion;
		this.imagen = imagen;
	}
	
	public Producto() {
		super();
		this.precio = 0.0;
		this.stock = 0;
		this.descripcion = "";
		this.imagen = "";
	}
	
	public Producto(Producto p) {
		super();
		this.precio = p.precio;
		this.stock = p.stock;
		this.descripcion = p.descripcion;
		this.imagen = p.imagen;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Ropa [precio=" + precio + ", stock=" + stock
				+ ", descripcion=" + descripcion + "]";
	}


	
}


