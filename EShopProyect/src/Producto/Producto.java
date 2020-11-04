package Producto;

import java.io.Serializable;

/*
La clase producto sera la clase padre, de la cual heredaran los diferentes tipos de productos.
En esta clase encontraremos un atributo llamado Categoria que sirve para luego poder ondenar
los diferente productos en categorias.
*/

public class Producto implements Serializable {
	protected double precio;
	protected int stock;
	protected String descripcion;
	protected String imagen;
	protected String marca;
	protected Categoria categoria;

	public Producto(double precio, int stock, String descripcion, String imagen, String marca, Categoria categoria) {
		super();
		this.precio = precio;
		this.stock = stock;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.marca = marca;
		this.categoria = categoria;

	}

	public Producto() {
		super();
		this.precio = 0.0;
		this.stock = 0;
		this.descripcion = "";
		this.imagen = "";
		this.marca = "";
		this.categoria = Categoria.CUALQUIERA;
	}

	public Producto(Producto p) {
		super();
		this.precio = p.precio;
		this.stock = p.stock;
		this.descripcion = p.descripcion;
		this.imagen = p.imagen;
		this.marca = p.marca;
		this.categoria = p.categoria;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
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
		return "Producto [precio=" + precio + ", stock=" + stock + ", descripcion=" + descripcion + ", imagen=" + imagen
				+ ", marca=" + marca + "]";
	}

}
