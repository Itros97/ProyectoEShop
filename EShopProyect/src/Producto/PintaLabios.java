package Producto;

public class PintaLabios extends Producto {
	protected String tipoMaquillaje;
	protected String color;
	protected double cantidad;
	
	public PintaLabios(double precio, int stock, String descripcion, String imagen, String marca, String tipoMaquillaje,
			String color, double cantidad) {
		super(precio, stock, descripcion, imagen, marca);
		this.tipoMaquillaje = tipoMaquillaje;
		this.color = color;
		this.cantidad = cantidad;
	}
	
	public PintaLabios() {
		super();
		this.tipoMaquillaje = "";
		this.color = "";
		this.cantidad = 0.0;
	}
	
	public PintaLabios(PintaLabios m) {
		super(m.precio, m.stock, m.descripcion, m.imagen, m.marca);
		this.tipoMaquillaje = m.tipoMaquillaje;
		this.color = m.color;
		this.cantidad = m.cantidad;
	}

	public String getTipoMaquillaje() {
		return tipoMaquillaje;
	}

	public void setTipoMaquillaje(String tipoMaquillaje) {
		this.tipoMaquillaje = tipoMaquillaje;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Maquillaje [tipoMaquillaje=" + tipoMaquillaje + ", color=" + color + ", cantidad=" + cantidad
				+ ", precio=" + precio + ", stock=" + stock + ", descripcion=" + descripcion + ", imagen=" + imagen
				+ ", marca=" + marca + "]";
	}
	
	
}
