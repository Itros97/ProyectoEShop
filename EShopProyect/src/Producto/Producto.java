package Producto;

import java.io.Serializable;

public class Producto implements Serializable{
	protected double precio;
	protected int stock;
	protected TipoDeProducto ProductoTipo;
	protected String descripcion;
	protected String imagen;
	protected String marca;
	
	public Producto(double precio, int stock, String descripcion, String imagen, String marca) {
		super();
		this.precio = precio;
		this.stock = stock;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.marca = marca;
	}
	//Constructor con enumeracion
	public Producto(double precio, int stock, TipoDeProducto ProductoTipo, String descripcion, String imagen, String marca) {
		super();
		this.precio = precio;
		this.stock = stock;
		this.ProductoTipo = ProductoTipo;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.marca = marca;
	}
	
	public Producto() {
		super();
		this.precio = 0.0;
		this.stock = 0;
		this.descripcion = "";
		this.imagen = "";
		this.marca = "";
	}
	
	public Producto(Producto p) {
		super();
		this.precio = p.precio;
		this.stock = p.stock;
		this.descripcion = p.descripcion;
		this.imagen = p.imagen;
		this.marca = p.marca;
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


