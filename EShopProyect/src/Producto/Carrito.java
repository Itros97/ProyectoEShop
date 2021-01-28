package Producto;

public class Carrito {

	public int id_carrito;
	public String nickname;
	public String nombre;
	public String codigoac;
	public double precio;
	
	public Carrito(int id_carrito, String nickname, String nombre,String codigoac, double precio) {
		super();
		this.id_carrito = id_carrito;
		this.nickname = nickname;
		this.nombre = nombre;
		this.codigoac = codigoac;
		this.precio = precio;
	}
	public Carrito() {
		super();
		this.id_carrito = 0;
		this.nickname = "Por defecto";
		this.nombre = "Objeto generico";
		this.codigoac = "CodigoAcceso";
		this.precio = 0;
	}

	public int getId_carrito() {
		return id_carrito;
	}

	public void setId_carrito(int id_carrito) {
		this.id_carrito = id_carrito;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	public String getCodigoac() {
		return codigoac;
	}
	public void setCodigoac(String codigoac) {
		this.codigoac = codigoac;
	}
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "\nNombre=" + nombre + "\nPrecio="
				+ precio;
	}
	
	
}
