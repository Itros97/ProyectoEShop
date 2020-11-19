package Producto;

/*
Tipo de producto ordenadores.
*/

public class Ordenador extends Producto {
	protected double pulgadas;
	protected String resolucion;
	protected int memoriaRam;
	protected int almacenamiento;
	protected String color;

	public Ordenador(String nombre, double precio, int stock, String descripcion, String imagen, String marca, Categoria categoria,
			double pulgadas, String resolucion, int memoriaRam, int almacenamiento, String color) {
		super(nombre, precio, stock, descripcion, imagen, marca, categoria);
		this.pulgadas = pulgadas;
		this.resolucion = resolucion;
		this.memoriaRam = memoriaRam;
		this.almacenamiento = almacenamiento;
		this.color = color;
	}

	public Ordenador() {
		super();
		this.pulgadas = 0.0;
		this.resolucion = "";
		this.memoriaRam = 0;
		this.almacenamiento = 0;
		this.color = "";
	}

	public Ordenador(Ordenador o) {
		super(o.nombre, o.precio, o.stock, o.descripcion, o.imagen, o.marca, o.categoria);
		this.pulgadas = o.pulgadas;
		this.resolucion = o.resolucion;
		this.memoriaRam = o.memoriaRam;
		this.almacenamiento = o.almacenamiento;
		this.color = o.color;
	}

	public double getPulgadas() {
		return pulgadas;
	}

	public void setPulgadas(double pulgadas) {
		this.pulgadas = pulgadas;
	}

	public String getResolucion() {
		return resolucion;
	}

	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

	public int getMemoriaRam() {
		return memoriaRam;
	}

	public void setMemoriaRam(int memoriaRam) {
		this.memoriaRam = memoriaRam;
	}

	public int getAlmacenamiento() {
		return almacenamiento;
	}

	public void setAlmacenamiento(int almacenamiento) {
		this.almacenamiento = almacenamiento;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Ordenador [pulgadas=" + pulgadas + ", resolucion=" + resolucion + ", memoriaRam=" + memoriaRam
				+ ", almacenamiento=" + almacenamiento + ", color=" + color + ", precio=" + precio + ", stock=" + stock
				+ ", descripcion=" + descripcion + ", imagen=" + imagen + ", marca=" + marca + "]";
	}

}
